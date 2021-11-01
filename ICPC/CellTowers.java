import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 
public class CellTowers {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNextLine()) {
            String[] firstLine = scanner.nextLine().split(" ");
            if (firstLine.length<=1) {
            	scanner.close();
            	break;
            }
            int numTowers = Integer.parseInt(firstLine[0]);
            int numLines = Integer.parseInt(firstLine[1]);
            
            List<Tower> towers = new ArrayList<>();
 
            for (int i = 0; i < numTowers; i++) {
                Tower tower = new Tower();
 
                String[] line = scanner.nextLine().split(" ");
                tower.x = Integer.parseInt(line[0]);
                tower.y = Integer.parseInt(line[1]);
                tower.p = Integer.parseInt(line[2]);
 
                towers.add(tower);
            }
            
            String[] segStrs = scanner.nextLine().split(" ");
            int[] segs = new int[segStrs.length];
            for (int i = 0; i < segStrs.length; i++) {
                segs[i] = Integer.parseInt(segStrs[i]);
            }
 
            
            double a = segs[0];
            double b = segs[1];
            int i = 0;
            int j = 1;
            int count = 0;
            Tower curr = getNearestTower(a, b, towers);
            String output = "";
            output+="("+count+","+getTowerName(curr, towers)+") ";
            double toGo=1;
            double e = segs[segs.length-2];
            double f = segs[segs.length-1];
            while (a!=e || b!=f){
            	int c = segs[i+2];
            	int d = segs[j+2];
            	curr = getNearestTower(a, b, towers);
            	double dist = Math.sqrt(distance(a, b, c, d));
            	double distToEnd = Math.sqrt(distance(a, b, e, f));
            	if (dist<1){
            		a=c;
            		b=d;
            		i+=2;
            		j+=2;
            		toGo = toGo-dist;
            		if (a!=segs[segs.length-2] || b!=segs[segs.length-1]) {
            			continue;
            		}
            	}
            	
            	else if (a==segs[i+2]&&b!=segs[j+2]) {
            		if (b<segs[j+2]) {
            			b+=toGo;
            		}
            		else {
            			b-=toGo;
            		}
            	}
            	else if (a!=segs[i+2]&&b==segs[j+2]) {
            		if (a<segs[i+2]) {
            			a+=toGo;
            		}
            		else {
            			a-=toGo;
            		}
            	}
            	else {
            		double slope = (d-b)/(c-a);
            		//System.out.println(slope);
            		a+=Math.sqrt(toGo/(Math.pow(slope, 2)+1));
            		b+=Math.sqrt(1-(toGo/(Math.pow(slope, 2)+1)));
            		
            		/*if (a<segs[i+2]) {
            			a+=1/Math.sqrt(2);
            		}
            		else {
            			a-=1/Math.sqrt(2);
            		}
            		if (b<segs[j+2]) {
            			b+=1/Math.sqrt(2);
            		}
            		else {
            			b-=1/Math.sqrt(2);
            		}*/
            	}
            	toGo=1;
            	Tower temp = getNearestTower(a, b, towers);
            	count++;
            	//System.out.println(a+ " " + b);
            	if (distToEnd<0.5 && distToEnd>0) {
            		//scanner.close();
            		break;
            	}
            	if (curr!=temp) {
            		output+="("+count+","+getTowerName(temp, towers)+") ";
            	}
            }
            System.out.println(output.trim());
            
        }
    }
 
    public static class Tower {
        int x;
        int y;
        int p;
    }
 
    public static class Point {
        int pd;
    }
 
    public static double distance(double x1, double y1, double x2, double y2) {
        double dis = (y2 - y1);
        double dis2 = (x2 - x1);
        double distance = Math.pow(dis, 2) + Math.pow(dis2, 2);
        return distance;
    }
    public static Tower getNearestTower(double x, double y, List<Tower> towers) {
    	int index = 0;
        double max = 0;
        for (int j = 0; j < towers.size(); j++) {
            Tower tower = towers.get(j);
            int temp = (int)Math.max(tower.p / distance(x, y, tower.x, tower.y), max);
            if (temp != max) {
                index = j;
                max = temp;
            }
        }
        return towers.get(index);
    }
    public static String getTowerName(Tower tower, List<Tower> towers) {
    	int count = 0;
    	for (Tower j : towers) {
    		
    		if (j==tower) {
    			break;
    		}
    		count++;
    	}
    	switch (count) {
    	case 0:
	    	return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		case 3:
			return "D";
		case 4:
	    	return "E";
		case 5:
			return "F";
		case 6:
			return "G";
		case 7:
			return "H";
		case 8:
			return "I";
		case 9:
			return "J"; 
    	}
    	return null;
    }
}

 
/*
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
2 5
1 4 1000
5 4 1000
1 5 3 5 3 3 5 3 5 1 1 1
3 2
0 0 1000
6 0 600
6 6 1000
1 1 5 5 5 2
3 2
0 0 1000
6 0 300
6 6 1000
2 2 5 5 5 2
2 5
1 4 1000
5 4 1000
2 2 3 5 3 3 5 3 5 1 1 1
0

 */ 
