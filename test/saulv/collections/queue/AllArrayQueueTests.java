package saulv.collections.queue;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import saulv.collections.setting.ArrayListQueueFactory;
import saulv.collections.setting.Settings;



@RunWith(Suite.class)
@SuiteClasses({ EnqueueTest.class, DequeueTest.class, IsEmptyTest.class, 
	PeekTest.class, SizeTest.class})
public class AllArrayQueueTests {

	@BeforeClass
	public static <T> void setUp() {
		Settings.queueFactory = new ArrayListQueueFactory<T>();
	}
	
}