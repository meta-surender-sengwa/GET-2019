package graph;

import java.util.ArrayList;

/**
 * Interface to Graph Implementation
 * @author Surender
 */
public interface Graph {

	/**
	 * This method checks if the graph is connected or not
	 * @return true if graph is connected else return false
	 */
	public boolean isConnected();

	/**
	 * This method finds all reachable vertices from a given a vertex in graph
	 * @return ArrayList containing list of vertices which are reachable 
	 * @throws Exception
	 */
	public ArrayList<Integer> allReachableVertices(int vertex) throws Exception;

	/**
	 * This method finds the minimum spanning tree in the graph
	 * @return ArrayList of ArrayList containing details about the edges between vertices that create minimum spanning tree
	 */
	public ArrayList<Edge> minimumSpanningTree();

	/**
	 * This method finds the shorted path between given two vertices in the graph
	 * @return list of vertices which creates the shortest path
	 */
	public int shortestPath(int startingVerted, int endingVertex);
}
