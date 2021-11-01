import java.util.Scanner;

public class LineThemUp {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			int numNames = Integer.parseInt(scan.nextLine());
			String[] names = new String[numNames];
			for (int i = 0; i < numNames; i++) {
				names[i] = scan.nextLine();
			}
			int inc = comp(names);
			if (inc == 1) {
				System.out.println("DECREASING");

			}
			if (inc == 0) {
				System.out.println("NEITHER");
			}
			if (inc == -1) {
				System.out.println("INCREASING");
			}
			if (!scan.hasNextLine()) {
				break;
			}
		}
		scan.close();
	}

	public static int comp(String[] names) {
		int numNames = names.length;
		int val = 0;
		int prevVal = 0;
		for (int i = 0; i < numNames - 1; i++) {

			String a = names[i];
			String b = names[i + 1];
			if (a.compareTo(b) < 0) {
				val = -1;
			} else if (a.compareTo(b) > 0) {
				val = 1;
			}
			if (i==0) {
				prevVal = val;
			}
			if (val != prevVal) {
				val = 0;
				break;
			}

		}
		return val;
	}
}
