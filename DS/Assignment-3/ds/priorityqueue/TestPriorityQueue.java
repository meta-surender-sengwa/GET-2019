package ds.priorityqueue;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestPriorityQueue {

	@Test
	public void testEnQueue() throws Exception{
		
		PriorityQueue queue = new PriorityQueue();
		
		assertTrue(queue.enQueue(1,"a"));
		assertTrue(queue.enQueue(2,"b"));
		assertTrue(queue.enQueue(3,"c"));
		assertTrue(queue.enQueue(4,"d"));
	}

	@Test
	public void testDeQueue() throws Exception {
		
		PriorityQueue queue = new PriorityQueue();
		
		try {
			queue.enQueue(1,"a");
			queue.enQueue(3,"b");
			queue.enQueue(2,"c");
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		assertEquals("b", queue.deQueue().getValue());
		
		//	assertEquals("c",queue.deQueue().getValue());
		assertNotEquals("a",queue.deQueue().getValue());
	}

	@Test
	public void testIsEmpty () {
		PriorityQueue queue = new PriorityQueue();
		
		assertTrue(queue.isEmpty());
		assertFalse(!(queue.isEmpty()));
	}

	@Test
	public void testIsFull(){
		
		PriorityQueue queue = new PriorityQueue();
		
		try {
			queue.enQueue(1,"a");
			queue.enQueue(2,"b");
			queue.enQueue(3,"c");
			queue.enQueue(4,"d");
			queue.enQueue(5,"e");
			queue.enQueue(6,"f");
			queue.enQueue(7,"g");
			queue.enQueue(8,"h");
			queue.enQueue(9,"i");
		
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		assertTrue(queue.isFull());
		
		try {
			queue.deQueue();
			
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		assertFalse(queue.isFull());
	}
}
