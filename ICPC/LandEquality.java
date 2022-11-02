import java.util.*;

public class LandEquality {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();
		int[][] arr = new int[i][j];
		int cur;
		int zeroes = 0;
		int ones = 0; 
		int twos = 0;
		for (int m = 0; m < i; m++) {
			for (int n = 0; n < j; n++) {
				cur = scan.nextInt();
				arr[m][n] = cur;
				if (cur==0) {
					zeroes++;
				}
				else if (cur==1) {
					ones++;
				}
				else {
					twos++;
				}
			}
		}
		int total = i*j;
		if (zeroes>=2) {
			System.out.println("0");
		}
		else if (ones==total) {
			System.out.println("0");
		}
		else if (twos==total || twos+ones==total || zeroes==0) {
			if (twos%2==0) {
				System.out.println("0");
			}
			else {
				int n = twos/2;
				System.out.println((int)(Math.pow(2, n+1)-Math.pow(2, n)));
			}
		}
		else if (zeroes==1 && twos==0) {
			System.out.println("1");
		}
		else if (zeroes==1 && ones>0) {
			System.out.println("1");
		}
		else {
			System.out.println("2");
		}
		
		
	}
}
/*
3 4
1 2 1 1
2 0 1 2
1 2 2 2

*/
