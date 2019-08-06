package ds.priorityqueue;

/**
 * @author Surender
 * This class represents priority queue
 */
public class PriorityQueue implements PriorityQueueInterface {

	private Element[] priorityQueue;
	private int backIndex = 0;

	public PriorityQueue() {
		priorityQueue = new Element[10];
	}
	
	public PriorityQueue(int size){
		priorityQueue = new Element[size + 1];
	}
	
	/**
	 * Method add element in the priority queue
	 * @param priority is the priority of the element
	 * @param value is the integer to be added to priority queue
	 * @return true if value is added else return false
	 * @throws Exception when priority queue is full
	 */
	@Override
	public boolean enQueue(int priority, String value) throws Exception {
		try {
			if (priorityQueue[priorityQueue.length - 1] != null) {
				throw new Exception("Queue is full");
			}

			Element element = new Element(priority, value);
			
			if (priorityQueue[1] == null) {
				backIndex++;
				priorityQueue[backIndex] = element;
				return true;
			}

			int elementIndex = backIndex + 1;
			priorityQueue[elementIndex] = element;
			backIndex++;
			
			this.setOrderAfterEnQueue(elementIndex);

			return true;

		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Method to remove the highest priority element from the priority queue
	 * @return the element which is removed
	 * @throws Exception when priority queue is empty
	 */
	@Override
	public Element deQueue() throws Exception {

		try {
			if (priorityQueue[1] == null) {
				throw new Exception("Queue is empty");
			}
			
			int elementIndex = backIndex ;
			
			Element element = priorityQueue[1];
			Element lastElement = priorityQueue[elementIndex];
			priorityQueue[elementIndex] = null;
			priorityQueue[1] = new Element(lastElement.getPriority(), lastElement.getValue());
			backIndex--;
			
			this.setOrderAfterDequeue(1);
			return element;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Method to reorder the priority queue after insertion of any element
	 * @param elementIndex index of element which is added
	 */
	private void setOrderAfterEnQueue(int elementIndex) {

		int indexOfNewElement = elementIndex;
		Element newElement = priorityQueue[indexOfNewElement];
		
		while (indexOfNewElement != 1) {
			int indexOfParentElement = indexOfNewElement / 2;
			Element parentElement = priorityQueue[indexOfParentElement];

			if (parentElement.getPriority() < newElement.getPriority()) {
				this.swap(indexOfParentElement, indexOfNewElement);
				this.setOrderAfterEnQueue(indexOfParentElement);
			}
			break;
		}
	}

	/**
	 * Method to reorder the priority queue after deletion of any element
	 * @param elementIndex index of top element in queue
	 */
	private void setOrderAfterDequeue(int elementIndex) {

		int parentElementIndex = elementIndex;
		int leftChildIndex = parentElementIndex * 2;
		int rightChildIndex = (parentElementIndex * 2) + 1;

		while (priorityQueue[leftChildIndex] != null || priorityQueue[rightChildIndex] != null) {

			Element parentElement = priorityQueue[parentElementIndex];
			Element leftChild = priorityQueue[leftChildIndex];
			Element rightChild = priorityQueue[rightChildIndex];
			
			boolean isSwap = false;
			
			if (rightChild != null) {

				if (leftChild.getPriority() >= rightChild.getPriority() && leftChild.getPriority() > parentElement.getPriority()) {
					this.swap(parentElementIndex, leftChildIndex);
					parentElementIndex = leftChildIndex;
					isSwap = true;
				} else if (rightChild.getPriority() > parentElement.getPriority()) {
					this.swap(parentElementIndex, rightChildIndex);
					parentElementIndex = rightChildIndex;
					isSwap = true;
				}

			} else if (leftChild != null && (leftChild.getPriority() > parentElement.getPriority())) {
				this.swap(parentElementIndex, leftChildIndex);
				parentElementIndex = leftChildIndex;
				isSwap = true;
			}
			
			if(!isSwap){
				break;
			}
			
			if(parentElementIndex == backIndex-1 || parentElementIndex == backIndex){
				break;
			}
			
			leftChildIndex = parentElementIndex * 2;
			rightChildIndex = (parentElementIndex * 2) + 1;
		}
	}

	/**
	 * This method swap to element in priority queue
	 * @param firstElementIndex index of first element
	 * @param secondElementIndex index of second element
	 */
	private void swap(int firstElementIndex, int secondElementIndex) {

		Element element = new Element(priorityQueue[firstElementIndex].getPriority(),
				priorityQueue[firstElementIndex].getValue());
		
		priorityQueue[firstElementIndex] = new Element(priorityQueue[secondElementIndex].getPriority(),
				priorityQueue[secondElementIndex].getValue());
		
		priorityQueue[secondElementIndex] = element;
	}

	/**
	 * Method to check if the priority queue is empty
	 * @return true if priority queue is empty else return false
	 */
	@Override
	public boolean isEmpty() {
		if (backIndex == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method to check if the priority queue is full
	 * @return true if priority queue is full else return false
	 */
	@Override
	public boolean isFull() {
		if (backIndex == priorityQueue.length - 1) {
			return true;
		}
		return false;
	}
}
