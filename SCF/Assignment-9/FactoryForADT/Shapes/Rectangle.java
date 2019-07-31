package FactoryForADT.Shapes;

import java.text.DecimalFormat;
import FactoryForADT.Implementation.Point;
import FactoryForADT.Implementation.Shape;

/**
 * @author Surender Sengwa
 * This Rectangle class implements Shape interface
 */
public class Rectangle implements Shape {

	final double width;
	final double height;
	final Point origin;
	final long timestamp;
	DecimalFormat decimalFormatSpecifier = new DecimalFormat(".##");

	public Rectangle(double width, double height, Point origin, long timestamp) {
		this.width = width;
		this.height = height;
		this.origin = origin;
		this.timestamp = timestamp;
	}

	@Override
	public double getArea() {
		return Double.parseDouble(decimalFormatSpecifier.format(width * height));
	}

	@Override
	public double getPerimeter() {
		return Double.parseDouble(decimalFormatSpecifier.format(2 * (width + height)));
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point isPointEnclosed) {
		if (origin.getXPoint() <= isPointEnclosed.getXPoint()
				&& isPointEnclosed.getXPoint() <= origin.getXPoint() + width) {
			if (origin.getYPoint() <= isPointEnclosed.getYPoint()
					&& isPointEnclosed.getYPoint() <= origin.getYPoint() + height) {
				return true;
			}
		}
		return false;
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.Rectangle;
	}
}