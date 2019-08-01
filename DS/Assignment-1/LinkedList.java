/**
 * @author Surender Sengwa
 * This class implements a linked list 
 */
public class LinkedList {
	Node head;

	/**
	 * Method to insert new nodes in the link list and returning the updated list
	 * @param list of type linked list
	 * @param data is an array of values to be inserted
	 * @return list is the link list in which elements are to be inserted
	 */
	public static LinkedList insert(LinkedList list, int data[]) {
		
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
	 * Method to print the LinkedList.
	 * @param list is the link list to be printed
	 */
	public static void printList(LinkedList list) {
		Node currNode = list.head;
		System.out.print("LinkedList: ");
		
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}	
}
