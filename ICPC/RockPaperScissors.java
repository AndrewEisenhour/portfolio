import java.util.Scanner;
public class RockPaperScissors {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		String l1 = sc.nextLine();
		String l2 = sc.nextLine();
		
		while(! l1.equals("E")) {
			int w1 = 0;
			int w2 = 0;
			for(int i = 0; i < l1.length(); i++) {
				if(l1.charAt(i) == 'R' && l2.charAt(i) == 'P')
					w2++;
				if(l1.charAt(i) == 'P' && l2.charAt(i) == 'R')
					w1++;
				if(l1.charAt(i) == 'S' && l2.charAt(i) == 'P')
					w1++;
				if(l1.charAt(i) == 'P' && l2.charAt(i) == 'S')
					w2++;
				if(l1.charAt(i) == 'R' && l2.charAt(i) == 'S')
					w1++;
				if(l1.charAt(i) == 'S' && l2.charAt(i) == 'R')
					w2++;
			}//for i
			
			System.out.println("P1: "+w1);
			System.out.println("P2: "+w2);
			
			l1 = sc.nextLine();
			l2 = sc.nextLine();
		}//while
	}
}
