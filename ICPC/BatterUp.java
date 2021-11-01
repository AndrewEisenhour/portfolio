import java.util.Scanner;
public class BatterUp {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int numBatters = Integer.parseInt(scan.nextLine());
		int numAB;
		String[] ABs;
		for (int i = 0; i<numBatters; i++) {
			
			numAB = Integer.parseInt(scan.nextLine());
			ABs = scan.nextLine().split(" ");
			if (i==numBatters-1) {
				scan.close();
			}
			System.out.println(calcSlug(ABs));
			
		}
	}

public static double calcSlug(String[] ABs) {
	int AB = 0;
	int totalBases = 0;
	for (int i = 0; i<ABs.length; i++) {
		if (Integer.parseInt(ABs[i])==-1) {
			continue;
		}
		else {
			totalBases += Integer.parseInt(ABs[i]);
			AB++;
		}
	}
	return (double)totalBases/AB;
}
}
/*
3
3
3 0 2
11
-1 -1 -1 -1 0 0 0 0 0 0 1
3
1 -1 4

*/