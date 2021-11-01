import java.util.Random;

public class Puzzle { // Does all movements and thinking for the slide puzzle
	int[] board; // integer array that represents the board
	int blank; // index of the blank space
	int curr; // current value used only near beginning
	int rows; // number of rows
	int cols; // number of columns
	int count; // records number of moves

	public Puzzle(int[] board1, int row, int col) { // initialize the puzzle with input
		board = board1;
		rows = row;
		cols = col;
		count = -10000; // initialized to -10000 as scramble will move 10000 times
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				blank = i;
			}
			if (board[i] == 1) {
				curr = i;
			}
		}
	}

	public int find(int num) { // find a given value in the puzzle, linear search
		for (int i = 0; i < board.length; i++) {
			if (board[i] == num) {
				return i;
			}
		}
		return -1;
	}

	public void scramble() { // randomly scramble the puzzle with 10000 moves
		int random;
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < 10000; i++) {
			random = rand.nextInt(4) + 1;

			switch (random) {
			case 1:
				if (blank % cols != 0) {
					left();

				}
				break;
			case 2:
				if ((blank + 1) % cols != 0 || blank == 0) {
					right();

				}
				break;
			case 3:
				if ((blank + cols) < (rows * cols)) {
					down();

				}
				break;
			case 4:
				if (blank - cols > -1) {
					up();

				}
				break;
			}
		}

	}

	private void left() { // move the blank to the left, that is to say move the piece to the left of the
							// blank to the right
		// System.out.println("left");
		board[blank] = board[blank - 1];
		board[blank - 1] = 0;
		blank--;
		if ((blank + 1) % cols == 0) {

			System.out.println("LEFT ERROR");
		}
		count++;
		animate();

	}

	private void right() { // move the blank to the right, that is to say move the piece to the right of
							// the blank to the left
		// System.out.println("right");
		board[blank] = board[blank + 1];
		board[blank + 1] = 0;
		blank++;
		if ((blank) % cols == 0) {

			System.out.println("RIGHT ERROR");
		}
		count++;
		animate();

	}

	private void up() { // move the blank up
		// System.out.println("up");
		board[blank] = board[blank - cols];
		board[blank - cols] = 0;
		blank -= cols;
		if (blank < 0) {
			System.out.println("UP ERROR");
		}
		count++;
		animate();

	}

	private void down() { // move the blank down
		// System.out.println("down");
		board[blank] = board[blank + cols];
		board[blank + cols] = 0;
		blank += cols;
		if (blank - 1 > board.length) {
			System.out.println("DOWN ERROR");
		}
		count++;
		animate();

	}

	public void print() { // pretty print for the array, only works on double digit numbers or less
		String dash = new String(new char[cols * 4]).replace("\0", "-");
		String output = "\n" + dash + "\n|";
		for (int i = 0; i < board.length; i++) {
			if (i % cols == 0 && i > 0) {
				output += "\n";
				output += dash + "\n|";
			}
			if (board[i] > 9)
				output += board[i] + " |";
			else
				output += board[i] + "  |";
		}
		output += "\n" + dash;
		System.out.println(output);
	}

	private void animate() { // animates the printing, does not include scramble
		if (count >= 0) {
			print();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
		}
	}

	public void solver() { // begins solving the puzzle
		count = 0;

		for (int i = 1; i < (rows - 2) * cols; i += cols) { // solve each row
			solveRow(i);
		}

		for (int i = rows * cols - 2 * cols; i < rows * cols - cols - 2; i++) { // solve the bottom tiles
			solveBottomTile(i + 1);

		}
		rotateAndCheck(); // finally perform rotation
		System.out.println("Solved in " + count + " moves!");
	}

	private void solveRow(int startIndex) { // solve row by individual tiles
		for (int i = startIndex; i < cols + startIndex; i++) {
			solveTile(i);
		}
	}

	private void solveTile(int num) { // solves each tile by breaking down the cases
		int loc = find(num); // current location

		int finalLoc = num - 1; // final destination

		while (loc != finalLoc) {
			loc = find(num);
			// Check if it will be in a corner, special case
			if (isCorner(finalLoc)) {

				solveCorner(loc, finalLoc);
				break;
			}
			// Check if it is currently in the bottom right corner
			if (loc == rows * cols - 1) {
				moveLeft(loc);
				right();
				loc--;

			}

			// Bottom row condition
			if (loc >= cols * (rows - 1)) {
				moveRight(loc);
				up();
				left();
				down();
				loc -= cols;
			}
			// Need to move to the right
			if (loc % cols - finalLoc % cols < 0) {

				moveBelow(loc);

				right();
				up();
				left();
				loc++;

			}
			// Need to move to the left
			else if (loc % cols - finalLoc % cols > 0) {

				moveBelow(loc);

				left();
				up();
				right();
				loc--;

			}
			// It is too low
			else if (loc / cols - finalLoc / cols > 0) {
				// print();
				moveRight(loc);
				up();
				left();
				down();
				loc -= cols;
			}
		}
	}

	private void moveBelow(int loc) { // move the blank below a certain location
		// System.out.println("move below");
		while (!isBelow(loc)) {
			// Too high
			if (blank / cols - loc / cols <= 0) {

				if (blank - loc == -cols) {
					if ((blank + 1) % rows == 0) {
						left();
					} else {
						right();
					}
				}
				down();
			}
			// Too low
			else if (blank / cols - loc / cols > 1) {
				// System.out.println("up");
				up();
			}
			// Too far to the left
			else if (blank % cols - loc % cols < 0) {
				// System.out.println("right");
				right();
			}
			// Too far to the right
			else if (blank % cols - loc % cols > 0) {
				// System.out.println("left");
				left();
			}

		}
		// System.out.println("finished");
	}

	private void moveRight(int loc) { // move to the right of a specified location
		// System.out.println(blank + " " + loc);
		while (!isRight(loc)) {
			// System.out.println(loc);
			// check whether the loc is to the right of blank
			if (blank % cols - loc % cols <= 0) {
				if (blank - loc == -1 && blank + cols < rows * cols) {
					down();
					right();
				} else if (blank - loc == -1) {
					up();
					right();
				}
				right();
				// if the blank it too high
			} else if (blank / cols - loc / cols < 0) {
				if (blank - loc == rows) {
					right();
				}
				down();

			}
			// check whether the loc is the left of the blank
			else if (blank % cols - loc % cols > 1) {
				// If the tile to the left is not already solved or should not already be
				// solved, move left
				if (board[blank - 1] != blank || board[loc] < board[blank - 1]) {
					left();
				}
				// If left is not an option
				else if (blank / cols - loc / cols == 0) {
					if (blank / cols < rows - 1) {
						down();
					} else {
						up();
					}
				}
			}
			// Too low
			else if (blank / cols - loc / cols > 0) {
				up();
			}

		}
	}

	private void moveLeft(int loc) { // moves to the left of a given location
		while (!isLeft(loc)) {
			if (blank % cols - loc % cols < -1) {
				right();

			} else if (blank % cols - loc % cols >= 0) {
				if (blank - loc == 1 && blank + cols < rows * cols) {
					down();

				} else if (blank - loc == 1) {
					up();
				}
				left();
			} else if (blank / cols - loc / cols < 0) {
				if (Math.abs(blank - loc) == cols) {
					left();
				}
				down();
			} else if (blank / cols - loc / cols > 0) {
				up();
			}

		}
	}

	private void solveCorner(int loc, int finalLoc) { // solving the special case of a corner
		// System.out.println("corner solve");
		int num = board[loc];
		finalLoc = finalLoc + cols;
		if (blank + cols < rows * cols) {
			down();
		}
		loc = find(num);
		if (board[board[loc] - 1] == board[loc]) {
			return;
		}

		while (loc != finalLoc) {
			// Check if it will be in a corner, special case
			if (loc == rows * cols - 1) {
				moveLeft(loc);
				right();
				loc--;

			}
			// Bottom row condition
			if (loc >= cols * (rows - 1)) {
				moveRight(loc);
				up();
				left();
				down();
				loc -= cols;
			}
			// Need to move to the right
			if (loc % cols - finalLoc % cols < 0) {
				moveBelow(loc);

				right();
				up();
				left();
				loc++;
			}
			// Need to move to the left
			else if (loc % cols - finalLoc % cols > 0) {
				moveBelow(loc);
				left();
				up();
				right();
				loc--;
			}
			// It is too low
			else if (loc / cols - finalLoc / cols > 0) {
				// print();
				moveLeft(loc);
				up();
				right();
				down();
				loc -= cols;
			}

		}
		if (board[finalLoc - cols] == board[finalLoc - cols] + 1) {
			return;
		}
		moveBelow(loc);
		// Special formula
		up();
		up();
		left();
		down();
		right();
		down();
		left();
		up();
		up();
		right();
		down();
	}

	private void solveBottomTile(int num) { // solving a generic bottom tile
		int loc = find(num + cols);
		num = num + cols;
		int finalLoc = num - 1;
		while (loc != finalLoc) {

			if (board[num - 1] == num) {
				break;
			}
			// print();
			// bottom right corner
			if (loc == rows * cols - 1) {
				moveLeft(loc);
				right();
				loc--;

			}
			// Bottom row condition
			if (loc >= cols * (rows - 1)) {
				if (loc - blank == 1) {
					right();
					loc--;

				} else {
					moveLeft(loc);
					right();
					loc--;
				}
			}
			// Need to move to the right

			// System.out.println(loc/rows-finalLoc/rows);
			// It is too high
			else if (loc / cols - finalLoc / cols < 0) {
				moveBelow(loc);
				up();
				loc += cols;
			}
			loc = find(num);
		}

		num -= cols;
		if ((blank + 1) % cols != 0) {
			right();
		}
		loc = find(num);
		if (board[num - 1] == num) {
			finalLoc = num - 1;
		} else {
			finalLoc = finalLoc - cols + 1;
		}

		while (loc != finalLoc) {
			// Check if it will be in a corner, special case
			if (loc == rows * cols - 1) {
				moveLeft(loc);
				right();
				loc--;

			}
			if (loc - blank == 1 && blank == finalLoc - 1) {
				right();
				loc--;
				break;
			}

			// Bottom row condition
			if (loc / cols == rows - 1) {
				moveRight(loc);
				up();
				left();
				down();
				loc -= cols;
			}
			// Need to move to the right

			if (loc % cols - finalLoc % cols < 0) {

				moveBelow(loc);

				right();
				up();
				left();
				loc++;

			}
			// Need to move to the left
			else if (loc % cols - finalLoc % cols > 0) {

				moveBelow(loc);

				left();
				up();
				right();
				loc--;

			}
			// System.out.println(loc/rows-finalLoc/rows);
			// It is too low
			else if (loc / cols - finalLoc / cols > 0) {
				// print();
				moveRight(loc);
				up();
				left();
				down();
				loc -= cols;
			}
		}

		if (board[num - 1] == num) {
			return;
		}
		moveRight(loc);
		if (board[num - 1] == num) {
			return;
		}
		// Special formula rotated
		left();
		left();
		down();
		right();
		up();
		right();
		down();
		left();
		left();
		up();
		right();

	}

	private boolean isCorner(int ind) {
		if ((ind + 1) % cols == 0 && ind + 1 > 0) {
			return true;
		}
		return false;
	}

	private boolean isRight(int loc) {
		return blank - 1 == loc;
	}

	private boolean isBelow(int loc) {
		return blank - cols == loc;
	}

	private boolean isLeft(int loc) {
		return blank + 1 == loc;
	}

	private boolean check() {
		for (int i = 0; i < board.length - 1; i++) {
			if (board[i] != i + 1) {
				return false;
			}
		}
		return true;
	}

	private void rotateAndCheck() { // Performs rotation on bottom four tiles
		if (blank == rows * cols - cols - 2) {
			right();
			down();
		} else if (blank == rows * cols - cols - 1) {
			down();
		} else if (blank == rows * cols - 2) {
			right();
		}
		int count = 0;
		// Rotate while it does not work
		// If there are any problems, perform another rotation and the bottom 3x2 will
		// be moved
		while (!check()) {
			left();
			up();
			right();
			down();
			count++;
			if (count % 3 == 0) {
				left();
				left();
				up();
				right();
				down();
				right();
			}
			if (count > 20) { // If it has not been solved by this point, we have failed
				break;
			}
		}

	}
}
