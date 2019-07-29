package FactoryForADT.Implementation;

/**
 * @author Surender Sengwa
 * This interface exposes certain basic APIs like getArea, getPerimeter, getOrigin and isPointEnclosed.
 */
public interface Shape {
    enum ShapeType {
        Square, Rectangle, Circle, Triangle;
    }

    double getArea();
    double getPerimeter();
    Point getOrigin();
    boolean isPointEnclosed(Point isPointEnclosed);
    long getTimestamp();

    ShapeType getShapeType();
}