
public class Line {
	private double x;
	private double yint;
	
	public Line(double x1, double y1, double x2, double y2) {
		x = (y2-y1)/(x2-x1);
		yint = y2-x*x2;
	}
	public double yInt(double x) {
		return getSlope()*x + getIntercept();
	}
	public double xInt(Line line1) {
		double xdiff = line1.getSlope()-getSlope();
		double ydiff = getIntercept()-line1.getIntercept();
		double xPoint = ydiff/xdiff;
		return xPoint;
	}
	public double getSlope() {
		return x;
	}
	public double getIntercept() {
		return yint;
	}
}
