package saulv.tree;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import saulv.setting.Settings;


public class AddAllTest {


	@Test
	public void test() {
		@SuppressWarnings("unchecked")
		Tree<Integer> avl = Settings.treeFactory.newTree();
		
		Integer[] numbers = {0, 1, 2, 3, null, 15, null, null};
		
		avl.addAll(numbers);
		
		ArrayList<Integer> avlList = new ArrayList<Integer>();
		
		avl.addElementsTo(avlList);
		
		assertEquals(5, avlList.size());
		
		for(int i=0; i<numbers.length; i++)
			if(numbers[i]!=null)
				assertTrue(avl.contains(numbers[i]));
			
		
		avl.removeAll(numbers);
		
		assertTrue(avl.empty());
	}

}
