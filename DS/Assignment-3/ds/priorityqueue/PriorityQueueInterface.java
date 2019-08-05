package ds.priorityqueue;

/**
 * @author Surender
 * Interface to implement Priority Queue
 */
public interface PriorityQueueInterface {

	/**
	 * Method to add an element to the priority queue
	 * @param priority is the priority of the element
	 * @param value is the integer value to be added to priority queue
	 * @return true if value is added else return false
	 * @throws Exception when priority queue is full
	 */
	public boolean enQueue(int priority,String value)throws Exception;
	
	/**
	 * Method to remove the highest priority element from the priority queue
	 * @return the element with the highest priority
	 * @throws Exception when priority queue is empty
	 */
	public Element deQueue()throws Exception;
	
	/**
	 * Method to check if the priority queue is empty
	 * @return true if priority queue is empty else return false
	 */
	public boolean isEmpty();
	
	/**
	 * Method to check if the priority queue is full
	 * @return true if priority queue is full else return false
	 */
	public boolean isFull();

}
