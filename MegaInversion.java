package icpc2020;

import java.util.*;

public class MegaInversion {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();

		int[] nums = new int[n];
		int max=0;
		for (int i = 0; i < n; i++) {
			nums[i] = scan.nextInt();
			max = Math.max(max, nums[i]);
		}
		int count = 0;
		boolean last = false;
		int min = max+1;
		a: for (int i = 0; i<n-2; i++) {
			if (!last && i>0) {
				min=Math.min(nums[i-1], min);
				if (nums[i]<=min) {
					continue a;
				}
			}
			else if(last) {
				if (nums[i]==nums[i-1]) {
					count++;
					continue a;
				}
			}
			last = false;
			b: for (int j = i+1; j<n-1; j++) {
				if (nums[j]>=nums[i]) {
					continue b;
				}
				c: for (int k = j+1; k<n; k++) {
					if (nums[i]>nums[j] && nums[j]>nums[k]) {
						last = true;
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
