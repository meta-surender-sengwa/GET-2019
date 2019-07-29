package FactoryForADT.Shapes;

import java.text.DecimalFormat;
import FactoryForADT.Implementation.Point;
import FactoryForADT.Implementation.Shape;

/**
 * @author Surender Sengwa
 * This Triangle class implements Shape interface
 */
public class Triangle implements Shape {
    private Point origin;
    private Point pointA;
    private Point pointB;
    private double height;
    private double base;
    private double sideA;
    private double sideB;
    private double slopeA;
    private double slopeB;
    DecimalFormat decimalFormatSpecifier = new DecimalFormat("####0.00");
    long timeStamp;

    public Triangle(double height, double base, double sideA, Point origin, long timestamp) {
        this.height = height;
        this.base = base;
        this.sideA = sideA;
        computeOtherParameters();
        this.origin = origin;
        this.timeStamp = timestamp;
    }

    @Override
    public double getArea() {
        double perimeter = getPerimeter() / 2;
        return Double.parseDouble(
                decimalFormatSpecifier.format(Math.sqrt(perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - base))));
    }

    @Override
    public double getPerimeter() {
        return Double.parseDouble(decimalFormatSpecifier.format(sideA + sideB + base));
    }

    public Point getOrigin() {
        return origin;
    }

    public boolean isPointEnclosed(Point isPointEnclosed) {
        /*
    	if (isPointEnclosed.getYPoint() - slopeA * isPointEnclosed.getXPoint() >= origin.getYPoint() - slopeA * origin.getYPoint()
                && isPointEnclosed.getYPoint() - slopeB * isPointEnclosed.getXPoint() <= pointA.getYPoint() - slopeB * pointA.getXPoint()
                && isPointEnclosed.getYPoint() >= origin.getYPoint()) {
            return true;
        }
        */
        return false;
    }

    @Override
    public long getTimestamp() {
        return timeStamp;
    }

    public ShapeType getShapeType() {
        return ShapeType.Triangle;
    }

    private void computeOtherParameters() {
        double difference = Math.sqrt(Math.pow(sideA, 2) - Math.pow(height, 2));
        double otherDifference = base - difference;
        sideB = Math.sqrt(Math.pow(height, 2) + Math.pow(otherDifference, 2));
        pointA = new Point(origin.getXPoint() + difference, origin.getYPoint() + height);
        pointB = new Point(origin.getXPoint() + base, origin.getYPoint());
        slopeA = (pointA.getYPoint() - origin.getYPoint()) / (pointA.getXPoint() - origin.getXPoint());
        slopeB = (pointA.getYPoint() - pointB.getYPoint()) / (pointA.getXPoint() - pointB.getXPoint());
    }
}
