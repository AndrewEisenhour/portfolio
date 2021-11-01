import java.util.Scanner;
public class NineKnights {
	public static void main(String[] args) {
		String board = "";
		String output = "";
		int kCount = 0;
		Scanner scan = new Scanner (System.in);
		int tests = Integer.parseInt(scan.nextLine());
		boolean valid = true;
		for (int i = 0; i<tests; i++) {
			kCount = 0;
			valid = true;
			board="";
			for (int j = 0; j<5; j++) {
				board += scan.nextLine();
			}
			
			char[] spaces = board.toCharArray();
			for (int k = 0; k<spaces.length; k++) {
				if (spaces[k]=='k') {
					if (checkKnight(spaces, k)) {
						kCount++;
						continue;
					}
					else {
						valid = false;
					}
					
				}
			}
			if (valid && kCount==9) {
				output += "valid\n";
			}
			else {
				output += "invalid\n";
			}
			if (i==tests-1) {
				scan.close();
			}
			else {
				scan.nextLine();
			}
			
		}
		System.out.println(output.trim());
		scan.close();
	}
	public static boolean checkKnight(char[] board, int i) {
		if (i-7>0  && i%5>1) {
			if (board[i-7]=='k') {
				return false;
			}
		}
		if (i-11>0  && i%5>0) {
			if (board[i-11]=='k') {
				return false;
			}
		}
		if (i-9>0  && i%5<4) {
			if (board[i-9]=='k') {
				return false;
			}
		}
		if (i-3>0  && i%5<3) {
			if (board[i-3]=='k') {
				return false;
			}
		}
		if (i+3<25  && i%5>1) {
			if (board[i+3]=='k') {
				return false;
			}
		}
		if (i+9<25   && i%5>0) {
			if (board[i+9]=='k') {
				return false;
			}
		}
		if (i+11<25   && i%5<4) {
			if (board[i+11]=='k') {
				return false;
			}
		}
		if (i+7<25   && i%5<3) {
			if (board[i+7]=='k') {
				return false;
			}
		}
		return true;
	}
}
/*
2
.....
...k.
k.k.k
.k.k.
k.k.k

...k.
...k.
k.k..
.k.k.
k.k.k

.....
...k.
k.k.k
.k.k.
k...k
*/