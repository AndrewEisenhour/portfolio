import java.util.*;

public class ParkingLot {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		char[][] lot = new char[r][c];
		char[] line;
		scan.nextLine();
		// Populate the data
		for (int i = 0; i < r; i++) {
			line = scan.nextLine().toCharArray();
			for (int j = 0; j < c; j++) {
				lot[i][j] = line[j];
			}
		}
		scan.close();
		// Total number of points
		int total = (r + 1) * (c + 1);
		Point a;
		double[][] distances = new double[total][total];
		// Initial distances set to -1, which means invalid
		for (int i = 0; i < total; i++) {
			for (int j = 0; j < total; j++) {
				distances[i][j] = -1;
			}
		}
		// Find the distances
		for (int i = 0; i < total; i++) {
			a = new Point(i % (c + 1), i / (c + 1));
			for (int j = i; j < total; j++) {
				distances[i][j] = dist(new Point(j % (c + 1), j / (c + 1)), a);

			}
		}
		double slopes[][] = new double[total][total];
		// Most important loop, calculates validity of any line
		for (int i = 0; i < total; i++) {
			for (int j = i; j < total; j++) {
				// Find the slope
				slopes[i][j] = slope(new Point(i % (c + 1), i / (c + 1)), new Point(j % (c + 1), j / (c + 1)));
				// We don't care about negative slopes, already covered
				if (slopes[i][j] < 0) {
					distances[i][j] = -1;
					continue;
				}
				// The x and y coordinates of our point
				double x = i % (c + 1);
				double y = (int) (i / (c + 1));
				// If we are at the edge, we don't need to worry about everything else
				if (y == r || x == c) {
					continue;
				}
				// If we are going from a point to the same point, we really don't need to
				// bother
				if (i == j) {
					continue;
				} else {
					// Slopes greater than one mean that we are going mostly up
					if (slopes[i][j] > 1 && slopes[i][j] < Double.POSITIVE_INFINITY && distances[i][j] > 0) {
						// Is the space we are going through occupied? If so, fail, otherwise, proceed.
						if (lot[(int) y][(int) x] == '#') {
							distances[i][j] = -1;
						} else {
							// Use a whiteboard or scratch paper to figure this guy out
							double adder = (double) ((double) (((j % (c + 1)) - ((i % (c + 1))))
									/ (double) (((j / (c + 1)) - (i / (c + 1))))));
							// While we are not at the destination point
							while (x != j % (c + 1) && y != (j / (c + 1))) {
								// Double square crossing scenario
								if (((x + adder) - (int) x) > 1) {
									if (lot[(int) y][(int) x + 1] == '#') {
										distances[i][j] = -1;
										break;
									}
								}
								// If the space we are crossing is a car, fail
								if (lot[(int) y][(int) x] == '#') {
									distances[i][j] = -1;
									break;
								}
								// Increment x and y
								x += adder;
								y++;
								// If we pass the edge, break
								if ((int) y >= r || (int) x >= c) {
									break;
								}
							}
						}
					} 
					// If the slope is less than one, that is a flatter line
					else if (slopes[i][j] < 1 && slopes[i][j] > 0 && distances[i][j] > 0) {
						// Check if we are on a parked in space
						if (lot[(int) y][(int) x] == '#') {
							distances[i][j] = -1;
						} else {
							// While we are not at our destination space
							while (x != j % (c + 1) && y != (j / (c + 1))) {
								double adder = (double) ((double) (((j / (c + 1)) - ((i / (c + 1))))
										/ (double) (((j % (c + 1)) - (i % (c + 1))))));
								// Double space crossing scenario
								if (((y + adder) - (int) y) > 1) {
									// Check if that space is parked up
									if (lot[(int) y + 1][(int) x] == '#') {
										distances[i][j] = -1;
										break;
									}
								}
								// Check if the next space is parked up
								if (lot[(int) y][(int) x] == '#') {
									distances[i][j] = -1;
									break;
								}
								// Increment 
								y += adder;
								x++;
								if (y >= r || x >= c) {
									break;
								}

							}
						}
					}
					// Else if the distance is greater than 0, that means we've got a diagonal line
					else if (distances[i][j] > 0) {
						while (x != j % (c + 1) && y != (j / (c + 1))) {
							if (lot[(int) y][(int) x] == '#') {
								distances[i][j] = -1;
							}
							x++;
							y++;
							if (y >= r || x >= c) {
								break;
							}
						}
					}
				}
			}
		}
		// Start Dijkstra
		double[] dist = new double[total];
		boolean[] vis = new boolean[total];
		int[] last = new int[total];
		for (int i = 0; i < total; i++) {
			dist[i] = -1;
			vis[i] = false;
			last[i] = -1;
		}
		int start = 0;
		int finish = total - 1;
		double tempDistance;
		double min;
		int cur = start;
		while (!vis[finish]) {
			for (int i = 0; i < dist.length; i++) {
				tempDistance = 0;
				if (!vis[i] && distances[cur][i] > 0) {
					if (dist[cur] > 0) {
						tempDistance = distances[cur][i] + dist[cur];
					} else {
						tempDistance = distances[cur][i];
					}
					if (tempDistance < dist[i] || dist[i] == -1) {
						last[i] = cur;
						dist[i] = tempDistance;
					}

				}
			}

			vis[cur] = true;
			min = Double.POSITIVE_INFINITY;
			for (int j = 0; j < dist.length; j++) {
				if (!vis[j]) {
					if (dist[j] < min && dist[j] > 0) {
						cur = j;
						min = dist[j];
					}
				}
			}
		}
		// Finally, you are done
		System.out.println(dist[total - 1]);
	}

	// Finds the distance between two points
	static double dist(Point a, Point b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}

	// Finds the slope between two points
	static double slope(Point a, Point b) {
		return (double) (b.y - a.y) / (double) (b.x - a.x);
	}

	// A pretty print method that was useful for debugging
	static void print(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.println("Distance from " + i + " " + j + ": " + arr[i][j]);
			}
		}
	}

}

// Subclass to make a point
class Point {
	int x;
	int y;

	Point(int _x, int _y) {
		x = _x;
		y = _y;
	}
}
