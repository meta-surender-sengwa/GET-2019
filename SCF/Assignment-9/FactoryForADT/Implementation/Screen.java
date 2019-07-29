package FactoryForADT.Implementation;

import java.util.ArrayList;
import java.util.List;
import FactoryForADT.Implementation.Shape.ShapeType;

/**
 * @author Surender Sengwa
 */
public class Screen {
	static ArrayList<Shape> shapesList = new ArrayList<>();

	static void addShape(ShapeType shapeType, Point point, List<Double> parameters) {
		shapesList.add(FactoryShape.createShape(shapeType, point, parameters));
	}

	static boolean deleteShape(ShapeType shapeType, Point point, List<Double> parameters) {
		for (int index = 0; index < shapesList.size(); index++) {
			if (shapesList.get(index).getShapeType() == shapeType && shapesList.get(index).getOrigin() == point) {
				shapesList.remove(index);
				return true;
			}
		}
		return false;
	}

	static boolean deleteShapesOfSpecificType(ShapeType shapeType) {
		for (int index = 0; index < shapesList.size(); index++) {
			if (shapesList.get(index).getShapeType() == shapeType) {
				shapesList.remove(index);
			}
		}
		for(int index = 0; index < shapesList.size(); index++) {
			if (shapesList.get(index).getShapeType() == shapeType) {
				return false;
			}
		}
		return true; 
	}

	static ArrayList<Shape> ascendingInArea() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int indexI = 0; indexI < sortedShapes.size() - 1; indexI++) {
			for (int indexJ = 0; indexJ < sortedShapes.size() - 1 - indexI; indexJ++) {
				if (sortedShapes.get(indexJ).getArea() > sortedShapes.get(indexJ + 1).getArea()) {
					Shape temp = sortedShapes.get(indexJ + 1);
					sortedShapes.set(indexJ + 1, sortedShapes.get(indexJ));
					sortedShapes.set(indexJ, temp);
				}
			}
		}
		return sortedShapes;
	}

	static ArrayList<Shape> ascendingInPerimeter() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getPerimeter() > sortedShapes.get(j + 1).getPerimeter()) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	static ArrayList<Shape> ascendingInTimestamp() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				if (sortedShapes.get(j).getTimestamp() > (sortedShapes.get(j + 1).getTimestamp())) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	static ArrayList<Shape> ascendingInOriginDistance() {
		ArrayList<Shape> sortedShapes = new ArrayList<>();
		sortedShapes = shapesList;
		for (int i = 0; i < sortedShapes.size() - 1; i++) {
			for (int j = 0; j < sortedShapes.size() - 1 - i; j++) {
				double originDistanceJ = Math.sqrt(Math.pow(sortedShapes.get(j).getOrigin().getXPoint(), 2)
						+ Math.pow(sortedShapes.get(j).getOrigin().getYPoint(), 2));
				double originDistanceJ1 = Math.sqrt(Math.pow(sortedShapes.get(j + 1).getOrigin().getXPoint(), 2)
						+ Math.pow(sortedShapes.get(j + 1).getOrigin().getYPoint(), 2));
				if (originDistanceJ > originDistanceJ1) {
					Shape temp = sortedShapes.get(j + 1);
					sortedShapes.set(j + 1, sortedShapes.get(j));
					sortedShapes.set(j, temp);
				}
			}
		}
		return sortedShapes;
	}

	static ArrayList<Shape> isPointEnclosed(Point point) {
		ArrayList<Shape> pointEnclosedShapes = new ArrayList<>();
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).isPointEnclosed(point)) {
				pointEnclosedShapes.add(shapesList.get(i));
			}
		}
		return pointEnclosedShapes;
	}
}