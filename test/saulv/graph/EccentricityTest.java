package saulv.graph;

import static org.junit.Assert.*;
import saulv.exception.*;

import org.junit.Test;


public class EccentricityTest {

	@Test
	public void test() {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addNode(1);
		g.addNode(2);
		g.addNode(3);
		g.addNode(4);
		
		g.addEdge(2, 4, 1.0);
		g.addEdge(4, 3, 1.0);
		g.addEdge(3, 1, 1.0);
		
		assertEquals(3.0, g.eccentricity(1), 0.001);
		assertEquals(Graph.INFINITE , g.eccentricity(3), 0.001);
		assertEquals(Graph.INFINITE, g.eccentricity(4), 0.001);
		assertEquals(Graph.INFINITE, g.eccentricity(2), 0.001);
		g.addEdge(1, 4, 2);
		
		
		
		g.addEdge(3, 2, 5.0);
		
		assertEquals(8.0, g.eccentricity(2), 0.001);
		
		g.addNode(5);
		
		try {
			g.eccentricity(null);
			fail();
		}catch(NullPointerException e) {
			
		}
		
		try {
			g.eccentricity(12);
			fail();
		}catch(ElementNotPresentException e) {
			
		}
		
		g.addEdge(2, 5, 2.0);
		assertEquals(10.0, g.eccentricity(5), 0.001);
	}

}
