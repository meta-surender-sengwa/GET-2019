/**
 * @author Surender Sengwa
 * This class implements methods to find degree of a multi-variant polynomial  
 */
public class MultivariantPolynomial {
	Node head = null;

	class Node {
		int data;
		Node next;
		Node down;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.down = null;
		}
	}

	/**
	 * @param coefficient is 1d array storing coefficients of the polynomial 
	 * @param exponent is a 2d array storing the 
	 * Helper method to call createLinkList function()
	 */
	public void helper(int coefficient[], int exponent[][]) {
		int expo[] = new int[exponent[0].length];
		
		for (int i = 0; i < coefficient.length; i++) {
			
			for (int j = 0; j < exponent[0].length; j++) {
				expo[j] = exponent[i][j];
			}
			
			createLinkList(coefficient[i], expo);
		}
	}

	/**
	 * @param coefficient
	 * @param expoArray
	 * This method is creating linked list
	 */
	public void createLinkList(int coefficient, int[] exponentArray) {
		Node newNode = new Node(coefficient);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			
			while (temp.next != null) {
				temp = temp.next;
			}
			
			temp.next = newNode;
		}
		
		for (int i = 0; i < exponentArray.length; i++) {
			Node newNode1 = new Node(exponentArray[i]);
			newNode.down = newNode1;
			newNode = newNode1;
		}
	}

	/**
	 * It is a method used to find max degree of the polynomial.
	 * @return max
	 */
	public int findDegree() {
		int max = 0;
		if (head == null) {
			System.out.println("No items in the list!!!");
			return 0;
		}
		
		Node temp = head;
		while (temp != null) {
			int sum = 0;
			Node temp1 = temp;
		
			while (temp1.down != null) {
				sum = sum + temp1.down.data;
				temp1 = temp1.down;
			}
			
			if (sum > max) {
				max = sum;
			}
			
			temp = temp.next;
		}
		return max;
	}
}