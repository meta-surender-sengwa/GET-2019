/**
 * @author Surender
 * This class implements method to evaluate the infix expression by first converting it to a  postfix expression
 */
public class PostfixEvaluation {
	static Node top;

	/**
	 * Inner class Node
	 */
	static class Node {
		int data;
		Node next;

		/**
		 * Constructor for inner class
		 */
		Node() {
			this.next = null;
		}
	}

	/**
	 * Method to add an element at the top of the stack
	 * @param data is the element to be inserted
	 */
	public static void push(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (top == null) {
			top = newNode;
		} else {
			Node temp = top;
			top = newNode;
			newNode.next = temp;
		}
	}

	/**
	 * Method to delete the top most element from the stack
	 * @return the value of the deleted element
	 */
	public static int pop() {
		if (isEmpty()) {
			return 0;
		}
		int data = top.data;
	       top = top.next;
		return data;
	}

	/**
	 * Method to return the element at the top of the stack
	 * @return the element at the top of the stack
	 */
	public static int peek() {
		if (top == null) {
			return 0;
		} else {
			return top.data;
		}
	}

	/**
	 * Method to check if the stack is empty
	 * @return true if stack is empty else return false
	 */
	public static boolean isEmpty() {
		return top == null;
	}

	/**
	 * Method to print the elements of the stack as a linked list
	 */
	public void display() {
		if (top == null) {
			System.out.printf("\nStack Underflow");
		} else {
			Node temp = top;
			
			while (temp != null) {
				System.out.printf("%d->", temp.data);
				temp = temp.next;
			}
		}
	}

	/**
	 * Method to evaluate the postfix expression
	 * @param expression is the postfix expression
	 * @return the evaluation result in int
	 */
	static int evaluatePostfix(String expression) {

		for (int index = 0; index < expression.length(); index++) {
			char character = expression.charAt(index);
              
			// If the scanned character is an operand (number here),
			// push it to the stack.
			if (Character.isDigit(character)) {
				push(character - '0');
			}

			// If the scanned character is an operator, pop two
			// elements from stack apply the operator
			else {
				int value1 = pop();
				int value2 = pop();
	
				switch (character) {		
				case '+':
					int ans = value2 + value1;
					push(ans);
					break;

				case '-':
					int ans1 = value2 - value1;
					push(ans1);
					break;

				case '/':
					int ans3 = value2/value1;
					push(ans3);
					break;

				case '*':
					int ans4 = value2 * value1;
					push(ans4);
					break;
				case '^':
					int ans5 = (int) Math.pow(value2,value1);
					push(ans5);
					break;
				}
			}
		}
		int last = pop();
		return last;
	}

	/**
	 * main Method
	 */
	/*
	public static void main(String[] args) {
		InfixToPostfix stack = new InfixToPostfix();
		String infixExpression = "1+2*(2^3-4)-7";
		String postfixExpression = stack.infixToPostfix(infixExpression);
		
		System.out.println("infix expression is  "+ infixExpression);
		System.out.println("postfix expression is  "+ postfixExpression);
		
		int evaluationResult = PostfixEvaluation.evaluatePostfix(postfixExpression);
		System.out.println("postfix evaluation: " + evaluationResult);
	}
	*/
}
