package saulv.tree.bst;

import static org.junit.Assert.*;

import org.junit.Test;

import saulv.tree.Persona;

public class BSTreeTest {

	@Test
	public void addNodeTest() {
		BSTree<Integer>  tree = new BSTree<Integer>();
		
		//Nodos válidos -> Devuelve 0
		assertEquals(0, tree.addNode(10));
		assertEquals(0, tree.addNode(5));
		assertEquals(0, tree.addNode(15));
		assertEquals(0, tree.addNode(2));
		assertEquals(0, tree.addNode(7));
		assertEquals(0, tree.addNode(12));
		assertEquals(0, tree.addNode(6));
		
		//La clave es null
		assertEquals(-2, tree.addNode(null));
		
		//La clave ya existe
		assertEquals(-1, tree.addNode(10));
	}

	@Test
	public void searchTest() {
		BSTree<Integer>  tree = new BSTree<Integer>();
		//Raíz null -> null
		assertEquals(null, tree.searchNode(54));
		
		tree.addNode(10);
		tree.addNode(5);
		tree.addNode(6);
		tree.addNode(13);
		tree.addNode(11);
		
		//El elemento existe
		assertEquals(new BSTNode<Integer>(10).toString(), tree.searchNode(10).toString());
		assertEquals(new BSTNode<Integer>(5).toString(), tree.searchNode(5).toString());
		assertEquals(new BSTNode<Integer>(6).toString(), tree.searchNode(6).toString());
		assertEquals(new BSTNode<Integer>(13).toString(), tree.searchNode(13).toString());
		assertEquals(new BSTNode<Integer>(11).toString(), tree.searchNode(11).toString());
		
		//El elemento no existe
		assertEquals(null, tree.searchNode(45));
		
		//Clave null
		assertEquals(null, tree.searchNode(null));
	}
	
	@Test
	public void recorridosTest() {
		BSTree<Integer>  tree = new BSTree<Integer>();
		
		tree.addNode(10);
		tree.addNode(5);
		tree.addNode(6);
		tree.addNode(13);
		tree.addNode(11);
	
		String preOrder = "10\t5\t6\t13\t11";
		assertEquals(preOrder, tree.preOrder());
		String postOrder = "6\t5\t11\t13\t10";
		assertEquals(postOrder, tree.postOrder());
		String inOrder = "5\t6\t10\t11\t13";
		assertEquals(inOrder, tree.inOrder());
	}
	
	@Test
	public void personaTest() {
		BSTree<Persona> tree = new BSTree<Persona>();
		 assertEquals(0, tree.addNode(new Persona(12, "Manuel")));
		 assertEquals(0, tree.addNode(new Persona(19, "Samuel")));
		 assertEquals(0, tree.addNode(new Persona(19, "Alejandro")));
		 assertEquals(0, tree.addNode(new Persona(19, "Victor")));
		 assertEquals(0, tree.addNode(new Persona(5, "Laura")));
		 assertEquals("[Laura:5]\t[Manuel:12]\t[Victor:19]\t[Samuel:19]\t[Alejandro:19]", tree.inOrder());
		 assertEquals(0, tree.removeNode(new Persona(19, "Victor")));
		 assertEquals("[Laura:5]\t[Manuel:12]\t[Samuel:19]\t[Alejandro:19]", tree.inOrder());
	}
}
