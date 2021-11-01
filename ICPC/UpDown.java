
import java.util.Scanner;
import java.math.*;

public class UpDown {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		String output = "";
		
		while (scan.hasNextLine()) {
			String input = scan.nextLine();
			if (input.equals("0")) {
				break;
			}
			String[] inputSplit = input.split(" ");
			int[] inputNum = new int[inputSplit.length];
			int iii = 0;
			for (String inputStr : inputSplit) {
				if (inputStr.equals("0")) {
					break;
				}
				inputNum[iii++] = Integer.parseInt(inputStr);
			}
			output += "Nr values = " + (inputNum.length-1) + ":  ";
			
			double outNum1 = 0.0;
			double outNum2 = 0.0;
			
			int storage = 0;
			int switcher = inputNum[1]-inputNum[0];
			int up = 0;
			int down = 0;
			int upCount = 0;
			int downCount = 0;
			int prevSwitch = 0;
			for (int i = 0; i<inputNum.length; i++) {
				if (prevSwitch!=switcher && switcher!=0) {
					prevSwitch = switcher;
				}
				if (switcher == 0) {
					switcher = prevSwitch;
				}
				if (inputNum[i+1]==0) {
					if (switcher<0) {
						down+=storage;
						downCount++;
					}
					else if (switcher>0) {
						up+=storage;
						upCount++;
					}
					
					break;
				}
				
				int a = inputNum[i];
				int b = inputNum[i+1];
				
				if(b-a>0 && switcher>0) {
					storage++;
				}
				else if (b-a>0 && switcher<0) {
					down+=storage;
					downCount++;
					storage=1;
				}
				else if (b-a<0 && switcher>0) {
					up+=storage;
					upCount++;
					storage=1;
				}
				
				else {
					storage++;
				}
				switcher = b-a;
			}
			if (upCount>0) {
				outNum1 = up/(double)upCount;
			}
			if (downCount>0) {
				outNum2 = down/(double)downCount;
			}
			
			String outNum1Str = String.valueOf(String.format("%.6f", outNum1));
			String outNum2Str = String.valueOf(String.format("%.6f", outNum2));
			/*while (outNum1Str.split(".")[1].length() < 6) {
				outNum1Str += " ";
			}
			while (outNum2Str.split(".")[1].length() < 6) {
				outNum2Str += " ";
			}*/
			output += outNum1Str + " " + outNum2Str + "\n";
		}
		
		System.out.println(output.trim());
	}
	
}
/*
1 2 3 0
3 2 1 0
1 2 3 2 1 0
2 2 2 2 3 0
4 4 4 4 3 0
4 4 4 3 3 3 3 0
4 4 4 3 3 3 4 0
5 5 5 5 0
1 2 3 2 3 4 5 0
1 2 3 4 4 4 3 4 10 0
0
 */
