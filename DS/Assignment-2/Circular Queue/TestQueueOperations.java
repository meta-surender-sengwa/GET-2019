import static org.junit.Assert.*;
import org.junit.Test;

public class TestQueueOperations {

	@Test
	public void testEnQueue() {
		QueueOperations queueObject = new QueueOperations(6);
		int[] data = {2, 3, 4, 5, 6, 7};
		for(int index = 0; index < data.length ; index++) {
			queueObject.enQueue(data[index]);
		}
		
		int[] result = queueObject.displayQueue();
		int[] expectedResult = new int[] { 2, 3, 4, 5, 6, 7};
		
		assertArrayEquals(expectedResult, result);
	}
	
	@Test
	public void testDequeue() {
		QueueOperations queueObject = new QueueOperations(6);
		int[] data = {2, 3, 4, 5, 6, 7};
		for(int index = 0; index < data.length ; index++) {
			queueObject.enQueue(data[index]);
		}
		
		queueObject.deQueue();
	    queueObject.deQueue();
		int[] result = queueObject.displayQueue();
		int[] expectedData = new int[] {0, 0, 4, 5, 6, 7};
		
		assertArrayEquals(expectedData, result);
	}
	
	@Test
	public void testIsQueueFull() {
		QueueOperations queueObject = new QueueOperations(6);
		int[] data = {2, 3, 4, 5, 6, 7};
		for(int index = 0; index < data.length ; index++) {
			queueObject.enQueue(data[index]);
		}
		
		boolean checkResult = queueObject.isQueueFull();;
		assertTrue(checkResult);
		assertFalse(!checkResult);
	}
	
	@Test
	public void testIsQueueEmpty() {
		QueueOperations queueObject = new QueueOperations(6);
		int[] data = {2, 3, 4, 5, 6, 7};
		for(int index = 0; index < data.length ; index++) {
			queueObject.enQueue(data[index]);
		}
		
		boolean checkResult = queueObject.isQueueEmpty();;
		assertTrue(!checkResult);
		assertFalse(checkResult);
	}
}
