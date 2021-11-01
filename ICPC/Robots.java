import java.util.*;
public class Robots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		while(count > 0) {
			ArrayList<Integer> x = new ArrayList<Integer>(); ArrayList<Integer> y = new ArrayList<Integer>(); ArrayList<Integer> z = new ArrayList<Integer>();
			ArrayList<String> names = new ArrayList<String>();
			for(int i = 0; i < count; i++){
				x.add(scan.nextInt()); y.add(scan.nextInt()); z.add(scan.nextInt());
				names.add(scan.nextLine().trim());
			}
			int largeI = 0;
			int smallI = 0;
			for(int i = 0; i < count; i++){
				if(x.get(i) * y.get(i) * z.get(i) > x.get(largeI) * y.get(largeI) * z.get(largeI)) {
					largeI = i;
				}
				else if(x.get(i) * y.get(i) * z.get(i) < x.get(smallI) * y.get(smallI) * z.get(smallI)) {
					smallI = i;
				}
			}
			System.out.println(names.get(largeI) + " took clay from " + names.get(smallI) +".");
			count = scan.nextInt();
		}
	}

}
