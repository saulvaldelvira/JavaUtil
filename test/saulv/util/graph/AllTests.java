package saulv.util.graph;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDijstra.class, TestFloyd.class, TestGrafos.class, TestRecorridoProfundidad.class, FloydPivotsTest.class })
public class AllTests {

}
