import java.util.NoSuchElementException;

/**
 * @author Surender
 * This class implements a stack using a linked-list and methods to convert an infix expression to a postfix expression
 */
public class InfixToPostfix {
	Node top;

	/**
	 * Inner class Node
	 */
	class Node {
		char data;
		Node next;

		/**
		 * Constructor for node class
		 */
		Node() {
			this.next = null;
		}
	}
	
	/**
	 * Constructor for main class
	 */
	public InfixToPostfix() {
		this.top = null;
	}
	
	/**
	 * Method to add an element at the top of the stack
	 * @param data is the element to be inserted
	 */
	public void push(char data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (top == null)
			top = newNode;
		else {
			Node temp = top;
			top = newNode;
			newNode.next = temp;
		}
	}

	/**
	 * Method to delete the top most element from the stack
	 * @return the value of the deleted element
	 */
	public char pop() {
		if (top == null) {
			throw new NoSuchElementException("Stack is Empty !!!!!");
		}
		
		Node node = top;
		top = node.next;

		return node.data;
	}

	/**
	 * Method to return the element at the top of the stack
	 * @return the element at the top of the stack
	 */
	public char peek() {
		if (top == null) {
			System.out.println("Stack is Empty !!!!!");
			return ' ';
		} else {
			return top.data;
		}
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
	 * Method to check if the stack is empty
	 * @return true if stack is empty else return false
	 */
	public boolean isEmpty() {
		return (top == null);
	}

	/**
	 * Method to set the precedence of the opertator used in the expression 
	 * @param i
	 * @return
	 */
	private int Precedence(char character) {
		switch (character) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1 ;
	}

	/**
	 * Method to convert an infix expression into postfixExpression
	 * @param infixExpression
	 * @return equivalent postfixExpression
	 */
	public String infixToPostfix(String infixExpression) {
		
		String postfixExpression = new String("");
		InfixToPostfix stack = new InfixToPostfix();
		
		for (int index = 0; index < infixExpression.length(); index++) {
			char character = infixExpression.charAt(index);
			
			if (Character.isLetterOrDigit(character)) {
				postfixExpression += character;
			} 
			
			else if (character == '(') {
				stack.push(character);
			} 
			
			else if (character == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfixExpression = postfixExpression + stack.pop();
				}
				
				if (!stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression";
				} else {
					stack.pop();
				}
			} 
			
			else {
				while (!stack.isEmpty() && Precedence(character) <= Precedence(stack.peek())) {
					if (stack.peek() == '(') {
						return "Invalid Expression";
					}
					postfixExpression += stack.pop();
				}
				stack.push(character);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				return "Invalid Expression";
			}
			postfixExpression += stack.pop();
		}
		return postfixExpression;
	}
}