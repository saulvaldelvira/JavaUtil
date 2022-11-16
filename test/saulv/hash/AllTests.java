package saulv.hash;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClosedHashTableConRedispersionTest.class, ClosedHashTableSinRedispersionTest.class })
public class AllTests {

}
