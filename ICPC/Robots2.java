import java.util.*;

public class Robots2 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			ArrayList<Litter> map = new ArrayList<Litter>();
			String[] line = scan.nextLine().split(" ");
			int count = 0;
			if (line[0].equals("-1")) {
				
				break;
				
			}
			if (line.length == 0) {
				return;
			}
			while (!line[0].equals("0")) {
				map.add(new Litter(Integer.parseInt(line[0]), Integer.parseInt(line[1]), false));
				line = scan.nextLine().split(" ");
				count++;
			}
			
			//int x = map.get(0).x;
			//int y = map.get(0).y;
			int robots = 0;
			while (count > 0) {
				//System.out.println("here");
				int x = 1;
				int y = 1;
				robots++;
				//System.out.println("here");
				
				//System.out.println(robots + " " + count);
				for (Litter a : map) {
					//System.out.println(count);
					if (a.x>x) {
						x = a.x;
					}
					if (a.x == x && !a.pickedUp && a.y>=y) {
						a.pickedUp = true;
						y = a.y;
						count--;
					} 
				}
			}
			System.out.println(robots);
			/*if (!scan.hasNextLine()) {
				break;
			}*/
		}
		}

	}



class Litter {
	public boolean pickedUp;
	public int x;
	public int y;

	public Litter(int a, int b, boolean picked) {
		x = a;
		y = b;
		pickedUp = picked;
	}
}
/*
1 2
1 4
2 4
2 6
4 4
4 7
5 2
6 1
6 6
0 0
1 1
2 2
4 4
0 0
-1 -1
*/


