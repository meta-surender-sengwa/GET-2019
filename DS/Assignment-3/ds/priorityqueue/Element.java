package ds.priorityqueue;

/**
 * @author Surender
 * This class represents individual element in the priority queue
 */
public class Element {

	private int priority;
	private String value;

	public Element(int priority, String value) {
		this.priority = priority;
		this.value = value;
	}

	public int getPriority() {
		return this.priority;
	}

	public String getValue() {
		return this.value;
	}

}
