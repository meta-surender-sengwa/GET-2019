package graph;

/**
 * This Class implements an Edge of a graph
 * @author Surender
 */
public class Edge {
	
	private int sourceVertex;
	private int destinationVertex;
	private int weight;
	
	public Edge(int sourceVertex, int destinationVertex, int weight) {
		this.sourceVertex = sourceVertex;
		this.destinationVertex = destinationVertex;
		this.weight = weight;
	}
	
	public int getSourceVertex() {
		return sourceVertex;
	}
	
	public void setSourceVertex(int sourceVertex) {
		this.sourceVertex = sourceVertex;
	}
	
	public int getDestinationVertex() {
		return destinationVertex;
	}
	
	public void setDestinationVertex(int destinationVertex) {
		this.destinationVertex = destinationVertex;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
}