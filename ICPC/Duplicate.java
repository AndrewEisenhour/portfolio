import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Duplicate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for(;;) {
			String[] data = scanner.nextLine().split(" ");
			if(data[0].equals("0")) {
				return;
			}
			
			List<Integer> newData = Arrays.asList(data).stream().map(Integer::parseInt).collect(Collectors.toList());
			newData.remove(0);
			
			int last = -1;
			for(int i : newData) {
				if(last != -1) {
					if(last == i) {
						continue;
					}
				}
				last = i;
				System.out.print(i + " ");
			}
			System.out.print("$\n");
		}

	}

}
