import java.util.*;

public class NoDuplicates {
	public static void main(String[] args) {
		int reps;
		Scanner scan = new Scanner(System.in);
		reps = Integer.parseInt(scan.nextLine());
		for (int i = 0; i<reps; i++) {
			boolean repeats = false;
			String[] line = scan.nextLine().split(" ");
			//System.out.println(Arrays.toString(line));
			for (int j = 0; j<line.length; j++) {
				for (int k = j+1; k<line.length; k++) {
					if (line[j].equals(line[k])) {
						repeats = true;
					}
				}
			}
			if (!repeats) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}
