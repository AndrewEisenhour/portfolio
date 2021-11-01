import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of rows: \n");
		int rows = scan.nextInt();
		System.out.println("Enter the number of columns: \n");
		int cols = scan.nextInt();
		if (rows < 2 || cols < 2) {
			System.out.println("That's not valid!");
		} else {
			int[] puzzle = new int[rows * cols];
			for (int i = 1; i < puzzle.length; i++) {
				puzzle[i - 1] = i;
			}
			puzzle[rows * cols - 1] = 0;

			// rows = 4;
			// cols = 4;
			// int count = 0;
			// while (count < 1000000) {
			Puzzle test = new Puzzle(puzzle, rows, cols);

			test.scramble();
			test.print();
			test.solver();
			test.print();
			// System.out.println(count);
			// }

		}
	}
}
