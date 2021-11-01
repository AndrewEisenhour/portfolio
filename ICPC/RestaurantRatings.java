import java.util.Scanner;
public class RestaurantRatings {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] rat;
		int S;
		int R;
		int firstNum;
		int secondNum;
		while (scan.hasNextLine()) {
			R = 0;
			S = 0;
			firstNum = 0;
			secondNum = 0;
			rat = scan.nextLine().split(" ");
			int[] ratings = new int[rat.length];
			//ratings[0] = 0;
			int total = 0;
			if (ratings.length==1) {
				break;
			}
			for (int i = 0; i<rat.length; i++) {
				ratings[i] = Integer.parseInt(rat[i]);
				total += ratings[i];
				//System.out.println(ratings[i]);
			}
			//System.out.println(ratings);
			R = ratings[0];
			S = sum(ratings, 1);
			//System.out.println(S);
			//int num = Integer.parseInt(rat[0]);
			long bigTotal = pascals(R, S);
			//System.out.println(bigTotal);
			for(int i = 1; i<ratings.length-1; i++) {
				firstNum = (R-1-i)+sum(ratings, i+1);
				secondNum = R - i;
				bigTotal -= combination(firstNum, secondNum);
				//System.out.println(bigTotal);
			}
			if (bigTotal == 0) {
				bigTotal++;
			}
			System.out.println(bigTotal);
			//int total = 0; 
		
			//int index = 
			
		}
	}
	public static long factorial(int num) {
		long total = 1;
		for (int i = 1; i<=num; i++) {
			total = total * i;
			//System.out.println(total);
		}
		//System.out.println(total);
		return total;
	}
	public static long pascals(int num, int total) {
		return factorial(num+total)/(factorial(num)*factorial(total));
	}
	public static long combination(int num, int total) {
		return factorial(num)/(factorial(num-total)*factorial(total));
	}
	public static int sum(int[] rat, int i) {
		int total = 0;
		for (int j = i; i<rat.length; i++) {
			total += rat[i];
		}
		return total;
	}
	
}

/*
2 4 3
1 3
5 4 3 2 1 4
0
*/