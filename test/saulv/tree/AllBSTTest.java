package saulv.tree;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import saulv.setting.Settings;
import saulv.setting.tree.BSTFactory;

@RunWith(Suite.class)
@SuiteClasses({
	saulv.tree.AddAllTest.class,
	saulv.tree.JoinsTest.class,
	saulv.tree.bst.AllTests.class
})
public class AllBSTTest {

	@BeforeClass
	public static <T extends Comparable<T>> void setUp() {
		Settings.treeFactory = new BSTFactory<T>();
	}
}
