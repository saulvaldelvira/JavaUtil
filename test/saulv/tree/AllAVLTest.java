package saulv.tree;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import saulv.setting.tree.AVLFactory;

@RunWith(Suite.class)
@SuiteClasses({
	saulv.tree.AddAllTest.class,
	saulv.tree.JoinsTest.class, 
	saulv.tree.avl.AllTests.class
})
public class AllAVLTest {
	@BeforeClass
	public static <T extends Comparable<T>> void setUp() {
		saulv.setting.Settings.treeFactory = new AVLFactory<T>();
	}
}
