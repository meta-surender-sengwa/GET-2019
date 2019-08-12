package graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class to implement a graph and related methods
 * @author Surender
 */
public class GraphImplementation implements Graph {
    private int numberOfVertices;
    private ArrayList<Edge>[] edgeList; 

    @SuppressWarnings("unchecked")
	public GraphImplementation(int numberOfVertices)   {
        
    	this.numberOfVertices = numberOfVertices;
        edgeList = new ArrayList[this.numberOfVertices];
        
    	for(int index = 0; index < this.numberOfVertices; index++) {
            edgeList[index] = new ArrayList<Edge>();
        }
    }
    
    /**
     * Method to add an edge into the graph
     * @param source is the source vertex
     * @param destination is the destination vertex
     * @param weight is the weith of the edge
     * @throws Exception
     */
    public boolean addEdge(int source, int destination, int weight) throws Exception     {
    	
    	if(source < 0 || source >= numberOfVertices) {
    		throw new Exception ("Invalid source Vertex");
    	}
    	
    	if(destination < 0 || destination >= numberOfVertices) {
    		throw new Exception ("Invalid destination Vertex");
    	}
    	
    	if (source == destination) {
			throw new Exception ("Both vertex cannot be same");
		}
    	
		if(weight <= 0) {
			throw new Exception("Weight should be a positive integer value");
		}
		
		for(int index=0; index < edgeList[source].size(); index++) {
			
			if(edgeList[source].get(index).getSourceVertex() == source && edgeList[source].get(index).getDestinationVertex() == destination) {
				throw new Exception("Edge between Vertex "+ source +" and Vertex "+ destination +" already exists");
			}
			
			if(edgeList[source].get(index).getSourceVertex() == destination && edgeList[source].get(index).getDestinationVertex() == source) {
				throw new Exception("Edge between Vertex "+ destination +" and Vertex "+ source +" already exists");
			}
		}
		
        edgeList[source].add(new Edge(source, destination, weight));
        edgeList[destination].add(new Edge(destination, source, weight));
        
        return true;
    }

    /**
     * Method to check whether the graph is connected or not using DFS traversal
     * @return boolean value
     */
    @Override
    public boolean isConnected() {
        
        Boolean[] nodeTraversed = new Boolean[numberOfVertices];
        
        for(int index = 0; index < numberOfVertices; index++) {
            nodeTraversed[index] = false;
        }
        
        dfsTraversal(0, nodeTraversed);
        
        for(int index = 0; index < numberOfVertices; index++) {
            if(nodeTraversed[index] == false) {
                return false;
            }  
        }        
        return true;
    }
    
    /**
     * Method to find all the vertices which are reachable from a given source vertex
     * @param vertex is the source vertex
     * @return list of reachable vertices
     */
    @Override
    public ArrayList<Integer> allReachableVertices(int vertex) throws Exception  {
    	
    	ArrayList<Integer> reachableNodes = new ArrayList<Integer>();
        Boolean[] nodeTraversed = new Boolean[numberOfVertices];
        
        for(int index = 0; index < numberOfVertices; index++) {
            nodeTraversed[index] = false;
        }
        
        dfsTraversal(vertex, nodeTraversed);
        
        for(int index = 0; index < numberOfVertices; index++) {
            if(index != vertex && nodeTraversed[index] == true) {
                reachableNodes.add(index);
            }
        }
        return reachableNodes;
    }
    
    /**
     * Method to create the minimum spanning tree using greedy approach
     * @return list of edges in minimum spanning tree
     */
    @Override
    public ArrayList<Edge> minimumSpanningTree()    {
    	
    	ArrayList<Edge> minSpanningtree = new ArrayList<>();
        
    	int parent[] = new int[numberOfVertices];
        int key[] = new int[numberOfVertices];
        
        Boolean mstSet[] = new Boolean[numberOfVertices];
        
        for (int index = 0; index < numberOfVertices; index++)  {
            key[index] = Integer.MAX_VALUE;
            mstSet[index] = false;
        }
        
        key[0] = 0; 
        parent[0] = -1; 
        
        for (int count = 0; count < this.numberOfVertices - 1; count++)  {
            int minKey = minKey(key, mstSet);
            
            mstSet[minKey] = true;
            ArrayList<Edge> edges = edgeList[minKey];
            
            for (Edge edge : edges) {
                int v = edge.getDestinationVertex();
                
                if (!mstSet[v] && edge.getWeight() < key[v])   {   
                    parent[v] = minKey;
                    key[v] = edge.getWeight();                      
                }
            }
        }
       
        for (int index = 1; index < this.numberOfVertices; index++)  {
        	ArrayList<Edge> edges = edgeList[index];
            
            for (Edge edgeConnected : edges)  {  
            	if (edgeConnected.getDestinationVertex() == parent[index])  {
                    Edge edge = new Edge(parent[index], index, edgeConnected.getWeight());
                    minSpanningtree.add(edge);
                }
            }
        }
        return minSpanningtree;
    }

    /**
     * Method to find the shortest path from a source to destination
     * @param source is the source vertex
     * @param destination is the destination vertex
     * @return shortest path
     */
    @Override
	public int shortestPath(int startingVertex, int endingVertex) {
    	ArrayList<Edge> adjacentEdges = new ArrayList<>();
        int distance[] = new int[this.numberOfVertices]; 
        
        Boolean processed[] = new Boolean[this.numberOfVertices];
        
        for (int index = 0; index < this.numberOfVertices; index++)   {
            distance[index] = Integer.MAX_VALUE;
            processed[index] = false;
        }
        
        distance[startingVertex] = 0;
        
        for (int count = 0; count < this.numberOfVertices - 1; count++)  {
            int shortestDistanceNode = minKey(distance, processed);
        
            processed[shortestDistanceNode] = true;
            adjacentEdges = edgeList[shortestDistanceNode];
            
            for (Edge listEdges : adjacentEdges) {
                int v = listEdges.getDestinationVertex();
                
                if (!processed[v] && distance[shortestDistanceNode] + listEdges.getWeight() < distance[v]) {
                    distance[v] = distance[shortestDistanceNode] + listEdges.getWeight();
                }                                    
            }            
        }
        return distance[endingVertex];
    }
    
    /**
     * Helper Method to find the vertex with the minimum key
     * @param key
     * @param processed
     * @return vertex with the minimum key
     */
    private int minKey(int key[], Boolean processed[]) {
        
    	int min = Integer.MAX_VALUE, minIndex = -1;
        for (int vertex = 0; vertex < this.numberOfVertices; vertex++) {
        
        	if (processed[vertex] == false && key[vertex] < min) {
                min = key[vertex];
                minIndex = vertex;
            }
        }
        return minIndex;
    }
    
    /**
     * Helper Method for Depth First Traversal
     * @param graphNode is
     * @param nodeTraversed
     */
    private void dfsTraversal(int graphNode, Boolean[] nodeTraversed) {        
        
    	nodeTraversed[graphNode] = true;
    	Iterator<Edge> iterator = edgeList[graphNode].iterator();
        
        while(iterator.hasNext()) {
        
        	int node = iterator.next().getDestinationVertex();
            if(!nodeTraversed[node]) {
                dfsTraversal(node, nodeTraversed);
            }
        }
    }
}