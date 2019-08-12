package graph;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class TestGraph {

	GraphImplementation graph = new GraphImplementation(4);
	
	@Test
	public void testAddEdge() throws Exception {
		
		assertTrue(graph.addEdge(0, 1, 1));
		assertTrue(graph.addEdge(0, 2, 2));
		assertTrue(graph.addEdge(1, 3, 4));
		assertTrue(graph.addEdge(2, 3, 5));
	}
	
	@Test
	public void testIsConnected() throws Exception {
		assertTrue(graph.addEdge(0, 1, 1));
		assertTrue(graph.addEdge(0, 2, 2));
		assertTrue(graph.addEdge(1, 3, 4));
		assertTrue(graph.addEdge(2, 3, 5));
		
		assertTrue(graph.isConnected());
	}
	
	@Test
	public void testAllReachableVertices() throws Exception {
		assertTrue(graph.addEdge(0, 1, 1));
		assertTrue(graph.addEdge(0, 2, 2));
		assertTrue(graph.addEdge(1, 3, 4));
		assertTrue(graph.addEdge(2, 3, 5));
		
		ArrayList<Integer> actual = graph.allReachableVertices(0);
		
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testShortestPath() throws Exception {
		assertTrue(graph.addEdge(0, 1, 1));
		assertTrue(graph.addEdge(0, 2, 2));
		assertTrue(graph.addEdge(1, 3, 4));
		assertTrue(graph.addEdge(2, 3, 5));
		
		assertEquals(5, graph.shortestPath(0, 3));
	}
}
