import java.util.Scanner;
public class Sunrise {
	public static void main (String args[]) {
		double h;
		double s;
		double rad = 432000;
		double circle = Math.pow(rad, 2)*Math.PI;
		double area;
		double output;
		
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextDouble()) {
			s = scan.nextDouble();
			h = (s/127.8050693)*rad*2;
			if (s>127.8050693) {
				output = 1;
			}
			else if (h>432000) {
				h = rad*2-h;
				area = Math.pow(rad, 2)*Math.acos((rad-h)/rad)-(rad-h)*Math.sqrt(2*rad*h-Math.pow(h, 2));
				output = 1 - area/circle;
			}
			else {
				area = Math.pow(rad, 2)*Math.acos((rad-h)/rad)-(rad-h)*Math.sqrt(2*rad*h-Math.pow(h, 2));
				output = area/circle;
			}
			System.out.println(String.format("%.6f", output));
		}
		
	}
}
/*
111.1
111.2
111.3
111.4
111.5
111.6
111.7
111.8
111.9
112.0

*/
