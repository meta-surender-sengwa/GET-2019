package dictionary;

/**
 * @author Surender
 * This class represent node in binary search tree
 */
public class Node {

	private final String key;
	private final String value;
	
	public Node leftChild;
	public Node rightChild;
	
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
