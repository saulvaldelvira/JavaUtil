package saulv.graph;

import static org.junit.Assert.*;

import org.junit.Test;


public class ExtraTest {

	@Test
	public void TestDrainSource() {
		Graph<Character> g = new Graph<Character>(3);
		g.addNode('A');
		g.addNode('B');
		g.addNode('C');
		
		g.addEdge('A', 'B', 2.0);
		g.addEdge('A', 'C', 5.0);
		g.addEdge('B', 'C', 1.0);
		g.addEdge('B', 'B', 0.1);
		
		assertTrue(g.isSourceNode('A'));
		assertFalse(g.isSourceNode('B'));
		assertFalse(g.isSourceNode('C'));
		assertTrue(g.isDrainNode('C'));
		assertFalse(g.isDrainNode('A'));
		assertFalse(g.isDrainNode('B'));
	}
	
	@Test
	public void esAccesibleTest() {
		Graph<Character> g = new Graph<Character>(5);
		g.addNode('A');
		g.addNode('B');
		g.addNode('C');
		g.addNode('D');
		g.addEdge('A', 'B', 0.5);
		g.addEdge('B', 'C', 1.0);
		g.addEdge('C', 'D', 2.5);
		g.addEdge('D', 'C', 12.5);
		
		assertTrue(g.esAccesible('D'));
		assertTrue(g.esAccesible('C'));
		assertFalse(g.esAccesible('A'));
		assertFalse(g.esAccesible('B'));
	}
	
	@Test
	public void containsCyclesTest() {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		
		assertFalse(g.containsCycles());
		
		g.addEdge(1, 2, 1.2);
		
		assertFalse(g.containsCycles());
		
		g.addEdge(2, 3, 12.3);
		
		assertFalse(g.containsCycles());
		
		g.addEdge(3, 1, 3.2);
		
		assertTrue(g.containsCycles());
		
		g.removeEdge(2, 3);
		
		assertFalse(g.containsCycles());
		
		g.addEdge(1, 1, 1.2);
		
		assertTrue(g.containsCycles());
		
	}

	@Test
	public void shortestTest() {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		
		g.addEdge(1, 2, 1.2);
		assertEquals(1, g.shortestPathLength(1, 2));
		
		g.addEdge(3, 1, 2.2);
		assertEquals(2, g.shortestPathLength(3, 2));
		
		g.addEdge(2, 3, 4.4);
		assertEquals(2, g.shortestPathLength(1, 3));
		
		//g.addEdge(3, 4, g.shortestPathLenght(null, null))
		
		
	}
	
	@Test
	public void stronglyConectedTest() {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addNode(1);
		g.addNode(2);
		g.addEdge(1, 2, 2);
		assertFalse(g.isStronglyConected());
		g.addEdge(2, 1, 1);
		assertTrue(g.isStronglyConected());
		
		g.addNode(3);
		assertFalse(g.isStronglyConected());
		g.addEdge(1, 3, 1);
		g.addEdge(3, 2, 1);
		//g.addEdge(2, 3, 1);
		assertTrue(g.isStronglyConected());
	}
	
	@Test
	public void semiConectedTest() {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addNode(1);
		g.addNode(2);
		g.addEdge(1, 2, 2);
		assertTrue(g.isSemiConected());
		
		g.addNode(3);
		assertFalse(g.isSemiConected());
		g.addEdge(3, 1, 2.2);
		//g.addEdge(2, 3, 0.1);
		assertTrue(g.isSemiConected());
		
		g.addNode(4);
		g.addEdge(3, 4, 1.2);
		assertFalse(g.isSemiConected());
//		g.addEdge(4, 2, 1);
//		g.addEdge(2, 1, 1);
		//assertTrue(g.isSemiConected());
		assertFalse(g.isStronglyConected());
		
	}
	
	@Test
	public void weaklyConectedTest() {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addNode(1);
		g.addNode(2);
		g.addEdge(1, 2, 2);
		assertTrue(g.isWeaklyConnected());
		
		g.addNode(3);
		assertFalse(g.isWeaklyConnected());
		g.addEdge(3, 1, 2.2);
		//g.addEdge(2, 3, 0.1);
		assertTrue(g.isWeaklyConnected());
		
		g.addNode(4);
		g.addEdge(3, 4, 1.2);
		assertTrue(g.isWeaklyConnected());
		
		assertFalse(g.isStronglyConected());
		assertFalse(g.isSemiConected());
	}
	
	@Test 
	public void testReciprocity() {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addNode(1);
		g.addNode(2);
		g.addEdge(1, 2, 2);
		assertEquals(0, g.getReciprocity(), 0.001);
		g.addEdge(2, 1, 2);
		assertEquals(1, g.getReciprocity(), 0.001);
		
		g.addNode(3);
		
		g.addEdge(1, 3, 2);
		assertEquals(2.0/3, g.getReciprocity(), 0.00001);
		
		g.addEdge(3, 2, 2);
		assertEquals(2.0/4, g.getReciprocity(), 0.00001);
		
		g.addEdge(3, 1, 2);
		assertEquals(4.0/5, g.getReciprocity(), 0.00001);
		
		g.addEdge(2, 3, 2);
		assertEquals(6.0/6, g.getReciprocity(), 0.00001);
	}
	
	@Test
	public void testMinCostPath() {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addNode(1);
		g.addNode(2);
		g.addEdge(1, 2, 2);
		g.addNode(3);
		g.addEdge(2, 3, 1.2);
		
		assertEquals(3.2, g.minCostPath(1, 3), 0.001);
	}
}
