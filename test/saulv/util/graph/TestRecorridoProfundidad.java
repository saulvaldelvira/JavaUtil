package saulv.util.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestRecorridoProfundidad {

	Graph<Integer> graph;
	
	@Before
	public void setUp() {
		graph = new Graph<Integer>(4);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 1);
		graph.addEdge(2, 4, 3);
		graph.addEdge(4, 4, 5);
		graph.addEdge(4, 3, 6);
		graph.addEdge(3, 2, 4);
	}
	
	@Test
	public void testProfundidadCorrecto() {
		String expectedFrom1 = "1\t2\t4\t3\t";
		assertEquals(expectedFrom1, graph.recorridoProfundidad(1));
		String expectedFrom2 = "2\t4\t3\t";
		assertEquals(expectedFrom2, graph.recorridoProfundidad(2));
		String expectedFrom3 = "3\t2\t4\t";
		assertEquals(expectedFrom3, graph.recorridoProfundidad(3));
		String expectedFrom4 = "4\t3\t2\t";
		assertEquals(expectedFrom4, graph.recorridoProfundidad(4));
	}
	
	@Test
	public void testProfundidadNodoInvalido(){
		assertEquals("", graph.recorridoProfundidad(null));
		assertEquals("", graph.recorridoProfundidad(12));
	}

}
