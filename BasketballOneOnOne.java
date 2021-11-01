package icpc2019;
import java.util.Scanner;
//Problem A of ICPC 2019 Regional
public class BasketballOneOnOne {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int A = 0;
		int B = 0;
		String line = scan.nextLine();
		for (int i = 0; i<line.length(); i+=2) {
			if (line.charAt(i)=='A') {
				A+=Integer.parseInt(line.substring(i+1, i+2));
			}
			else {
				B+=Integer.parseInt(line.substring(i+1, i+2));
			}
			if (A>=11 && A-B>1) {
				System.out.println("A");
			}
			else if (B>=11 && B-A>1) {
				System.out.println("B");
			}
		}
	}
}
