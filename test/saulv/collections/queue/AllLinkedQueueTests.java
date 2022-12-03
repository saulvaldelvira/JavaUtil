package saulv.collections.queue;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import saulv.setting.Settings;
import saulv.setting.collections.queue.LinkedListQueueFactory;




@RunWith(Suite.class)
@SuiteClasses({ DequeueTest.class, EnqueueTest.class, IsEmptyTest.class, PeekTest.class, SizeTest.class })
public class AllLinkedQueueTests {

	@BeforeClass
	public static <T> void setUp() {
		Settings.queueFactory = new LinkedListQueueFactory<T>();
	}
	
}
