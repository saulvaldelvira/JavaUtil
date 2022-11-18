package saulv.tree;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import saulv.tree.avl.AVLTree;
import saulv.tree.bst.BSTree;


public class AddAllTest {


	@Test
	public void test() {
		AVLTree<Integer> avl = new AVLTree<Integer>();
		BSTree<Integer> bst = new BSTree<Integer>();
		
		Integer[] numbers = {0, 1, 2, 3, null, 15, null, null};
		
		avl.addAll(numbers);
		bst.addAll(numbers);
		
		ArrayList<Integer> avlList = new ArrayList<Integer>(),
						   bslList = new ArrayList<Integer>();
		
		avl.getElements(avlList);
		bst.getElements(bslList);
		
		assertEquals(5, avlList.size());
		assertEquals(5, bslList.size());
		
		for(int i=0; i<numbers.length; i++)
			if(numbers[i]!=null) {
				assertTrue(avl.contains(numbers[i]));
				assertTrue(bst.contains(numbers[i]));
			}
		
		avl.removeAll(numbers);
		bst.removeAll(numbers);
		
		assertTrue(avl.isEmpty());
		assertTrue(bst.isEmpty());
	}

}
