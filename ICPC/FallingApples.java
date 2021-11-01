import java.util.*;
public class FallingApples {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			String[] nums = scan.nextLine().split(" ");
			int rows = Integer.parseInt(nums[0]);
			int cols = Integer.parseInt(nums[1]);
			//System.out.println(cols);
			char[][] tree = new char[rows][cols];
			for (int i = 0; i<rows; i++) {
				tree[i]=scan.nextLine().toCharArray();
				
			}
			if (rows>1) {
				tree = fall(tree, rows, cols);
			}
			//System.out.println(tree[0][2]);
			
			for (int k = 0; k<rows; k++) {
				String outline = "";
				for (int l = 0; l<cols; l++) {
					outline += tree[k][l];
				}
				System.out.println(outline);
			}
			
		}
		System.out.println("\n");
	}
	public static char[][] fall(char[][] tree, int rows, int cols){
		for (int i = 0; i<cols; i++) {
			for (int j = rows-1; j>=0; j--) {
				if (tree[j][i]=='a') {
					tree = moveDown(tree, j, i);
					//continue;
				}
			}
		}
		return tree;
	}
	public static char[][] moveDown(char[][] tree, int i, int j){
		while (i<tree.length-1) {
			if (tree[i+1][j]=='#' || tree[i+1][j]=='a') {
				break;
			}
			else {
				tree[i][j]='.';
				tree[i+1][j]='a';
			}
			i++;
		}
		return tree;
	}
}
/*
3 3
aaa
#..
..#
4 5
aaa.a
aa.a.
a.a..
...a.

*/
