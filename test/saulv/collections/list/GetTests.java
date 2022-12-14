package saulv.collections.list;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;

public class GetTests {
	
	private List<String> list;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.listFactory.newList();
	}
	
    /*
     * Casos:
     * 1- Get devuelve cada elemento en una lista con elementos
     * 2- Intentar realizar get en la posici?n 0 de una lista vac?a, lanza IndexOutOfBoundsException
     * 3- Intentar realizar get en la posici?n -1 de una lista vac?a, lanza IndexOutOfBoundsException
     * 4- Intentar realizar get en la posici?n -1 de una lista con elementos, lanza IndexOutOfBoundsException
     * 5- Intentar realizar get en la posici?n size() de una lista con elementos, lanza IndexOutOfBoundsException
     */
	
	 /**
     * GIVEN Una lista vac?a
     * WHEN se llama a get(0)
     * THEN Salta IndexOutOfBoundsException
     */
	@Test 
	(expected = IndexOutOfBoundsException.class)
	public void get0() {		
		list.get(0);
	}
	
	   /**
     * GIVEN Una lista vac?a
     * WHEN se llama a get(-1)
     * THEN Salta IndexOutOfBoundsException
     */
	@Test 
	(expected = IndexOutOfBoundsException.class)
	public void getMinus1() {
		
		list.get(-1);
	}
	
	  /**
     * GIVEN Una lista no vac?a
     * WHEN se llama a get(-1)
     * THEN Salta IndexOutOfBoundsException
     */
	@Test 
	(expected = IndexOutOfBoundsException.class)
	public void notEmptyMinus1() {
		
		list.add(0, "test1");
		list.add(0, "test2");
		list.add(0, "test3");
		list.add(0, "test4");
		
		list.get(-1);
	}
	
	 /**
     * GIVEN Una lista vac?a
     * WHEN se llama a get(size())
     * THEN Salta IndexOutOfBoundsException
     */
	@Test 
	(expected = IndexOutOfBoundsException.class)
	public void emptyGetSize() {
		
		list.get(list.size());
	}

}
