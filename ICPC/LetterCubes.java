import java.util.Scanner;
import java.util.LinkedList;
public class LetterCubes {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		String output = "";
		while (scan.hasNext()) {
			if (scan.nextLine().equals("0")) {
				System.out.println(output.trim());
			}
			LinkedList dice = new LinkedList();
			
			int length = scan.next().length();
			for (int i = 0; i<length; i++) {
				dice.add("");
			}
			String[] alph = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
			
		}
	}
}
