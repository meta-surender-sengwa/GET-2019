package datastructure.rotatesublist;

public class RotateSubList {
	
	/**
	 * Method to return a subList of a linked list
	 * @param list is the linked list
	 * @param leftIndex
	 * @param rightIndex
	 * @return the desired subList
	 */
	private static LinkedList createSubList(LinkedList list, int leftIndex, int rightIndex) {
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
		
		int data[] = new int[rightIndex - leftIndex + 1];
		index = 0;
		currNode = leftNode;
		while (currNode != rightNode.next) {
			data[index] = currNode.data;
			currNode = currNode.next;
			index++;
		}
		LinkedList.insertNode(subList, data);
		return subList;
	}

	/**
	 * This function is used to rotate the subList for given numberOfRotation
	 * @param list is the linked-list 
	 * @param leftIndex
	 * @param rightIndex
	 * @param numberOfRotation is the number of time the sublist needs to be rotated
	 * @return the resultant rotated sublist
	 */
	public static int[] rotateSubList(LinkedList list, int leftIndex, int rightIndex, int numberOfRotation) {
		LinkedList subList = createSubList(list, leftIndex, rightIndex);

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
		
		LinkedList result = joinList(list, subList, leftIndex, rightIndex);	

		int count = 0;
		Node current = result.head ;
		while(current.next != null){
			count++;
			current = current.next;
		}
		
		int rotationArray[] = new int[count + 1];
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
	 * Method for joining the rotated subList back into main list
	 * @param mainList is the original list
	 * @param subList is the rotated sub list
	 * @param leftIndex
	 * @param rightIndex
	 * @return the resultant list after joining the rotated sublist back to the initial list 
	 */
	public static LinkedList joinList(LinkedList mainList, LinkedList subList, int leftIndex, int rightIndex) {
		Node head1 = mainList.head;
		Node head2 = subList.head;
		Node currNode1 = mainList.head;
		Node currNode2 = subList.head;

		int index = 0;
		if (leftIndex == 1) {
			mainList.head = head2;
			
			while (index != (rightIndex)) {
				index++;
				currNode1 = currNode1.next;
			}
			
			while (currNode2.next != null) {
				currNode2 = currNode2.next;
			}
			currNode2.next = currNode1;
			
		} else {
			index = 0;
			while (index != (rightIndex - 1)) {
				index++;
				head1 = head1.next;
			}
			
			index = 0;
			while (index != (leftIndex - 2)) {
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
