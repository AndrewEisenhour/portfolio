import java.util.Scanner;


public class RoundRobin {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		String output = "";
		int n;
		int t;
		int a;
		int i;
		int c=0;
		int p;
		
		while (scanner.hasNextLine()) {
			String[] line = scanner.nextLine().split(" ");
			if (line.length==1) {
				System.out.println(output.trim());
				//scanner.close();
				//break;
			}
			else {
			//Scanner num = new Scanner(line);
			//try {
			n = Integer.parseInt(line[0]);
			t = Integer.parseInt(line[1]);
			c = 0;
			
			
			//if (n>t) {
				if (n%t==0) {
					p=n-(n/t);
					c=1;
				}
				/*else {
					a = 0;
					i = 0;
					do {
						a+=(n-i)-t;
						c+=t/(n-i);
						i+=1;
					} while (a%(n-i)!=0);
					c-=(a/(n-i));
					p=n-i;
				}		
			}*/
			else {
				if (t%n==0) {
					p=n-1;
					c=t/n;
				}
				else {
					a = 0;
					i = 0;
					int over = 0;
					do  {
						
						a+=(t%(n-i));
						c+=(t/(n-i));
						if (a>(n-i)) {
							c++;
							a+=-(n-i);
						}
						a--;
						i+=1;
					} while((a!=n-i && a!=0 ));
					c+=a/(n-i);
					p=n-i;
				}
			}
			output+= p + " " + c + "\n";
			//} //catch (NoSuchElementException e){
			}
			//}
		}
	
	}
}
/*
5 17
7 10
90 2
0
 */
