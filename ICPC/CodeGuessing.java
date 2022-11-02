import java.util.*;

public class CodeGuessing {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int p = scan.nextInt();
		int q = scan.nextInt();
		scan.nextLine();
		String letters = scan.nextLine();
		if (letters.equals("AABB")) {
			if ((p == 7 || q == 7) && (p != 8 || p != 9 || q != 8 || q != 9)) {
				System.out.println("8 9");
			} else {
				System.out.println("-1");
			}
		} else if (letters.equals("ABBA")) {
			if (Math.abs(p - q) == 3) {
				System.out.println((Math.min(p, q) + 1) + " " + (Math.max(p, q) - 1));
			} else {
				System.out.println("-1");
			}
		} else if (letters.equals("ABAB")) {
			if ((p == 6 || q == 6) && (p == 8 || q == 8)) {
				System.out.println("7 9");
			} else {
				System.out.println("-1");
			}
		} else if (letters.equals("BBAA")) {
			if ((p == 3 || q == 3) && (p != 1 || p != 2 || q != 1 || q != 2)) {
				System.out.println("1 2");
			} else {
				System.out.println("-1");
			}
		} else if (letters.equals("BAAB")) {
			if ((p == 2 || q == 2) && (p == 8 || q == 8)) {
				System.out.println("1 9");
			} else {
				System.out.println("-1");
			}
		} else if (letters.equals("BABA")) {
			if ((p == 2 || q == 2) && (p == 4 || q == 4)) {
				System.out.println("1 3");
			} else {
				System.out.println("-1");
			}
		}
	}
}
