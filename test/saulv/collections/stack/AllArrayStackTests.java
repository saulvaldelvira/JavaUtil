package saulv.collections.stack;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import saulv.collections.setting.ArrayListStackFactory;
import saulv.collections.setting.Settings;

@RunWith(Suite.class)
@SuiteClasses({ IsEmptyTest.class, PeekTest.class, PopTest.class, PushTest.class, SizeTest.class })
public class AllArrayStackTests {

	@BeforeClass
	public static <T> void setUp() {
		Settings.stackFactory = new ArrayListStackFactory<T>();
	}
	
}
