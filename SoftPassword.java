package icpc2019;
import java.util.*;
public class SoftPassword {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String pass1 = scan.nextLine();
		String pass2 = scan.nextLine();
		boolean works = check(pass1, pass2);
		/*if (!works) {
			works = check(pass1, pass2);
		}*/
		
		if (works) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	private static boolean check(String pass1, String pass2) {
		if (pass1.contentEquals(pass2)) {
			return true;
		}
		else if (pass1.substring(1).contentEquals(pass2) && Character.isDigit(pass1.charAt(0))) {
			return true;
		}
		else if (pass1.substring(0, pass1.length()-1).contentEquals(pass2) && Character.isDigit(pass1.charAt(pass1.length()-1))) {
			return true;
		}
		else if (checkCase(pass1, pass2)) {
			return true;
		}
		return false;
	}
	private static boolean checkCase(String a, String b) {
		char[] stringB = b.toCharArray();
		for (int i = 0; i<stringB.length; i++) {
			char c = stringB[i];
			if (Character.isUpperCase(c)) {
				stringB[i] = Character.toLowerCase(c);
			}
			else if (Character.isLowerCase(c)) {
				stringB[i] = Character.toUpperCase(c);
			}
		}
		b = new String(stringB);
		if (a.contentEquals(b)) {
			return true;
		}
		return false;
	}
}

