package saulv.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import saulv.tree.avl.AVLTree;
import saulv.tree.bst.BSTree;


public class JoinsTest {

	@Test
	public void test() {
		AVLTree<Integer> avl1 = new AVLTree<Integer>(),
						 avl2 = new AVLTree<Integer>(), 
						 avlJoint = new AVLTree<Integer>();
		
		Integer[] set1 = {12, 5, 23, 9, -12},
			      set2 = {2354, 2, 233};
		
		avl1.addAll(set1);
		avl2.addAll(set2);
		
		avlJoint.addAll(set1);
		avlJoint.addAll(set2);
		
		assertEquals(avlJoint, avl1.joins(avl2));
		
		BSTree<Integer> bs1 = new BSTree<Integer>(),
						 bs2 = new BSTree<Integer>(), 
						 bstJoint = new BSTree<Integer>();
		bs1.addAll(set1);
		bs2.addAll(set2);
		
		bstJoint.addAll(set1);
		bstJoint.addAll(set2);
		
		assertEquals(bstJoint, bs1.joins(bs2));
		
	}

}
