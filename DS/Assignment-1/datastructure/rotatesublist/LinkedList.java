package datastructure.rotatesublist;


/**
 * @author Surender Sengwa
 * This class implements a linked list
 */
public class LinkedList {
	public Node head;
	
	
	/**
	 * Method to insert a new node and return the updated linked list
	 * @param list is the linked list
	 * @param data[] is the array of values to be inserted
	 * @return the updated linked list
	 */
	public static LinkedList insertNode(LinkedList list, int[] data) {
		for (int i = 0; i < data.length; i++) {
			Node newNode = new Node(data[i]);
			newNode.next = null;
			
			if (list.head == null) {
				list.head = newNode;
			} else {
				Node last = list.head;
				while (last.next != null) {
					last = last.next;
				}
				last.next = newNode;
			}
		}
		return list;
	}

	/**
	 * Method to print the LinkedList
	 * @param list is the linkedList to be printed
	 */
	public static void printList(LinkedList list) {
		Node currentNode = list.head;
		
		System.out.print("LinkedList: ");
		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.next;
		}
	}
}