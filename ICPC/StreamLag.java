import java.util.*;

public class StreamLag {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] packets = new int[n];
		int cur;
		int cur2;
		int other = n;
		for (int i = 0; i < n; i++) {
			cur = scan.nextInt();
			cur2 = scan.nextInt();
			packets[cur2 - 1] = cur;
		}
		int count = 0;
		int offset = 0;
		int curSec = 1;
		for (int i = 0; i < n; i++) {
			if (packets[i] - curSec > 0) {
				count += packets[i] - curSec;
				curSec = packets[i];
			}
			curSec++;
			
		}
		System.out.println(count);
	}
}
