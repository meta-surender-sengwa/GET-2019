/**
 * @author Surender
 * This Class implements methods like enQueue ,deQueue, isQueueEmpty and isQueueFull and displayQueue of a queue
 */
public class QueueOperations implements Queue {

	
	int size, front, rear;
	int queue[];
	
	/**
	 * Constructor
	 * @param size is the size of the queue
	 */
	public QueueOperations(int size) {
		this.front = -1;
		this.rear = -1;
		this.size = size;
		queue = new int[size];
	}

	/**
	 * Method to add an element in the queue
	 * @param data is the element to be added
	 * @return true if element is added else return false  
	 */
	@Override
	public boolean enQueue(int data) {
		if (isQueueFull()) {
			System.out.println("Queue is full");
			return false;
		} else if (front == -1) {
			front = rear = 0;
			queue[rear] = data;
		} else if (rear == size - 1 && front != 0) {
			rear = 0;
			queue[rear] = data;
		} else {
			rear++;
			queue[rear] = data;
		}
		
		return true;
	}

	/**
	 * Method to delete the top-most element from the queue
	 * @return true if element is deleted else return false
	 */
	@Override
	public boolean deQueue() {
		if (isQueueEmpty()) {
			System.out.println("Queue is Empty");
			return false;
		} else {
			queue[front] = -1;
			
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (front == size - 1) {
				front = 0;
			} else {
				front++;
			}
		}
		return true;
	}

	/**
	 * Method to check if the queue is empty
	 * @return true if queue is empty else return false
	 */
	@Override
	public boolean isQueueEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}
	
	/** 
	 * Method to check if the queue is full
	 * @return true if the queue is full else return false 
	 */
	@Override
	public boolean isQueueFull() {
		if ((front == rear + 1) || (front == 0 && rear == size - 1))
			return true;
		return false;
	}

	/**
	 * Method to shows all the elements of the queue
	 */
	@ Override
	public int[] displayQueue() {
		int [] result = new int[size];
		
		if (front == -1) {
			System.out.println("\nQueue is Empty");
		}
		
		if (rear >= front) {
			for (int index = front; index <= rear; index++) {
				result[index] = queue[index];
			}
		} else {
			for (int index = front; index < size; index++) {
				result[index]= queue[index];
			}

			for (int index = 0; index <= rear; index++) {
				result[index]= queue[index];
			}
		}
		return result;
	}

}
