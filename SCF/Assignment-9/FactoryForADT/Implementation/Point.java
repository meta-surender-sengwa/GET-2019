package FactoryForADT.Implementation;

/**
 * @author Surender Sengwa
 *	This class represent the location of PointX and PointY on a screen size of 1024 x 768
 */
public class Point {
	private final double xPoint;
	private final double yPoint;

	public Point(double xPoint, double yPoint) {
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		if (!checkLocation()) {
			System.out.println("Point out of Screen Size");
		}
	}

	private boolean checkLocation() {
		if (xPoint >= 0 && xPoint <= 1024 && yPoint >= 0 && yPoint <= 768) {
			return true;
		}
		return false;
	}

	public double getXPoint() {
		return xPoint;
	}

	public double getYPoint() {
		return yPoint;
	}
}