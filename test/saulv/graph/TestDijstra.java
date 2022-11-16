package saulv.graph;


import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import saulv.graph.Graph;



public class TestDijstra {
 
	@Test
	public void testDijkstra1(){
		Graph<Integer> graph = new Graph<Integer>(6);
		
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 5, 10);
		graph.addEdge(1, 4, 3);
		graph.addEdge(2, 3, 5);
		graph.addEdge(2, 2, 4);
		graph.addEdge(3, 5, 1);
		graph.addEdge(4, 3, 2);
		graph.addEdge(4, 5, 6); 
		
		// Nodo fuente
		assertArrayEquals(new double[]{0.0,1.0,5.0,3.0,6.0}, graph.dijkstra(1), 0);
		
		assertArrayEquals(new double[]{Double.POSITIVE_INFINITY,0.0, 5.0,
		  Double.POSITIVE_INFINITY, 6.0}, graph.dijkstra(2), 0);
		assertArrayEquals(new double[]{Double.POSITIVE_INFINITY,
		  Double.POSITIVE_INFINITY, 0.0, Double.POSITIVE_INFINITY, 1.0},
		  graph.dijkstra(3), 0); 
		assertArrayEquals(new double[]{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 2.0, 0.0, 3.0},
		  graph.dijkstra(4), 0); 
		assertArrayEquals(new double[]{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
		  Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.0}, graph.dijkstra(5),
		  0);
		  
		// Nodo no existe 
		assertArrayEquals(null, graph.dijkstra(6), 0);
		assertArrayEquals(null, graph.dijkstra(null), 0);
		  
		//Añadimos otra arista 
		graph.addEdge(5,2,1);
		  
		assertArrayEquals(new double[]{0.0,1.0,5.0,3.0,6.0},
		  graph.dijkstra(1), 0); 
		assertArrayEquals(new
		  double[]{Double.POSITIVE_INFINITY,0.0, 5.0, Double.POSITIVE_INFINITY, 6.0},
		  graph.dijkstra(2), 0); 
		assertArrayEquals(new
		  double[]{Double.POSITIVE_INFINITY, 2.0, 0.0, Double.POSITIVE_INFINITY, 1.0},
		  graph.dijkstra(3), 0); 
		assertArrayEquals(new
		  double[]{Double.POSITIVE_INFINITY, 4.0, 2.0, 0.0, 3.0}, graph.dijkstra(4),
		  0); 
		assertArrayEquals(new double[]{Double.POSITIVE_INFINITY, 1.0, 6.0,
		  Double.POSITIVE_INFINITY, 0.0}, graph.dijkstra(5), 0);
		 
		//Añadimos un nodo aislado 
		graph.addNode(6);
		assertArrayEquals(new double[]{0.0,1.0,5.0,3.0,6.0, Double.POSITIVE_INFINITY}, graph.dijkstra(1), 0);  		 
    	assertArrayEquals(new double[]{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,
    			Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY, 0.0} , graph.dijkstra(6), 0);
	}

}
