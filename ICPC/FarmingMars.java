package icpc2019;
import java.util.*;
public class FarmingMars {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int a;
		int b;
		int avg;
		scan.nextLine();
		String[] pH = new String[n];
		for (int i = 0; i<n; i++) {
			pH[i] = scan.nextLine();
		}
		for (int i = 0; i<m; i++) {
			a = scan.nextInt();
			b = scan.nextInt();
			avg = (b-a+1)/2 + 1;
			solver(Arrays.copyOfRange(pH, a-1, b), avg);
		}
	}
	private static void solver(String[] pH, int avg) {
		Arrays.sort(pH);
		//System.out.println(pH.length);
		int count = 1;
		for (int i = 0; i<pH.length; i++) {
			if (i<pH.length-1) {
				//System.out.println(count);
				if (pH[i].equals(pH[i+1])) {
					count++;
				}
				else {
					count = 1;
				}
			}
			if (count>=avg) {
				System.out.println("usable");
				return;
			}
		}
		System.out.println("unusable");
	}
}
/*
8 4
7.000000
8.314634
7.000001
7.000000
2.581236
7.000000
2.581236
7.000000
1 8
1 3
4 8
5 7

*/
