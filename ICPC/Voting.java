import java.util.Scanner;
public class Voting {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line;
		char[] letters;
		int y;
		int n;
		int a;
		int p;
		int total;
		String output = "";
		line = scan.nextLine();
		while(scan.hasNext()) {
			y = 0;
			n = 0;
			a = 0;
			p = 0;
			total = 0;
			
			output += "\n";
			if (line.length()==1) break;
			
			letters = line.toCharArray();
			for(char letter: letters) {
				total++;
				if (letter=='Y') y++;
				else if(letter=='N') n++;
				else if(letter=='A') a++;
				else p++;
				
			}
			if (a*2>=total) {
				output = output + "need quorum";
			}
			if (y>n) {
				output += "yes";
			}
			else if (y<n) {
				output += "no";
			}
			else if(y==n && a*2<total) output+="tie";
			line = scan.nextLine();
			if (line.length()==1) {
				break;
			}
			
		}
		System.out.println(output);
	}
}
