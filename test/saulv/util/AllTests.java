package saulv.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({saulv.util.collections.AllTests.class, 
				saulv.util.tree.AllTests.class,
				saulv.util.graph.AllTests.class,
				saulv.util.hash.AllTests.class})
public class AllTests {

}
