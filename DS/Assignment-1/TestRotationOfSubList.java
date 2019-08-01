import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestRotationOfSubList {

	@Test
	public void testRotation1() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		
		LinkedList list = new LinkedList();
		LinkedList.insert(list, data);
		
		int[] result = RotationOfSubList.rotation(list, 2, 5, 2);
		int[] expectedData = { 2, 5, 6, 3, 4, 7, 8 };
		
		assertArrayEquals(expectedData, result);
	}
	
	@Test
	public void testRotation2() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		
		LinkedList list = new LinkedList();
		LinkedList.insert(list, data);
		
		int[] result = RotationOfSubList.rotation(list, 2, 5, 3);
		int[] expectedData = { 2, 6, 3, 4, 5, 7, 8 };
		
		assertArrayEquals(expectedData, result);
	}
}
