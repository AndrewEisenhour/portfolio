package icpc2020;
import java.util.*;
public class Ocelots {
	public static void main(String args[]) {
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		scan.nextLine();
		char[] a = new char[n];
		int o = 0;
		int z = 0;
		for (int i = 0; i<n; i++) {
			a[i] = scan.nextLine().charAt(0);
			if (a[i]=='O') {
				o++;
			}
			
		}
		//System.out.println(o);
		if (o==0) {
			System.out.println('0');
		}
		else {
			System.out.println(ringBell(a, o));
		}
		
		
	}
	static int ringBell(char[] a, int o) {
		int count = 0;
		for (int i = a.length-1; i>=0; i--) {
			if (a[i]=='O') {
				//i = a.length;
				count++;
				a[i]='Z';
				o--;
				for (int j = i+1; j<a.length; j++) {
					if (a[j]=='Z') {
						a[j]='O';
						o++;
					}
				}
				
				//System.out.println(o);
				if (o==0) {
					return count;
				}
				i = a.length;
			}
		}
		return 0;
	}
}
