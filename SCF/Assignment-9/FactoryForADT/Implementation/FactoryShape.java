package FactoryForADT.Implementation;

import java.util.Calendar;
import java.util.List;
import FactoryForADT.Implementation.Shape.ShapeType;
import FactoryForADT.Shapes.*;

/**
 * @author Surender Sengwa
 * This class is Factory class for Shapes
 */
public class FactoryShape {
	static Shape createShape(ShapeType shapeType, Point origin, List<Double> parameters) {
		if (shapeType == null || origin == null || parameters == null) {
			return null;
		}
		
		switch (shapeType) {
		case Circle:
			if (parameters.size() != 1) {
				return null;
			}
			return new Circle(parameters.get(0), origin, Calendar.getInstance().getTimeInMillis());
			
		case Rectangle:
			if (parameters.size() != 2) { 
                return null;
			}
			return new Rectangle(parameters.get(0), parameters.get(1), origin, Calendar.getInstance().getTimeInMillis());
			
		case Square:
			if (parameters.size() != 1) {
                return null;
			}
			return new Square(parameters.get(0), origin, Calendar.getInstance().getTimeInMillis());
			
		case Triangle:
			if (parameters.size() != 1) {
                return null;
			}
			return new Triangle(parameters.get(0), parameters.get(1), parameters.get(2), origin, Calendar.getInstance().getTimeInMillis());
			
		default:
			return null;
		}
	}
}