package icpc2019;

import java.util.*;

public class SumAndProduct {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double[] nums = new double[n];
		double total = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = scan.nextInt();
			total += nums[i];
		}
		int[] hop = new int[n];
		hop[n - 1] = nums[n - 1] == 1 ? n : n - 1; // if the last value is a one, deal with the end of hop
		for (int i = n - 2; i >= 0; i--) { // this array decides how to proceed through the array, it will hop over
											// sections of ones
			if (nums[i] == 1) {
				hop[i] = hop[i + 1];
			} else {
				hop[i] = i;
			}
		}
		int count = 0;
		double sum = 0;
		double prod = 1;
		for (int i = 0; i < n - 1; i++) {
			sum = nums[i];
			prod = nums[i];
			for (int j = i + 1; j < n && prod <= total;) {
				if (nums[j] == 1) {
					int dest = hop[j];
					int dist = dest - j;
					if (sum < prod && sum + dist > prod) { // if at some point sum will pass product during the ones
						count++;
					}
					sum += dist;
					j = dest;
				} else {
					sum += nums[j];
					prod *= nums[j];
					j++;
				}
				if (sum == prod) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
