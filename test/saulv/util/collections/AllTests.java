package saulv.util.collections;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import saulv.util.collections.list.AllArrayListTests;
import saulv.util.collections.list.AllLinkedListTests;

/**
 * The Class AllTests.
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	AllArrayListTests.class, 
	AllLinkedListTests.class,
	saulv.util.collections.iterator.AllTests.class, 
	saulv.util.collections.queue.AllQueueTests.class,
	saulv.util.collections.stack.AllStackTests.class
})
public class AllTests {

}
