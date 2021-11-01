import java.util.Scanner;
public class GettingYourPrioritiesStraight {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		while (num!=-1) {
			int[] arr = new int[num];
			String[] strArr = scan.nextLine().split(" ");
			for (int i = 0; i<strArr.length; i++) {
				arr[i] = Integer.parseInt(strArr[i]);
			}
			boolean switcher = false;
			int max = arr[0];
			for (int j = 0; j<arr.length; j++) {
				if (arr[j]<max) {
					switcher = true;
					break;
				}
				max = Math.max(arr[j], max);
			}
			if (switcher) {
				System.out.println("no");
			}
			else {
				System.out.println("yes");
			}
			num = Integer.parseInt(scan.nextLine());
		}
	}
}
/*
5
1 2 3 4 5
7
1 2 4 3 12 99 100
2
2 1
6
2 2 2 2 2 2
-1
*/