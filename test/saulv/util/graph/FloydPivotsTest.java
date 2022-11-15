package saulv.util.graph;

import static org.junit.Assert.*;

import org.junit.Test;


public class FloydPivotsTest {

	@Test
	public void test() {
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
		
		graph.floydPivots(new Integer[] {2, 4});
		
		double INF=Double.POSITIVE_INFINITY; 
		
		assertArrayEquals(new double[][]{{0.0, 1.0, 5.0, 3.0, 9.0 },
												{INF, 0.0, 5, INF, INF},
												{INF, INF, 0.0, INF, 1.0},
												{INF,INF, 2, 0.0, 6},
												{INF, INF, INF, INF, 0.0}},
				graph.getFloydA());
		
		graph.addEdge(5, 1, 2);
		graph.addEdge(1, 3, 3);
		graph.floydPivots(new Integer[] {1, 2, 4});
		
		assertArrayEquals(new double[][]{{0.0, 1.0, 3.0, 3.0, 9.0 },
											{INF, 0.0, 5, INF, INF},
											{INF, INF, 0.0, INF, 1.0},
											{INF,INF, 2, 0.0, 6},
											{2, 3, 5, 5, 0.0}}, 
				graph.getFloydA());
	}

}
