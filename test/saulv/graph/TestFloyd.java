package saulv.graph;




import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import saulv.graph.Graph;


public class TestFloyd {

	@Test
	public void testFloyd() {
		Graph<Integer> graph = new Graph<Integer>(6);
		
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 4, 3);
		graph.addEdge(1, 5, 10);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 5, 1);
		graph.addEdge(4, 3, 2);
		graph.addEdge(4, 5, 6);
		graph.addEdge(4, 4, 6); 
		
		
		assertEquals(0, graph.floyd());
		
		double INF=Double.POSITIVE_INFINITY; 
		
		assertArrayEquals(new double[][]{{0.0, 1.0, 5.0, 3.0, 6.0 },
												{INF, 0.0, 5, INF, 6.0},
												{INF, INF, 0.0, INF, 1.0},
												{INF,INF, 2, 0.0, 3},
												{INF, INF, INF, INF, 0.0}},
				graph.getFloydA());
		
	}

	@Test
	public void testFloydPath() {
		Graph<Integer> graph = new Graph<Integer>(5);
		
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 2);
		graph.addEdge(3, 4, 2);
		graph.addEdge(3, 5, 4);
		graph.addEdge(4, 2, 1);
	    graph.addEdge(4, 3, 3);
		graph.addEdge(5, 4, 5);
		
		assertEquals(0, graph.floyd());
		
		String cadena="5	(5.0)	4	(3.0)	3";
        assertEquals(cadena, graph.path(5, 3));
         
        String cadena2 = "1	(1.0)	2	(2.0)	3	(2.0)	4";
        assertEquals(cadena2, graph.path(1, 4));
	}
}


