import java.util.Scanner;
public class ConsecutiveDigits {
	public static void main(String args[]) {
		boolean finish = false;
		double rem;
		double num = 0.2;
		
		while (!finish) {
			if (num<0) {
				break;
			}
			rem = num%7;
			num = (int)num/7;
			System.out.print(rem);
		}
	}
}
