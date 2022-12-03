package saulv;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({saulv.collections.AllTests.class, 
				saulv.tree.AllTests.class,
				saulv.graph.AllTests.class,
				//saulv.hash.AllTests.class
				saulv.heap.BinaryHeapTest.class})
public class AllTests {

}
