import java.util.Scanner;

public class HiddenPassword {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message;
		String input;
		String[] line;
		String test = "";
		String finalMessage;
		boolean pass = false;
		while (scan.hasNextLine()) {
			pass = false;
			line = scan.nextLine().split(" ");
			message = line[0];
			finalMessage = message;
			input = line[1];
			test = "";
			// System.out.println(message);
			for (int i = 0; i < input.length(); i++) {
				//System.out.println(message);
				if (message.substring(0).contains(input.substring(i, i + 1))) {
					if (input.charAt(i) == message.charAt(0)) {
						test += input.charAt(i);
						message = message.substring(1);
					}
					else {
						break;
					}
				}
				//System.out.println(test);
				if (test.equals(finalMessage)) {
					pass = true;
					break;
				}

			}
			System.out.println(pass ? "PASS" : "FAIL");
		}

	}
}
