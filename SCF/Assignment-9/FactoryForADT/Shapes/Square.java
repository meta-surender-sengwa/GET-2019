package FactoryForADT.Shapes;

import java.text.DecimalFormat;
import FactoryForADT.Implementation.Point;
import FactoryForADT.Implementation.Shape;
/**
 * @author Surender Sengwa
 * This Square class implements Shape interface
 */
public class Square implements Shape {

	final double side;
	final Point origin;
	final long timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	public Square(double side, Point origin, long timestamp) {
		this.side = side;
		this.origin = origin;
		this.timestamp = timestamp;
	}

	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(side * side));
	}

	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(4 * side));
	}

	public Point getOrigin() {
		return origin;
	}

	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (origin.getXPoint() <= isPointEnclosed.getXPoint()
				&& isPointEnclosed.getXPoint() <= origin.getXPoint() + side) {
			if (origin.getYPoint() <= isPointEnclosed.getYPoint()
					&& isPointEnclosed.getYPoint() <= origin.getYPoint() + side) {
				return true;
			}
		}
		return false;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public ShapeType getShapeType() {
		return ShapeType.Square;
	}
}