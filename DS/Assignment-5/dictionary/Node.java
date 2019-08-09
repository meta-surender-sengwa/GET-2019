package dictionary;

/**
 *
 * This class represents node in binary search tree
 * @author Surender Sengwa
 * 
 */
public class Node {

	private final String key;
	private final String value;
	
	public Node leftChildNode;
	public Node rightChildNode;
	
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public Node getLeftChildNode() {
		return leftChildNode;
	}

	public void setLeftChildNode(Node leftChildNode) {
		this.leftChildNode = leftChildNode;
	}

	public Node getRightChildNode() {
		return rightChildNode;
	}

	public void setRightChildNode(Node rightChildNode) {
		this.rightChildNode = rightChildNode;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
