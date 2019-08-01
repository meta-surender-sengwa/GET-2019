import static org.junit.Assert.*;

import org.junit.Test;


public class TestCheckLoopInLinkedList {

	@Test
	public void testRotation1() {
		int[] data = { 2, 3, 4, 5, 6, 7, 8 };
		
		CheckLoopInLinkedList list = new CheckLoopInLinkedList();
		list.push(data);
		
		boolean result = list.detectLoop();
		
		assertTrue(result);
	}

}
