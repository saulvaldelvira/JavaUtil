package util.collections;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import util.collections.list.AllArrayListTests;
import util.collections.list.AllLinkedListTests;

@RunWith(Suite.class)
@SuiteClasses({ 
	AllArrayListTests.class, 
	AllLinkedListTests.class,
	util.collections.iterator.AllTests.class, 
	util.collections.queue.AllQueueTests.class,
	util.collections.stack.AllStackTests.class
})
public class AllTests {

}
