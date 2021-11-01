package icpc2019;
import java.util.*;

public class CommemorativeRace {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] first = line.split(" ");
		int stations = Integer.parseInt(first[0]);
		int roads = Integer.parseInt(first[1]);
		int to;
		int from;
		int counter = 0;
		int[][] spots = new int[stations][stations];
		Set<Integer> froms = new HashSet<Integer>();
		while (counter < roads) {
			line = scan.nextLine();
			if (line.length() == 0) {
				break;
			}
			first = line.split(" ");
			from = Integer.parseInt(first[0]);
			to = Integer.parseInt(first[1]);
			froms.add(Integer.parseInt(first[0]));
			spots[from - 1][to - 1] = 1;
			counter++;
		}
		int max = 0;
		int max2 = 0;
		int temp;
		// System.out.println(froms);
		// Set<Integer> removes = new HashSet<Integer>();
		/*
		 * for (int i : froms) { temp = longestPath(spots, i - 1, 0); if (temp >= max) {
		 * max = temp; } else { removes.add(i); } } for (int i : froms) { temp =
		 * longestPath(spots, i - 1, 0); if (temp >= max) { //
		 * System.out.println("Set max: " + temp); max = temp; } else { removes.add(i);
		 * } }
		 */
		// froms.removeAll(removes);
		for (int i = 0; i < spots[0].length; i++) {
			for (int j = 0; j < spots[0].length; j++) {
				if (spots[i][j] == 1) {
					spots = longestPath2(spots, i, j);
				}
			}
		}
		// System.out.println(froms);
		// printArr(spots[0]);
		// System.out.println(max + "\n\n");
		int temp2;
		int temp3 = 0;
		int[] currRow;
		a: for (int i = 0; i < spots[0].length; i++) {
			for (int j = 0; j < spots[0].length; j++) {
				if (spots[i][j] >= 1) {
					max2 = 0;
					temp2 = spots[i][j];
					spots[i][j] = 0;
					// System.out.println("Breaking " + (i + 1) + " to " + (j + 1));
					currRow = spots[i];

					for (int k : froms) {
						spots[k - 1] = purge(spots[k - 1]);
						temp3 = 0;
						temp = tester(spots, k - 1);
						for (int l : froms) {
							temp3 = Math.max(temp3, longestPath(spots, l - 1, 0));
						}
						// System.out.println("temp3: " + temp3);
						if (temp >= max2 && temp == temp3) {
							// System.out.println("Changing to: " + temp);
							max2 = temp;
							if (max2 == 0) {
								max = 0;
								break a;
							}
						}
					}
					spots[i][j] = temp2;
					spots[i] = currRow;
					if (max2 < max && max2 > 0) {
						// System.out.println("Changing final to: " + max2);
						max = max2;
					}
				}
			}
		}
		System.out.println(max);

	}

	private static int[] purge(int[] matrix) {
		int max = 0;
		// printArr(matrix);
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i] > max) {
				max = matrix[i];
			}
		}
		// System.out.println("Max down here is: " + max);
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i] != max) {
				matrix[i] = 0;
			}
		}
		// printArr(matrix);
		return matrix;
	}

	private static int tester(int[][] matrix, int k) {
		int counter = 0;
		int next = -2;
		while (next != -1) {
			next = findMax(matrix, k);
			k = next;
			counter++;
		}
		counter--;
		return counter;
	}

	private static int findMax(int[][] matrix, int k) {
		int max = 0;
		int loc = -1;
		for (int i = 0; i < matrix[k].length; i++) {
			if (matrix[k][i] > max) {
				loc = i;
			}

		}
		// System.out.println(maxCount);
		return loc;
	}

	private static int[][] longestPath2(int[][] matrix, int start, int curr) {

		// System.out.println("Looking at: " + (start+1) + " node " + (curr+1));
		matrix[start][curr] = 1 + longestPath(matrix, curr, 0);
		return matrix;

	}

	private static int longestPath(int[][] matrix, int start, int curr) {

		// System.out.println("Looking at: " + (start+1));

		if (matrix[start][curr] >= 1) {
			// System.out.println("Going to: " + (curr+1));
			if (curr >= matrix[0].length - 1) {
				return 1 + longestPath(matrix, curr, 0);
			} else {
				return Math.max(1 + longestPath(matrix, curr, 0), longestPath(matrix, start, curr + 1));
			}
		} else {
			if (curr >= matrix[0].length - 1) {
				// System.out.println("End");
				return 0;
			}
			return longestPath(matrix, start, curr + 1);
		}
	}

	/*
	 * private int[] Djikstra(int matrix[][]) { int tempDistance; int min = 1000;
	 * boolean[] vis = { false, false, false, false, false }; int[] dis = { 1000,
	 * 1000, 1000, 1000, 1000 }; int[] last = { -1, -1, -1, -1, -1 }; while
	 * (!vis[finish]) { for (int i = 0; i < dis.length; i++) { tempDistance = 0; if
	 * (!vis[i] && matrix[cur][i] != 0) { tempDistance = matrix[cur][i] + dis[cur];
	 * if (tempDistance > 1000) { tempDistance -= 1000; } if (tempDistance < dis[i])
	 * { last[i] = cur; dis[i] = tempDistance; //System.out.println("Modified"); }
	 * 
	 * } } for (int o : dis) { System.out.println(o); }
	 * //System.out.println("Made it"); vis[cur] = true; min = 1001; for (int j = 0;
	 * j < dis.length; j++) { if (!vis[j]) { if (dis[j]<min) { cur = j; min =
	 * dis[j]; } } }
	 * 
	 * } return null; }
	 */
}
