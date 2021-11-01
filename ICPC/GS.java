import java.util.Scanner;
public class GS {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Gnomes:");
		for (int i = 0; i<n; i++) {
			String[] line = scan.nextLine().split(" ");
			boolean gnome = true;
			boolean increasing = true;
			int[] arr = new int[line.length];
			for (int j = 0; j<line.length; j++) {
				arr[j] = Integer.parseInt(line[j]);
			}
			if (arr[0]>arr[1]) {
				increasing = false;
			}
			for (int j = 0; j<arr.length-1; j++) {
				
				if (arr[j]<arr[j+1] && increasing) {
					continue;
				}
				else if (arr[j]>arr[j+1] && !increasing) {
					continue;
				}
				else {
					gnome = false;
				}
			}
			if (gnome) {
				System.out.println("Ordered");
				
			}
			else {
				System.out.println("Unordered");
			}
		}
	}
}
/*
3
40 62 77
88 62 77
91 33 18

*/
