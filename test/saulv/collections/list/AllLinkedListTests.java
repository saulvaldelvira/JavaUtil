package saulv.collections.list;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import saulv.setting.Settings;
import saulv.setting.collections.list.LinkedListFactory;

@RunWith(Suite.class)
@SuiteClasses({ AddInPositionTests.class, AddLastTests.class, ClearTests.class,
		ContainsTests.class, EqualsTests.class, GetTests.class,
		HashCodeTests.class, IndexOfTests.class, IsEmptyTests.class,
		RemoveFromPositionTests.class, RemoveObjectTests.class, SetTests.class,
		SizeTests.class, ToStringTests.class })
public class AllLinkedListTests {

	@BeforeClass
	public static <T> void setUp() {
		Settings.listFactory = new LinkedListFactory<T>();
	}

}
