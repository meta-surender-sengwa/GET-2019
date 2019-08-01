
public class CheckLoopInLinkedList {

	Node head;
	
	public  void push(int newData[]) { 
		
		for(int i = 0; i < newData.length ; i++) {
			Node newNode = new Node(newData[i]); 
			newNode.next = head; 
			head = newNode; 
		}
		
		head.next.next.next.next = head; 
	    detectLoop(); 
	} 

	public boolean detectLoop() { 
		Node slowPointer = head;
		Node fastPointer = head;
		
		while ((slowPointer != null) && (fastPointer != null) && (fastPointer.next != null)) { 
			slowPointer = slowPointer.next; 
			fastPointer = fastPointer.next.next;
			
			if (slowPointer == fastPointer) { 
				System.out.println("Found loop"); 
				return true; 
			} 
		} 
		return false; 
	} 
} 