import java.util.*;

public class CAB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNextLine()) {
			String[] line = scan.nextLine().split(" ");
			String alpha = "abcdefghijklmnopqrstuvwxyz";
			char last = line[0].charAt(0);
			int num = Integer.parseInt(line[1]);
			char[] letters = alpha.substring(0, alpha.indexOf(last)).toCharArray();
			LinkedList<Character> seq = new LinkedList<Character>();
			char[][] inputs = new char[num][1000];
			for (int i = 0; i < num; i++) {
				inputs[i] = scan.nextLine().toCharArray();
			}
			int min = 100000;
			for (int i = 0; i < inputs.length; i++) {
				min = Math.min(inputs[i].length, min);
			}

			seq.add(inputs[0][0]);
			for (int i = 0; i < min; i++) {
				for (int j = num - 1; j >= 0; j--) {
					char curr = inputs[j][i];

					if (curr == 0) {
						break;
					}
					if (!seq.contains(curr)) {
						seq.add(curr);
					}
					if (j < num - 1) {
						char prev = inputs[j + 1][i];

						if (sameTo(inputs, j, i) && curr != prev) {
							if (!seq.contains(curr)) {
								seq.add(curr);
							} else {

								seq.remove(seq.indexOf(curr));
								// System.out.println(curr);
								if (seq.indexOf(prev) == 0) {
									seq.addFirst(curr);
								} else {

									seq.add(seq.indexOf(prev), curr);
								}
							}
						}
					}
					// System.out.println(seq);
				}
			}
			LinkedList<Character> seq2 = new LinkedList<Character>();
			for (int i = min - 1; i >= 0; i--) {
				for (int j = num - 1; j >= 0; j--) {
					char curr = inputs[j][i];

					if (curr == 0) {
						break;
					}
					if (!seq2.contains(curr)) {
						seq2.add(curr);
					}
					if (j < num - 1) {
						char prev = inputs[j + 1][i];

						if (sameTo(inputs, j, i) && curr != prev) {
							if (!seq2.contains(curr)) {
								seq2.add(curr);
							} else {
								// System.out.print(prev);
								seq2.remove(seq2.indexOf(curr));
								// System.out.println(curr);
								if (seq2.indexOf(prev) == 0) {
									seq2.addFirst(curr);
								} else {

									seq2.add(seq2.indexOf(prev), curr);
								}
							}
						}
					}
					// System.out.println(seq2 + " " + curr);
				}
			}
			boolean impossible = false;
			boolean ambiguous = false;
			// System.out.println(seq + " " + seq2);
			for (int i = 0; i < seq.size(); i++) {
				if (seq.get(i) != seq2.get(i)) {
					ambiguous = true;
					break;
				}
			}
			if (ambiguous) {
				System.out.println("AMBIGUOUS");

			}

			else {
				for (int i = min - 1; i >= 0; i--) {
					for (int j = num - 1; j >= 0; j--) {
						if (j < num - 1) {

							char curr = inputs[j][i];
							char prev = inputs[j + 1][i];
							if (sameTo(inputs, j, i)) {
								if (seq.indexOf(curr) > seq.indexOf(prev)) {
									System.out.println("IMPOSSIBLE");
									impossible = true;
								}
							}
						}
					}
				}
			}
			if (!impossible && !ambiguous) {
				String output = "";
				for (int i = 0; i < seq.size(); i++) {
					output += seq.get(i);
				}
				System.out.println(output);

			}

		}
	}

	public static boolean sameTo(char[][] inputs, int j, int i) {
		boolean checker = true;
		for (int k = 0; k < i; k++) {
			if (inputs[j][k] != inputs[j + 1][k]) {
				checker = false;
			}
		}
		return checker;
	}
}

/*
 * d 4 cab cda ccc badca c 4 abc bca cab aca f 2 dea cfb e 5 ebbce dbe adcd bc
 * cd
 * 
 */
