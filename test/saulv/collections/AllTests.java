package saulv.collections;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import saulv.collections.list.AllArrayListTests;
import saulv.collections.list.AllLinkedListTests;

/**
 * The Class AllTests.
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	AllArrayListTests.class, 
	AllLinkedListTests.class,
	saulv.collections.iterator.AllTests.class, 
	saulv.collections.queue.AllQueueTests.class,
	saulv.collections.stack.AllStackTests.class
})
public class AllTests {

}
