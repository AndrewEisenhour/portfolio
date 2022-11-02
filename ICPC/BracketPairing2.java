package northcentral;

import java.util.*;

class BracketPairing2 {
	static boolean isOpen(char a) {
		if (a == '[' || a == '{' || a == '(' || a == '<') {
			return true;
		} else {
			return false;
		}
	}

	static void generator(char arr[], int pos, int open, int close, int N, List<String> list) {
		if (pos == (2 * N)) {
			String s = "";
			for (int ii = 0; ii < 2 * N; ii++)
				s += String.valueOf(arr[ii]);
			list.add(s);
			return;
		}

		if (open > close) {
			arr[pos] = ')';
			generator(arr, pos + 1, open, close + 1, N, list);
		}
		if (open < N) {
			arr[pos] = '(';
			generator(arr, pos + 1, open + 1, close, N, list);
		}
		// return;
	}

	public static void main(String args[]) {

		/* Scanner object */
		Scanner sc = new Scanner(System.in);
		String pattern = sc.nextLine();
		int n = pattern.length();
		if (n % 2 != 0) {
			System.out.println("0");
			return;
		}
		char arr1[] = pattern.toCharArray();
		if (!isOpen(arr1[0]) && arr1[0] != '?') {
			System.out.println("0");
			return;
		}
		if (isOpen(arr1[n - 1])) {
			System.out.println("0");
			return;
		}
		ArrayDeque<Character> stack = new ArrayDeque<>();
		List<String> list = new ArrayList<>();
		char arr[] = new char[n];
		generator(arr, 0, 0, 0, n / 2, list);
		int[][] links = findLinks(list, n);
		int total = findMatches(list, links, arr1);
		System.out.println(total);
	}

	static int[][] findLinks(List<String> list, int n) {
		int[][] arr = new int[list.size()][n];
		for (int j = 0; j < list.size(); j++) {
			String a = list.get((j));
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			char[] set = a.toCharArray();
			for (int i = 0; i < n; i++) {
				if (set[i] == '(') {
					stack.addFirst(i);
				} else {
					arr[j][i] = stack.pop();
					arr[j][arr[j][i]] = i;
				}
			}
		}
		return arr;
	}

	static boolean isPair(char a, char b) {
		if (a == '(' && b == ')') {
			return true;
		} else if (a == '[' && b == ']') {
			return true;
		} else if (a == '{' && b == '}') {
			return true;
		} else if (a == '<' && b == '>') {
			return true;
		}
		return false;
	}

	static int findMatches(List<String> list, int[][] links, char[] pattern) {
		int count = 0;
		int questionCount = 0;
		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] == '?') {
				questionCount++;
			}
		}
		int linkCount = 0;
		a: for (int i = 0; i < list.size(); i++) {
			char[] word = list.get(i).toCharArray();
			linkCount = 0;
			for (int k : links[i]) {
			}
			for (int j = 0; j < pattern.length; j++) {
				if (pattern[j] != '?') {
					if ((isOpen(pattern[j]) && word[j] == '(')
							|| (!isOpen(pattern[j]) && pattern[j] != '?' && word[j] == ')')) {

						if (pattern[j] != '?') {
							if (pattern[links[i][j]] != '?') {
								if (isPair(pattern[j], pattern[links[i][j]])
										|| isPair(pattern[links[i][j]], pattern[j])) {
									continue;
								} else {
									continue a;
								}
							} else {
								linkCount++;
							}
						}
					} else {
						continue a;
					}
				}
			}
			count += (int) Math.pow(4, (questionCount - linkCount) / 2);
		}

		return count;
	}
}