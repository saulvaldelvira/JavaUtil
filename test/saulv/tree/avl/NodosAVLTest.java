package saulv.tree.avl;

import static org.junit.Assert.*;

import org.junit.Test;


public class NodosAVLTest {

	@Test
	public void updateBFHeightTest() {
		AVLNode<Integer> node = new AVLNode<Integer>(5);
		assertEquals(0, node.getHeight());
		assertEquals(0, node.getBF());
		assertEquals("5:BF=0", node.toString());
		
		node.setLeft(new AVLNode<Integer>(3));
		node.updateBFHeight();
		assertEquals(1, node.getHeight());
		assertEquals(-1, node.getBF());
		assertEquals("5:BF=-1", node.toString());
		
		node.setRight(new AVLNode<Integer>(9));
		node.updateBFHeight();
		assertEquals(1, node.getHeight());
		assertEquals(0, node.getBF());
		assertEquals("5:BF=0", node.toString());
		
		node.setLeft(null);
		node.updateBFHeight();
		assertEquals(1, node.getHeight());
		assertEquals(1, node.getBF());
		assertEquals("5:BF=1", node.toString());
	}	
}
