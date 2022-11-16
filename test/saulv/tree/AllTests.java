package saulv.tree;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({saulv.tree.avl.AllTests.class, saulv.tree.bst.AllTests.class, saulv.tree.priorityQueue.ColasPrioridadTest.class})
public class AllTests {

}
