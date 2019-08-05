/**
 * @author Surender
 * Interface for Queue Implementation
 */
public interface Queue {

	public boolean enQueue(int data);
	public boolean deQueue();
	public boolean isQueueEmpty();
	public boolean isQueueFull();
	public int[] displayQueue();
	
}
