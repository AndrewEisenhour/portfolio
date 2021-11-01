package icpc2019;

import java.io.*;
import java.util.*;
import java.math.*;

public class TrueFalseWorksheet {
	static class solver {
		public void run(InputReader cin, PrintWriter out) {
			int MOD = 1000000007; // what the answer needs to be moduloed by
			int n = cin.nextInt(); // number of questions
			int m = cin.nextInt(); // number of hints
			int[] hint1 = new int[n + 1]; // keeps track of hints
			int[] hint2 = new int[n + 1];
			for (int i = 1; i <= n; ++i) {
				hint1[i] = i; // fills hint1 with increasing numbers 1..n
				hint2[i] = 0; // fills hint2 with zeroes
			}
			for (int i = 0; i < m; ++i) {
				int l = cin.nextInt(); // opening of range
				int r = cin.nextInt(); // closing of range
				String s = cin.next(); // "same" or "different"
				if (s.equals("same")) { // If it is a same range
					hint1[r] = Math.min(hint1[r], l); // Assigns the index at the close of the range to the minimum of
														// its index or the start index
				} else {
					hint2[r] = Math.max(hint2[r], l); // Assigns the index at the close of the range to the maximum of
														// the current value at the close of the range and the start
														// index
				}
			}
			int[] dp = new int[n + 1];
			dp[0] = 1;	//giving a starting value
			for (int i = 1; i <= n; ++i) {	//go through each value
				int h1 = i, h2 = 0;
				for (int j = i; j >= 1; --j) {	//work backwards from said value
					h2 = Math.max(h2, hint2[j]);	
					h1 = Math.min(h1, hint1[j]);	
					if (j > h2 && j <= h1) {	//checks if the value has already been covered by a previous number for the same hints and that a difference hint is not in play 
						dp[i] = (dp[i] + dp[j - 1]) % MOD;
					}
				}
			}
			out.println(dp[n] * 2 % MOD);
		}
	}

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		InputReader cin = new InputReader(System.in);
		solver Task = new solver();
		Task.run(cin, out);
		out.close();
	}

	static class InputReader { // Fast Reader
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					String line = reader.readLine();
					/* line == null ? end of file */
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
			// return Long.parseLong(next()); Double Integer
			// return new BigInteger(next(), 16); // as Hex
		}
	}
}
