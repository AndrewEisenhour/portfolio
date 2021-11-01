import java.util.Scanner;
public class Doubles {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		int doubles = 0;
		String line;
		
		while(true) {
			doubles = 0;
			line = scan.nextLine();
			if (line.equals("-1")) {
				break;
			}
			String[] input = line.split(" ");
			int[] arr = new int[input.length-1];
			for (int i = 0; i<input.length-1; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			for (int i = 0; i<arr.length; i++) {
				for (int j = 0; j<arr.length; j++) {
					if ((arr[i]*2)==arr[j]) {
						doubles++;
					}
				}
			}
			System.out.println(doubles);
			
		}
		
	}
}
/*
1 4 3 2 9 7 18 22 0
2 4 8 10 0
7 5 11 13 1 3 0
-1
*/
