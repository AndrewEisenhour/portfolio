import java.util.Scanner;

public class SquareDeal {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h1;
		int h2;
		int h3;
		int w1;
		int w2;
		int w3;
		int height;
		int width;
		boolean square;
		int temp;
		while (scan.hasNextInt()) {
			h1 = scan.nextInt();
			w1 = scan.nextInt();
			if (w1>h1) {
				temp = w1;
				w1 = h1;
				h1 = temp;
			}
			h2 = scan.nextInt();
			w2 = scan.nextInt();
			if (w2>h2) {
				temp = w2;
				w2 = h2;
				h2 = temp;
			}
			h3 = scan.nextInt();
			w3 = scan.nextInt();
			if (w3>h3) {
				temp = w3;
				w3 = h3;
				h3 = temp;
			}
			square = false;
			height = h1;
			width = w1;
			if (h1 == h2 && h2 == h3) {
				width = w1 + w2 + w3;

				if (width == height) {
					square = true;
				}
			} else if (w1 == w2 && w2 == w3) {
				height = h1 + h2 + h3;
				if (width == height) {
					square = true;
				}
			} 
			else if (w1==h2 && h2==w3) {
				height = h1 + w2 + h3;
				if (width == height) {
					square = true;
				}
			}
			else if (h1==w2 && w2==h3) {
				width = h2 + w1 + w3;
				if (width == height) {
					square = true;
				}
			}
			else if (h1==w2 && w2==h3) {
				width = w1 + h2 + w3;
				if (width == height) {
					square = true;
				}
			}
			else if (w1==h2 && h2==h3) {
				height = h1 + w2 + w3;
				if (width == height) {
					square = true;
				}
			}
			else if (h1==h2 && h2==w3) {
				width = w1 + w2 + h3;
				if (width == height) {
					square = true;
				}
			}
			else if (w1==w2 && w2==h3) {
				height = h1 + h2 + w3;
				if (width == height) {
					square = true;
				}
			}
			else if ((h1 == h2 || h2 == h3 || h1 == h3)) {
				if (h2 == h3 && h1 - w1 == h2) {
					if (w2 + w3 == h1) {
						square = true;
					}
				}
				else if (h1==h3 && h2-w2 == h1 && w1+w3==h2) {
					square = true;
				}
				else if (h1==h2 && h3-w3==h1 && w1+w2==h3) {
					square = true;
				}

			} else if ((w1 == w2 || w2 == w3 || w1 == w3)) {
				if (w2 == w3 && h1 - w1 == w2 && h2 + h3 == h1) {
					square = true;
				} else if (w1 == w2 && h3 - w3 == w1 && h1 + h2 == h3) {
					square = true;
				} else if (w1 == w3 && h2 - w2 == w1 && h1 + h3 == h2) {
					square = true;
				}
			}

			if (square) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			if (!scan.hasNextLine()) {
				System.out.println("");
				break;
			}
		}

	}
}
/*
 * 7 3 7 1 7 3 9 2 7 4 7 5 3 1 3 2 3 3

 */
