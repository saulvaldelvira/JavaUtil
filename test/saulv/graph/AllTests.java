package saulv.graph;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BasicGraphTest.class, ExtraTest.class, L5_Floyd_EvalTest.class, L6_TestDijkstra.class,
		L6B_Exercises_sampleTest.class })
public class AllTests {

}
