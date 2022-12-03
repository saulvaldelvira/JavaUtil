package saulv.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import saulv.setting.Settings;


public class JoinsTest {

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		Tree<Integer> t1 = Settings.treeFactory.newTree(),
						 t2 = Settings.treeFactory.newTree(), 
						 tJoint = Settings.treeFactory.newTree();
		
		Integer[] set1 = {12, 5, 23, 9, -12},
			      set2 = {2354, 2, 233};
		
		t1.addAll(set1);
		t2.addAll(set2);
		
		tJoint.addAll(set1);
		tJoint.addAll(set2);
		
		assertEquals(tJoint, t1.joins(t2));
		
	}

}
