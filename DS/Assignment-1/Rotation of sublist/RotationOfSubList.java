/**
 * @author Surender Semgwa
 * Class to implement rotation of sub-list of given linked-list given the left and right indices and the number of rotations 
 */
public class RotationOfSubList {

	/**
	 * This function is creating a sub-list from a given linked-list from left index to right index
	 * @param list is the linked list
	 * @param leftIndex
	 * @param rightIndex
	 * @return subList of the linked-list
	 */
	private static LinkedList subListCreation(LinkedList list, int leftIndex, int rightIndex) {
		Node currNode = list.head;
		Node leftNode;
		Node rightNode;
		LinkedList subList = new LinkedList();

		int index = 0;
		while (index != (leftIndex - 1)) {
			index++;
			currNode = currNode.next;
		}
		leftNode = currNode;
		leftNode.data = currNode.data;
		
		index = 0;
		currNode = list.head;
		while (index != (rightIndex - 1)) {
			index++;
			currNode = currNode.next;
		}
		rightNode = currNode;
		rightNode.data = currNode.data;
		
		index = 0;
		currNode = leftNode;
		int data[] = new int[rightIndex - leftIndex + 1];
		while (currNode != rightNode.next) {
			data[index] = currNode.data;
			currNode = currNode.next;
			index++;
		}
		LinkedList.insert(subList, data);
		return subList;
	}

	/**
	 * This function is used to rotate the sub-List for given number Of Rotations
	 * @param list is the linked list
	 * @param leftIndex
	 * @param rightIndex
	 * @param numberOfRotation is the number of rotations
	 * @return the resulting rotated list
	 */
	public static int[] rotation(LinkedList list, int leftIndex, int rightIndex, int numberOfRotation) {
		
		LinkedList subList = subListCreation(list, leftIndex, rightIndex);

		while (numberOfRotation != 0) {
			Node firstNode = subList.head;
			Node currNode = subList.head;
			
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			
			currNode.next = firstNode;
			subList.head = firstNode.next;
			firstNode.next = null;
			numberOfRotation--;
		}
		
		LinkedList result = join(list, subList, leftIndex, rightIndex);
		
		Node current = result.head ;
		int count = 0;
		while(current.next != null){
			count++;
			current = current.next;
		}
		
		int rotationArray[] = new int[count+1];
		int index = 0;
		current = result.head;
		
		while(current != null ){
			rotationArray[index] = current.data;
			current = current.next;
			index++;
		}
		
		return rotationArray;
	}

	/**
	 * This function is joining the rotated subList back into main list
	 * @param mainList is the main linked list
	 * @param subList is the rotated sub-list
	 * @param leftIndex
	 * @param rightIndex
	 * @return the main linked list having rotated sublist
	 */
	private static LinkedList join(LinkedList mainList, LinkedList subList, int left, int right) {
		Node head1 = mainList.head;
		Node currNode1 = mainList.head;
		
		Node head2 = subList.head;
		Node currNode2 = subList.head;

		int index = 0;
		if (left == 1) {
			mainList.head = head2;
			
			while (index != (right)) {
				index++;
				currNode1 = currNode1.next;
			}
			
			while (currNode2.next != null) {
				currNode2 = currNode2.next;
			}
			currNode2.next = currNode1;
			
		} else {
			index = 0;
			while (index != (right - 1)) {
				index++;
				head1 = head1.next;
			}
			
			index = 0;
			while (index != (left - 2)) {
				index++;
				currNode1 = currNode1.next;
			}
			
			currNode1.next = subList.head;

			while (currNode2.next != null) {
				currNode2 = currNode2.next;
			}
			currNode2.next = head1.next;
		}
		return mainList;
	}
}
