package icpc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ExplodingCPU {

	static class solver {
		public void run(InputReader cin, PrintWriter out) {
			// Main program goes here
			int n = cin.nextInt();
			int l;
			int h;
			List<Integer> primes = new ArrayList<Integer>();
			int count = 0;
			for (int i = 0; i < n; i++) {
				count = 0;
				l = cin.nextInt();
				h = cin.nextInt();
				//System.out.println(l + " " + h);
				/*
1
4505 4505
				 */
				if (l == 0) {
					l += 2;
				}
				if (l % 2 == 0) {
					l++;
				}
				for (int j = l; j <= h; j += 2) {
					System.out.println(j);
					primes = prime.primeFactors(j);
					if (checkExploding(j, primes)) {
						count++;
					}
				}
				System.out.println(count);
				primes.clear();

			}
		}

		static boolean checkExploding(int n, List<Integer> primes) {
			int sumLeft = 0;
			int A = 0;
			int B = primes.size() - 1;
			int stop;
			
			for (int i : primes) {
				sumLeft += i;
			}
			A = sumLeft - primes.get(primes.size() - 1);
			sumLeft--;
			stop = sumLeft/B;
			//System.out.println(sumLeft + " " + A + " " + B);
			for (int i = sumLeft/A; i>-1; i++) {
				for (int j = 0; j<stop; j++) {
					if (i*A+j*B==sumLeft) {
						return true;
					}
				}
			}

			return false;
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

		public String nextLine() {
			String line = "";
			try {
				line = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
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

	static class prime {
		// A function to print all prime factors
		// of a given number n
		public static Set<Integer> primesLessThan(int n, Set<Integer> primes){
			return null;
			
		}
		public static List<Integer> primeFactors(int n) {
			// Print the number of 2s that divide n
			List<Integer> primes = new ArrayList<Integer>();

			while (n % 2 == 0) {
				primes.add(2);
				n /= 2;
			}

			// n must be odd at this point. So we can
			// skip one element (Note i = i +2)
			for (int i = 3; i <= Math.sqrt(n); i += 2) {
				// While i divides n, print i and divide n
				while (n % i == 0) {
					primes.add(i);

					n /= i;
				}
			}

			// This condition is to handle the case when
			// n is a prime number greater than 2
			if (n > 2)
				primes.add(n);
			primes.add(1);
			primes.sort(null);
			return primes;
		}
	}
}
