import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class MyGraphTest {
	
	private MyGraph g;
	
	@Before
	public void setUp() throws Exception {
		g = new MyGraph();
	}
	
	@Test
	public void testAddEdge() {
		assertEquals(0, g.numEdges());
		g.addEdge('a', 'b', 5);
		assertEquals(1, g.numEdges());
		g.addEdge('a', 'c', 3);
		assertEquals(2, g.numEdges());
		g.addEdge('b', 'a', 4);
		assertEquals(2, g.numEdges());
	}
	
	@Test
	public void testNumNodes() {
		assertEquals(0, g.numNodes());
		g.addEdge('a', 'b', 5);
		assertEquals(2, g.numNodes());
		g.addEdge('a', 'c', 3);
		assertEquals(3, g.numNodes());
		g.addEdge('b', 'a', 4);
		assertEquals(3, g.numNodes());
	}
	
	@Test
	public void testEdgeWeight() {
		g.addEdge('a', 'b', 5);
		assertEquals(5, g.edgeWeight('b', 'a'));
	}

	/* Methods to implement */

	@Test
	public void testContainsNode() {
		assertFalse(g.containsNode('c'));
		g.addEdge('a', 'b', 3);
		assertFalse(g.containsNode('c'));
		g.addEdge('a', 'c', 3);
		assertTrue(g.containsNode('c'));
	}
	
	@Test
	public void testContainsEdge() {
		assertFalse(g.containsEdge('a', 'c'));
		g.addEdge('a', 'b', 3);
		assertFalse(g.containsEdge('a', 'c'));
		g.addEdge('c', 'a', 3);
		assertTrue(g.containsEdge('a', 'c'));
		assertTrue(g.containsEdge('c', 'a'));
	}
	
	@Test
	public void testIsConnected() {
		assertFalse(g.isConnected('a', 'b'));
		g.addEdge('a', 'b', 3);
		assertTrue(g.isConnected('a', 'b'));
	}
	
	@Test
	public void testNeighbors() {
		g.addEdge('c', 'a', 3);
		g.addEdge('a', 'b', 3);
		List<Character> n = g.neighbors('a');
		assertEquals(2, n.size());
		assertFalse(n.contains('a'));
		assertTrue(n.contains('b'));
		assertTrue(n.contains('c'));
	}
	
	@Test
	public void testShortestPath() {
		g.addEdge('a', 'c', 5);
		g.addEdge('a', 'b', 1);
		g.addEdge('b', 'c', 2);
		assertEquals(3, g.shortestPath('a', 'c'));
	}

	@Test
	public void testDepthFirst() {
		System.out.println("Depth first (should be a, b, c, d):");
		g.addEdge('a', 'b', 5);
		g.addEdge('a', 'd', 6);
		g.addEdge('b', 'c', 4);
		g.depthFirst('a');
	}

	@Test
	public void testBredthFirst() {
		System.out.println("Depth first (should be a, b, d, c):");
		g.addEdge('a', 'b', 5);
		g.addEdge('a', 'd', 6);
		g.addEdge('b', 'c', 4);
		g.bredthFirst('a');
	}

}
