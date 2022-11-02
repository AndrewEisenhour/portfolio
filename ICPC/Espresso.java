import java.util.*;
public class Espresso {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int s = scan.nextInt();
		scan.nextLine();
		char cur[];
		int ounces;
		int count = 0;
		int capacity = s;
		while(n>0) {
			cur = scan.next().toCharArray();
			ounces = cur[0]-48;
			if (cur.length>1) {
				ounces++;
			}
			if (ounces>s) {
				s = capacity;
				count++;
			}
			s-=ounces;
			ounces = 0;
			n--;
		}
		System.out.println(count);
	}
}
