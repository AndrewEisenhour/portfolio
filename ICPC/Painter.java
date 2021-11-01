import java.util.*;
public class Painter {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		ArrayList<Integer> paints = new ArrayList<>();
		int numPaints;
		int gray;
		while(scan.hasNextLine()) {
			paints.clear();
			numPaints = scan.nextInt();
			for (int i = 0; i<numPaints; i++) {
				paints.add(scan.nextInt());
			}
			gray = scan.nextInt();
			scan.nextLine();
			if (gray==0) {
				int max = 0;
				for (int j:paints) {
					if (j/50+1>max && j%50!=0) {
						max = j/50+1;
					}
					else if (j/50>max && j%50==0) {
						max = j/50;
					}
				}
				System.out.println(max);
			}
			else {
				int req;
				if (gray%50==0) {
					req = gray/50;
				}
				else {
					req = gray/50 +1;
				}
				ArrayList<Integer> reqs = new ArrayList<>();
				int max = 0;
				for (int x:paints) {
					
					int temp = x/50;
					if (x%50==0) {
						x--;
					}
					if (temp>max) {
						max = temp;
					}
					reqs.add(temp);
				}
				
				for (int y : reqs) {
					System.out.println(y);
					
				}
			}
		}

	}

}
/*
3 40 95 21 0
7 25 60 400 250 0 60 0 500
*/