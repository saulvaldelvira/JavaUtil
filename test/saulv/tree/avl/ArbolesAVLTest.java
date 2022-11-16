package saulv.tree.avl;

import static org.junit.Assert.*;

import org.junit.Test;

import saulv.tree.Persona;
import saulv.tree.avl.AVLTree;

public class ArbolesAVLTest {

	@Test
	public void test_Add() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		// Insertar una clave null
		assertEquals(-2, b.addNode(null));
		
		// 5, 18 10 -- RDD(10)
		assertEquals(0,b.addNode(5));
		assertEquals(0,b.addNode(18));
		assertEquals(0,b.addNode(10));
		assertEquals("5:BF=0\t10:BF=0\t18:BF=0",b.inOrder());
		
		// 40, 50 -- RSD(18)
		assertEquals(0,b.addNode(40));
		assertEquals(0,b.addNode(50));
		assertEquals("5:BF=0\t10:BF=1\t18:BF=0\t40:BF=0\t50:BF=0",b.inOrder());
		
		// 15 -- RDD(10)
		assertEquals(0,b.addNode(15));
		assertEquals("5:BF=0\t10:BF=0\t15:BF=0\t18:BF=0\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 16 
		assertEquals(0,b.addNode(16));
		assertEquals("5:BF=0\t10:BF=1\t15:BF=1\t16:BF=0\t18:BF=-1\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 12 
		assertEquals(0,b.addNode(12));
		assertEquals("5:BF=0\t10:BF=1\t12:BF=0\t15:BF=0\t16:BF=0\t18:BF=-1\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 14 -- RDD(10)
		assertEquals(0,b.addNode(14));
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=0\t14:BF=0\t15:BF=0\t16:BF=0\t18:BF=-1\t40:BF=1\t50:BF=0",b.inOrder());
		
		// 17 -- RDI(18)
		assertEquals(0,b.addNode(17));
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=-1\t14:BF=0\t15:BF=0\t16:BF=1\t17:BF=0\t18:BF=0\t40:BF=1\t50:BF=0",b.inOrder());
		
		// Inserta un elemento que ya existe
		assertEquals(-1,b.addNode(15));
	}

	@Test
	public void test_Remove() {
		AVLTree<Integer> b = new AVLTree<Integer>();
		// Borra una clave null
		assertEquals(-2, b.removeNode(null));
		
		// Borra en un árbol vacío
		assertEquals(-2, b.removeNode(12));
		
		// Insertar 5, 18 10, 40, 50, 15, 16, 12, 14, 17
		b.addNode(5);
		b.addNode(18);
		b.addNode(10);
		b.addNode(40);
		b.addNode(50);
		b.addNode(15);
		b.addNode(16);
		b.addNode(12);
		b.addNode(14);
		b.addNode(17);
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=-1\t14:BF=0\t15:BF=0\t16:BF=1\t17:BF=0\t18:BF=0\t40:BF=1\t50:BF=0",b.inOrder());
		
		// Borra un una clave que es null
		assertEquals(-2, b.removeNode(null));
		
		// Borra un elemento que no existe
		assertEquals(-1, b.removeNode(90));
		
		// Borra una clave sin hijos --> 50
		assertEquals(0, b.removeNode(50));
		assertEquals("5:BF=0\t10:BF=-1\t12:BF=-1\t14:BF=0\t15:BF=0\t16:BF=1\t17:BF=0\t18:BF=-1\t40:BF=0",b.inOrder());
		
		// Borra un elemento que no existe
		assertEquals(-1, b.removeNode(50));
		
		// Borra una clave con un hijo izquierdo --> 10
		assertEquals(0, b.removeNode(10));
		assertEquals("5:BF=0\t12:BF=0\t14:BF=0\t15:BF=1\t16:BF=1\t17:BF=0\t18:BF=-1\t40:BF=0",b.inOrder());
	
		// Borra la raíz que tiene dos hijos --> 15
		assertEquals(0, b.removeNode(15));
		assertEquals("5:BF=0\t12:BF=-1\t14:BF=1\t16:BF=1\t17:BF=0\t18:BF=-1\t40:BF=0",b.inOrder());
	
		// Borra la raíz que tiene dos hijos --> 14
		assertEquals(0, b.removeNode(14));
		assertEquals("5:BF=0\t12:BF=-1\t16:BF=0\t17:BF=0\t18:BF=0\t40:BF=0",b.inOrder());
		
		// Borra una clave que es hoja --> 17
		assertEquals(0, b.removeNode(17));
		assertEquals("5:BF=0\t12:BF=-1\t16:BF=0\t18:BF=1\t40:BF=0",b.inOrder());
		
		// Borra una clave que tiene un hijo derecho --> 18
		assertEquals(0, b.removeNode(18));
		assertEquals("5:BF=0\t12:BF=-1\t16:BF=-1\t40:BF=0",b.inOrder());
		
		// Borra una clave que es hoja --> 40
		assertEquals(0, b.removeNode(40));
		assertEquals("5:BF=0\t12:BF=0\t16:BF=0",b.inOrder());
		
		// Borra la raíz que tiene dos hijos --> 12
		assertEquals(0, b.removeNode(12));
		assertEquals("5:BF=1\t16:BF=0",b.inOrder());
		
		// Borra un hijo que es hoja --> 16
		assertEquals(0, b.removeNode(16));
		assertEquals("5:BF=0",b.inOrder());
		
		// Borra la raíz que no tiene hijos
		assertEquals(0, b.removeNode(5));
		
		// Borra el 5 
		assertEquals(-2, b.removeNode(5));
	}
	
	@Test
	public void personaTest() {
		AVLTree<Persona> tree = new AVLTree<Persona>();
		 assertEquals(0, tree.addNode(new Persona(12, "Manuel")));
		 assertEquals(0, tree.addNode(new Persona(19, "Samuel")));
		 assertEquals(0, tree.addNode(new Persona(19, "Alejandro")));
		 assertEquals(0, tree.addNode(new Persona(19, "Victor")));
		 assertEquals(0, tree.addNode(new Persona(5, "Laura")));
		 assertEquals("[Laura:5]:BF=0	[Manuel:12]:BF=0	[Victor:19]:BF=0	[Samuel:19]:BF=-1	[Alejandro:19]:BF=0", tree.inOrder());
		 assertEquals(0, tree.removeNode(new Persona(19, "Victor")));
		 assertEquals("[Laura:5]:BF=0	[Manuel:12]:BF=-1	[Samuel:19]:BF=-1	[Alejandro:19]:BF=0", tree.inOrder());
	}
	
	@Test
	public void padreDeTest() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		assertEquals(null,tree.padreDe(23));
		tree.addNode(5);
		tree.addNode(1);
		tree.addNode(4);
		tree.addNode(67);
		tree.addNode(-4);
		assertEquals(null,tree.padreDe(null));
		assertEquals(null,tree.padreDe(784));
		assertEquals("4:BF=0", tree.padreDe(1).toString());
		assertEquals("1:BF=-1", tree.padreDe(-4).toString());
		assertEquals("4:BF=0", tree.padreDe(4).toString());
		assertEquals("4:BF=0", tree.padreDe(5).toString());
		assertEquals("5:BF=1", tree.padreDe(67).toString());
	}
	
	@Test
	public void numAristasTest() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		assertEquals(-2, tree.numAristas(5, 47));
		tree.addNode(5);
		tree.addNode(1);
		tree.addNode(4);
		tree.addNode(67);
		tree.addNode(-4);
		assertEquals(-1, tree.numAristas(5, 47));
		assertEquals(-2, tree.numAristas(null, 23));
		assertEquals(-2, tree.numAristas(5, null));
		assertEquals(1, tree.numAristas(-4, 1));
		assertEquals(1, tree.numAristas(1, -4));
		assertEquals(3, tree.numAristas(-4, 5));
		assertEquals(4, tree.numAristas(-4, 67));
		assertEquals(3, tree.numAristas(1, 67));
		assertEquals(0, tree.numAristas(4, 4));
	}
	
	@Test
	public void searchNodeTest() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		assertEquals(null, tree.searchNode(34));
		tree.addNode(5);
		tree.addNode(1);
		tree.addNode(4);
		tree.addNode(67);
		tree.addNode(-4);
		assertEquals(null, tree.searchNode(null));
		assertEquals(null, tree.searchNode(43));
		assertEquals("4:BF=0", tree.searchNode(4).toString());
		assertEquals("1:BF=-1", tree.searchNode(1).toString());
		assertEquals("-4:BF=0", tree.searchNode(-4).toString());
		assertEquals("5:BF=1", tree.searchNode(5).toString());
		assertEquals("67:BF=0", tree.searchNode(67).toString());
	}

}
