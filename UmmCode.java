package icpc2019;
import java.util.*;

public class UmmCode {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] words = line.split(" ");
		//LinkedList<String> umms = new LinkedList<String>();

		// System.out.println(line);
		// line = strip(line);
		// System.out.println(line);
		splitter(words);
		/*
		 * words = binary(words); int[] arr = toInt(words); line = finalString(arr);
		 * System.out.println(line);
		 */

	}

	private static boolean checkUmm(String word) {
		char[] umm = word.toCharArray();

		for (char curr : umm) {

			if (curr == 117 || curr == 109 || (curr >= 33 && curr <= 47) || (curr >= 58 && curr <= 64)
					|| (curr >= 91 && curr <= 96) || (curr >= 123 && curr <= 126)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	/*
	 * private static String combine(LinkedList<String> words) { String curr = "";
	 * for (String i : words) { curr += i; } return curr; }
	 */

	/*
	 * private static String strip(String word) { String todo = ""; char[] arr =
	 * word.toCharArray(); for (char i : arr) { if (i == 'u' || i == 'm') { todo +=
	 * i; } } return todo;
	 * 
	 * }
	 */

	private static void splitter(String[] words) {
		// String[] words = new String[word.length() / 7];
		// System.out.println(word.length()/7);
		int val = 0;
		int len = 0;
		StringBuilder finalWord = new StringBuilder();
		for (String word : words) {
			if (checkUmm(word)) {
				for (char c : word.toCharArray()) {
					if (c != 'u' && c != 'm') {
						continue;
					}
					val <<= 1;
					if (c == 'u') {
						val |= 0x1;

					}
					if (++len == 7) {
						finalWord.append((char) val);
						val = 0;
						len = 0;
					}
					// words[i] = word.substring(i * 7, i * 7 + 7);
					// System.out.println(words[i]);
					// words[i] = binary(words[i]);

				}
			}
		}
		System.out.println(finalWord);

	}

	/*
	 * private static String binary(String word) { // String temp = ""; //
	 * System.out.println(word.length); String binaries = ""; char[] arr; // for
	 * (int i = 0; i<word.length; i++) { // int len = 0; int val = 0; arr =
	 * word.toCharArray(); for (char a : arr) { val <<= 1; if (a == 'u') { val |=
	 * 0x1; } } binaries += (char) val;
	 * 
	 * // temp = ""; return binaries;
	 * 
	 * }
	 */

	/*
	 * private static char toInt(String words) { int arr; //for (int i = 0; i <
	 * words.length; i++) { arr = Integer.parseInt(words, 2);
	 * 
	 * //} return (char) arr; }
	 */

	/*
	 * private static String finalString(int[] words) { String end = ""; for (int i
	 * = 0; i < words.length; i++) { end += (char) words[i]; } return end; }
	 */

}
