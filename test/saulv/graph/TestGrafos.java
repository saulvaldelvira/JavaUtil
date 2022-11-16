package saulv.graph;

import static org.junit.Assert.*;

import org.junit.Test;



public class TestGrafos {

	@Test
	public void testAddNode() {
		// Creamos un vector de nodos con tamaño 2
		Graph<Integer> graph = new Graph<Integer>(2);
		
		// Caso 1 - Añadimos el nodo al vector
		assertEquals(0, graph.getSize());
		assertEquals(0, graph.addNode(1));
		assertEquals(1, graph.getSize());
		assertEquals(0, graph.getNode(1));
	 
		// Caso 2 - Ya existe pero SÍ cabría (devuelve -1)
		assertEquals(-1, graph.addNode(1));
		
		//Caso 3 - Ya existe Y no cabe (devuelve -3)
		graph.addNode(6);//llenamos el grafo
		assertEquals(-3, graph.addNode(6));
		
		//Caso 4 - No existe pero no cabe (Devuelve -2)
		assertEquals(-2, graph.addNode(12));
		
		//Caso 5 - El nodo no es válido (Devuelve -4)
		assertEquals(-4, graph.addNode(null));
				
		
		System.out.println("AÑADIR NODO\nGrafo completo-->"+graph.toString());
		
		

	}

	@Test
	public void testGetNode() {
		// Creamos un vector de nodos con tamaño 2
		Graph<Integer> graph = new Graph<Integer>(2);
		assertEquals(graph.addNode(1),0);
		assertEquals(graph.addNode(2), 0);
		
		// Caso 1 - El nodo existe
		assertEquals(graph.getNode(2), 1);
		
		// Caso 2 - El nodo no existe
		assertEquals(-1, graph.getNode(5));
		assertEquals(-1, graph.getNode(null));
		
	}
	
	@Test
	public void testExistNode() {
		// Creamos un vector de nodos con tamaño 2
		Graph<Integer> graph = new Graph<Integer>(2);
		graph.addNode(1);
		graph.addNode(2);
		
		// Caso 1 - El nodo existe
		assertTrue(graph.existNode(2));
				
		// Caso 2 - El nodo no existe
		assertFalse(graph.existNode(5));
		
		// Caso 3 - El nodo es null
		assertFalse(graph.existNode(null));
	}
	
	
	@Test
	public void testAddEdge(){
		Graph<Integer> graph = new Graph<Integer>(5);
		
		// No hay nodos
		assertEquals(-3, graph.addEdge(1, 2, 1));
		assertEquals(graph.addNode(1), 0);
		assertEquals(graph.addNode(2), 0);
		assertEquals(graph.addNode(3), 0);
		assertEquals(graph.addNode(4), 0);
		assertEquals(graph.addNode(5), 0);
		assertEquals(graph.addEdge(1, 2, 1), 0);
		assertEquals(graph.addEdge(1, 5, 10), 0);
		assertEquals(graph.addEdge(1, 4, 3), 0);
		assertEquals(graph.addEdge(2, 3, 5), 0);
		assertEquals(graph.addEdge(2, 2, 4), 0);
		assertEquals(graph.addEdge(3, 5, 1), 0);
		assertEquals(graph.addEdge(4, 3, 2), 0);
		
		//No existe el nodo origen
		assertEquals(-1, graph.addEdge(45, 1, 14), 0);
		//No existe el nodo destino
		assertEquals(-2, graph.addEdge(2, 13, 5), 0);
		//No existen ambos nodos
		assertEquals(-3, graph.addEdge(875, 231, 17), 0);
		
		//Ya existe la arista
		assertEquals(-4, graph.addEdge(1, 2, 1), 0);
		
		//Peso negativo
		assertEquals(-8, graph.addEdge(4, 3, -6));
		
		System.out.print("AÑADIR ARISTA \n Grafo completo-->"+graph.toString());
		
		assertArrayEquals(graph.getweigths() ,new double[][]{{0.0, 1.0, 0.0, 3.0, 10.0 },
			{0, 4.0, 5.0, 0.0, 0.0},
			{0.0, 0.0, 0.0, 0.0, 1.0},
			{0.0,0.0, 2, 0.0, 0.0},
			{0.0, 0.0, 0.0, 0.0, 0.0}});
		
		assertArrayEquals(graph.getEdges() ,new boolean[][]{{false, true, false, true, true },
			{false, true, true, false, false},
			{false, false, false, false, true},
			{false,false, true, false, false},
			{false, false, false, false, false}});	
	}
	
	@Test
	public void testGetEdge() {
		// Creamos un vector de nodos con tamaño 2
		Graph<Integer> graph = new Graph<Integer>(2);
		graph.addNode(1);
		graph.addNode(2);
		
		// Caso 1 - No existe la arista
		assertEquals(graph.getEdge(1, 2), -4, 0.0);
		assertEquals(-4, graph.getEdge(2, 1), 0.0);
		
		// Caso 2 - existe la arista
		graph.addEdge(1, 2, 3);
		assertEquals(graph.getEdge(1, 2), 3, 0.0);
		
		//Caso 3 - No existe el nodo origen
		assertEquals(-1.0, graph.getEdge(5, 1), 0.0);
		assertEquals(-1, graph.getEdge(null, 2), 0.0);
		
		//Caso 4 - No existe el nodo destino
		assertEquals(-2, graph.getEdge(1, 8), 0.0);
		assertEquals(-2, graph.getEdge(2, null), 0.0);
		
		//Caso 5 - No existen ambos nodos
		assertEquals(-3, graph.getEdge(13, 45), 0.0);
		assertEquals(-3, graph.getEdge(null, null), 0.0);
	}
	
	@Test
	public void testExistEdge(){
		Graph<Integer> graph = new Graph<Integer>(5);
		assertEquals(graph.addNode(1), 0);
		assertEquals(graph.addNode(2), 0);
		assertEquals(graph.addNode(3), 0);
		assertEquals(graph.addNode(4), 0);
		assertEquals(graph.addNode(5), 0);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 5, 10);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 5, 1);
		graph.addEdge(4, 3, 2);
		
		// Los caminos existen
		assertTrue(graph.existEdge(1,2));
		assertTrue(graph.existEdge(1,5));
		assertTrue(graph.existEdge(2,3));
		assertTrue(graph.existEdge(3,5));
		assertTrue(graph.existEdge(4,3));
		
		//No existen los caminos
		assertFalse(graph.existEdge(5, 2));
		assertFalse(graph.existEdge(3, 3));
		assertFalse(graph.existEdge(1, 3));
		assertFalse(graph.existEdge(4, 5));
		assertFalse(graph.existEdge(5, 1));
		
		//No existen las aristas
		assertFalse(graph.existEdge(null, 2));
		assertFalse(graph.existEdge(3, null));
		assertFalse(graph.existEdge(null, null));
		assertFalse(graph.existEdge(32, 12));
		assertFalse(graph.existEdge(4, 25));
		assertFalse(graph.existEdge(3, 13));
	}
	
	@Test
	public void testRemoveEdge(){
		Graph<Integer> graph = new Graph<Integer>(5);
		assertEquals(graph.addNode(1),0);
		assertEquals(graph.addNode(2),0);
		assertEquals(graph.addNode(3),0);
		assertEquals(graph.addNode(4),0);
		assertEquals(graph.addNode(5),0);
		assertEquals(graph.addEdge(1, 2, 1),0);
		assertEquals(graph.addEdge(1, 5, 10),0);
		assertEquals(graph.addEdge(2, 3, 5),0);
		assertEquals(graph.addEdge(3, 5, 1),0);
		assertEquals(graph.addEdge(4, 3, 2),0);
		
		System.out.print("BORRAR ARISTA \n Grafo completo inicial-->"+graph.toString());
		
		// Caso 1 - la arista existe
		assertEquals(0, graph.removeEdge(1, 2));
		assertEquals(0, graph.removeEdge(1, 5));
		assertEquals(0, graph.removeEdge(2, 3));
		assertEquals(0, graph.removeEdge(3, 5));
		assertEquals(0, graph.removeEdge(4, 3));
		// Caso 2 - El nodo origen no existe
		assertEquals(-1, graph.removeEdge(12, 1));
		// Caso 3 - El nodo destino no existe
		assertEquals(-2, graph.removeEdge(2, 54));
		// Caso 4 - Ambos nodos no existen
		assertEquals(-3, graph.removeEdge(14, 45));
		//Caso 5 - No existe la arista
		assertEquals(-4, graph.removeEdge(2, 4));
		
		System.out.print("BORRAR ARISTA \n Grafo completo final-->"+graph.toString());
		
		assertArrayEquals(graph.getweigths() ,new double[][]{{0.0, 0.0, 0.0, 0.0, 0.0 },
			{0, 0.0, 0.0, 0.0, 0.0},
			{0.0, 0.0, 0.0, 0.0, 0.0},
			{0.0,0.0, 0.0, 0.0, 0.0},
			{0.0, 0.0, 0.0, 0.0, 0.0}});
		
		assertArrayEquals(graph.getEdges() ,new boolean[][]{{false, false, false, false, false },
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, false, false, false, false}});		
	}
	
	@Test
	public void testRemoveNode(){
		Graph<Integer> graph1 = new Graph<Integer>(4);
		
		graph1.addNode(1);
		graph1.addNode(2);
		graph1.addNode(3);
		graph1.addNode(4);
		
		graph1.addEdge(1, 3, 1);
		graph1.addEdge(1, 2, 2);
		graph1.addEdge(3, 2, 4);
		
		
		System.out.print("BORRAR NODO\n Grafo1  completo Inicial-->"+graph1.toString());
		
		// Caso 1 - Eliminar cualquier nodo que no ocupe la última posición
		assertEquals(0, graph1.removeNode(2));
		assertFalse(graph1.existNode(2));
		assertEquals(3, graph1.getSize());
		
		//Caso 2 - Eliminar nodo de la última posición
		assertEquals(0, graph1.removeNode(4));
		assertFalse(graph1.existNode(4));
		assertEquals(2, graph1.getSize());
		
		System.out.print("BORRAR NODO\n Grafo1 completo Final-->"+graph1.toString());
	}	

	@Test
	public void testGetSize() {
		// Creamos un vector de nodos con tamaño 2
		Graph<Integer> graph = new Graph<Integer>(2);
		
		// No hay nodos en el vector (vacío)
		assertEquals(graph.getSize(), 0);
		
		// Añadimos el primer nodo
		graph.addNode(1);
		assertEquals(graph.getSize(), 1);
		// Añadimos el segundo nodo
		graph.addNode(2);
		assertEquals(graph.getSize(), 2);
	}
}
