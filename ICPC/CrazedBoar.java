package icpc2019;

  
import java.io.*;
import java.util.*;
import java.math.*;

public class CrazedBoar {
	static class solver {
		class delta {
			public double x;
			public int add;
			public delta(double _x, int _add) {
				x = _x;
				add = _add;
			}
		}
		class cmp implements Comparator<delta> {
			public int compare(delta E1, delta E2) {
				if (E1.x < E2.x) return -1;
				if (E1.x > E2.x) return 1;
				return 0;
			}
		}
		public void run(InputReader cin, PrintWriter out) {
			int n = cin.nextInt();	//number of trees
			double[] x = new double[n];	//Array of x coordinates
			double[] y = new double[n];	//Array of y coordinates
			double[] r = new double[n];	//Array of radiuses
			for (int i = 0; i < n; ++ i) {	//input
				x[i] = cin.nextInt();
				y[i] = cin.nextInt();
				r[i] = cin.nextInt();
			}
			double b = cin.nextInt();	//radius of boar
			double D = cin.nextInt();	//distance boar charges
			double[] L = new double[n];
			double[] R = new double[n];
			int cnt = 0;
			ArrayList<delta> all = new ArrayList<delta>();
			for (int i = 0; i < n; ++ i) {	//for each tree
				r[i] += b;	//add the boar radius to the tree radius, same as shrinking boar and increasing size of tree
				double a0 = Math.atan2(y[i], x[i]);	//return theta value between -pi and pi	0.588002604
				System.out.println(a0);
				double d = Math.sqrt(x[i] * x[i] + y[i] * y[i]);	//distance from boar to tree sqrt(13)
				double a1 = Math.asin(r[i] / d);	//angle from boar to the side of tree 0.588002604
				System.out.println(a1);
				if (r[i] + D <= d) continue;	//if it is too far away, skip
				if (r[i] + d > D) {	//tree is on the edge of the boar's range
					double a2 = Math.acos((D * D + d * d - r[i] * r[i]) / (2 * D * d));	//law of cosines
					if (D < Math.sqrt(d * d - r[i] * r[i])) a1 = a2;	//determine whether the center of the tree is on the outside of the boar's range
				}
				L[i] = a0 - a1;	//take the degrees found in a sweep to the left	0
				R[i] = a0 + a1;	//take the degrees found in a sweep to the right	1.176005208
				if (L[i] < -Math.PI) {	//if it is less than -180 degrees, the center of the circle in the third quadrant and likely overlaps the second
					L[i] += Math.PI * 2;	//make it positive
					R[i] += Math.PI * 2;	//right needs the same treatment
				}
				if (R[i] > Math.PI) {	//if it is more than 180 degrees, the circle overlaps the second and third quadrants
					cnt ++;	//increment
					all.add(new delta(L[i], +1));	//degrees covered
					all.add(new delta(R[i] - Math.PI * 2, -1));	//degrees covered adjusted for being too far positive
				}
				else {
					all.add(new delta(L[i], 1));
					all.add(new delta(R[i], -1));
				}
			}
			Collections.sort(all, new cmp());	//sorts all of sweeps based off x value from least to greatest
			all.add(new delta(Math.PI, 0));	//add a final one
			double las = -Math.PI, ans = 0;
			for (delta p : all) {//go through each sweep from least to greatest ending with Pi
				if (cnt == 0) {	//even amount of rights and lefts have gone through
					ans += p.x - las;	//add the difference between the last angle and the current
					System.out.println(ans);
				}
				las = p.x;	//update last
				cnt += p.add;	//either plus one or minus one
			}
			out.printf("%.10f\n", ans / Math.PI / 2);	//convert to radians
		}
	}
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		InputReader cin = new InputReader(System.in);
		solver Task = new solver();
		Task.run(cin, out);	//Start here
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

