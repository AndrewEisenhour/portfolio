import java.util.Scanner;

public class Skeleton {
//A rough draft for some common ICPC tasks
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
	}
	
	/*public static boolean sameTo(char[][] inputs, int j, int i) {
		//This method takes a char array of inputs and compares if they are the same as characters of the second input
		boolean checker = true;
		for (int k = 0; k < i; k++) {
			if (inputs[j][k] != inputs[j + 1][k]) {
				checker = false;
			}
		}
		return checker;
	}*/
	
	/*public static double distance(double x1, double y1, double x2, double y2) {
	 	//This method returns the distance between two points
        double dis = (y2 - y1);
        double dis2 = (x2 - x1);
        double distance = Math.pow(dis, 2) + Math.pow(dis2, 2);
        return distance;
    }*/
	
	/*public static double herons(double a, double b, double c) {
		//This formula returns the area of a triangle based on side length
		 double p = (a + b + c) / 2;
		 double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		 return area;
		}*/
	
	/*public static double slope(double x1, double y1, double x2, double y2) {
		//returns the slope between two points
		double slope = (y2-y1)/(x2-x1);
		return slope;
	}*/
	
	/*public static char[][] moveDown(char[][] tree, int i, int j){
		//This method moves a character lower in an array, modify '.' and 'a' to be blank and special, '#' represents unmovable
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
	}*/
}
