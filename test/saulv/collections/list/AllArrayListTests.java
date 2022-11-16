package saulv.collections.list;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import saulv.collections.setting.ArrayListFactory;
import saulv.collections.setting.Settings;

@RunWith(Suite.class)
@SuiteClasses({ AddInPositionTests.class, AddLastTests.class, ClearTests.class,
		ContainsTests.class, EqualsTests.class, GetTests.class,
		HashCodeTests.class, IndexOfTests.class, IsEmptyTests.class,
		RemoveFromPositionTests.class, RemoveObjectTests.class, SetTests.class,
		SizeTests.class, ToStringTests.class })
public class AllArrayListTests {
	
	@BeforeClass
	public static <T> void setUp() {
		Settings.factory = new ArrayListFactory<T>();
	}

}
