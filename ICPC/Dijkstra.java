import java.util.Scanner;

public class Dijkstra {
	public static void main(String args[]) {
		int[][] matrix = new int[5][5];
		int[] A = { 0, 5, 3, 3, 5 };
		int[] B = { 5, 0, 2, 3, 5 };
		int[] C = { 3, 2, 0, 1, 4 };
		int[] D = { 3, 3, 1, 0, 1 };
		int[] E = { 5, 5, 4, 1, 0 };
		matrix[0] = A;
		matrix[1] = B;
		matrix[2] = C;
		matrix[3] = D;
		matrix[4] = E;
		int start = 1;
		int finish = 4;
		int cur = start;
		int tempDistance;
		int min = 1000;
		boolean[] vis = { false, false, false, false, false };
		int[] dis = { 1000, 1000, 1000, 1000, 1000 };
		int[] last = { -1, -1, -1, -1, -1 };
		while (!vis[finish]) {
			for (int i = 0; i < dis.length; i++) {
				tempDistance = 0;
				if (!vis[i] && matrix[cur][i] != 0) {
					tempDistance = matrix[cur][i] + dis[cur];
					if (tempDistance > 1000) {
						tempDistance -= 1000;
					}
					if (tempDistance < dis[i]) {
						last[i] = cur;
						dis[i] = tempDistance;
						//System.out.println("Modified");
					}
					
				}
			}
			for (int o : dis) {
				System.out.println(o);
			}
			//System.out.println("Made it");
			vis[cur] = true;
			min = 1001;
			for (int j = 0; j < dis.length; j++) {
				if (!vis[j]) {
					if (dis[j]<min) {
						cur = j;
						min = dis[j];
					}
				}
			}

		}
		for (int k : dis) {
			System.out.println(k);
		}
	}
}
