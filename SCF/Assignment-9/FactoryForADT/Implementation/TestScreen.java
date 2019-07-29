package FactoryForADT.Implementation;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import FactoryForADT.Implementation.Shape.ShapeType;

public class TestScreen {
	Screen screen = new Screen();
	
	@Test
	public void testAddShapes() {
		Screen.addShape(ShapeType.Circle, new Point(10, 5), new ArrayList<>(Arrays.asList(5d)));
		Screen.addShape(ShapeType.Circle, new Point(10, 11), new ArrayList<>(Arrays.asList(5d)));
		Screen.addShape(ShapeType.Rectangle, new Point(5, 10), new ArrayList<>(Arrays.asList(10d, 15d)));
		Screen.addShape(ShapeType.Square, new Point(10, 10), new ArrayList<>(Arrays.asList(10d)));
		Screen.addShape(ShapeType.Triangle, new Point(5, 15), new ArrayList<>(Arrays.asList(3d, 4d, 5d)));
	}
	
	@Test
	public void testDeleteShape() {
		assertFalse(Screen.deleteShape(ShapeType.Triangle, new Point(5, 15), new ArrayList<>(Arrays.asList(3d, 4d, 6d))));
	}
	
	@Test
	public void testDeleteShapesOfSpecificType() {
		assertFalse(Screen.deleteShapesOfSpecificType(ShapeType.Triangle));
	}
	
	@Test
	public void testSortAscendingInArea() {
		//	assertThat(new ArrayList<>(Arrays.asList(ShapeType.Circle)), is(Screen.ascendingInArea()));
	}
	
	@Test
	public void testSortAscendingInPerimeter() {
		//	Screen.ascendingInPerimeter();
	}
	
	@Test
	public void testIsPointEnclosed() {
		//
	}
}