import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RanchersGift {
public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in); 
 
 int numDatasets = scanner.nextInt();
 scanner.nextLine();
 String output = "";
 for (int i = 0; i < numDatasets; i++) {
  output += (i + 1) + " ";
  String[] line = scanner.nextLine().split(" ");
  double aX = 0;
  double aY = 0;
  double bX = Double.valueOf(line[1]);
  double bY = 0;
  double cX = Double.valueOf(line[2]);
  double cY = Double.valueOf(line[3]);
  double dX = Double.valueOf(line[4]);
  double dY = Double.valueOf(line[5]);
  
  double AD = distanceBetweenCoords(aX, dX, aY, dY);
  double AB = distanceBetweenCoords(aX, bX, aY, bY);
  double CB = distanceBetweenCoords(cX, bX, cY, bY);
  double CD = distanceBetweenCoords(cX, dX, cY, dY);
   
  //Line lineA = new Line(aX, aY, halfCoordinate(cX, bX), halfCoordinate(cY, bY));
  //Line lineB = new Line(bX, bY, halfCoordinate(cX, dX), halfCoordinate(cY, dY));
  //Line lineC = new Line(cX, cY, halfCoordinate(aX, dX), halfCoordinate(aY, dY));
  //Line lineD = new Line(dX, dY, halfCoordinate(aX, bX), halfCoordinate(aY, bY));
  //System.out.println(lineB.getSlope());
  double slopeA = slope(aX, aY, halfCoordinate(cX, bX), halfCoordinate(cY, bY));
  double slopeB = slope(bX, bY, halfCoordinate(cX, dX), halfCoordinate(cY, dY));
  double slopeC = slope(cX, cY, halfCoordinate(aX, dX), halfCoordinate(aY, dY));
  double slopeD = slope(dX, dY, halfCoordinate(aX, bX), halfCoordinate(aY, bY));
  double aInt = intercept(aX, aY, slopeA);
  double bInt = intercept(bX, bY, slopeB);
  double cInt = intercept(cX, cY, slopeC);
  double dInt = intercept(dX, dY, slopeD);
  double eX = xInt(slopeA, slopeD, aInt, dInt);
  double eY = yInt(eX, slopeA, aInt);
  double fX = xInt(slopeB, slopeA, bInt, aInt);
  double fY = yInt(fX, slopeB, bInt);
  double gX = xInt(slopeB, slopeC, bInt, cInt);
  double gY = yInt(gX, slopeC, cInt);
  double hX = xInt(slopeC, slopeD, cInt, dInt);
  double hY = yInt(hX, slopeD, dInt);
  
  double EF = distanceBetweenCoords(eX, fX, eY, fY);
  //System.out.println(EF);
  double FG = distanceBetweenCoords(fX, gX, fY, gY);
  //System.out.println(FG);
  double GH = distanceBetweenCoords(gX, hX, gY, hY);
  double HE = distanceBetweenCoords(hX, eX, hY, eY);
  double EG = distanceBetweenCoords(eX, gX, eY, gY);
  double FH = distanceBetweenCoords(fX, fY, hX, hY);
  
  //System.out.println(hX);
  //System.out.println(distanceBetweenCoords(aX, fX, aY, fY));
  double al = herons(distanceBetweenCoords(aX, fX, aY, fY), AB, distanceBetweenCoords(fX, bX, fY, bY))/160;
  double bob = herons(distanceBetweenCoords(cX, gX, cY, gY), CB, distanceBetweenCoords(gX, bX, gY, bY))/160;
  double chass = herons(distanceBetweenCoords(cX, hX, cY, hY), CD, distanceBetweenCoords(hX, dX, hY, dY))/160;
  double dave = herons(distanceBetweenCoords(aX, eX, aY, eY), AD, distanceBetweenCoords(eX, dX, eY, dY))/160;
  double emily = (herons(EF, FG, EG) + herons(EG, GH, HE))/160;
  String alTest = String.format("%.3f", al);
  String bobTest = String.format("%.3f", bob);
  String chassTest = String.format("%.3f", chass);
  String daveTest = String.format("%.3f", dave);
  String emilyTest = String.format("%.3f", emily);
  
  double perim = Math.floor((EF + FG + GH + HE)*16.5) + 1;
  String perimTest = String.format("%.0f", perim);
  output+= alTest + " " + bobTest + " " + chassTest + " " + daveTest + " " + emilyTest + " " + perimTest;
  
  if (i != numDatasets - 1) {
   output += "\n";
  }
 }
 
 System.out.println(output);
}

public static double distanceBetweenCoords(double x1, double x2, double y1, double y2) {
 double xDiff = x1 - x2;
 double yDiff = y1 - y2;
 double squaredX = xDiff * xDiff;
 double squaredY = yDiff * yDiff;
 double added = squaredX + squaredY;
 return Math.sqrt(added);
}

public static double herons(double a, double b, double c) {
 double p = (a + b + c) / 2;
 double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
 return area;
}

public static double halfCoordinate(double aX, double bX) {
 return (aX + bX) / 2;
}
public static double slope(double x1, double y1, double x2, double y2) {
	double slope = (y2-y1)/(x2-x1);
	return slope;
}
public static double intercept(double x, double y, double slope) {
	double intercept = y-slope*x;
	return intercept;
}
public static double yInt(double x, double slope, double intercept) {
	return slope*x + intercept;
}
public static double xInt(double slope1, double slope2, double int1, double int2) {
	double xdiff = slope1-slope2;
	double ydiff = int2-int1;
	double xPoint = ydiff/xdiff;
	return xPoint;
}

}

//