import java.util.*;
public class Typesetting {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		boolean done = false;
		while(!done) {
			int n = Integer.parseInt(scan.nextLine());
			char[][] glyph = new char[n][20];
			for (int i = 0; i<n; i++) {
				glyph[i] = scan.nextLine().toCharArray();
			}
			int numLetters = 0;
			int len = glyph[0].length;
			for (int i = 0; i<len; i++) {
				if (glyph[0][i]==' ') {
					numLetters++;
				}
			}
			numLetters+=1;
			int numCopy = numLetters;
			for (int i = 0; i<numLetters; i++) {
				int startHorizontal;
				for (int j = 0; j<len; j++) {
					if (glyph[0][j]==' ') {
						numCopy--;
					}
				}
			}
		}
	}
}
