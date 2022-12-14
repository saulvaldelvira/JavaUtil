package saulv.collections.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;

public class ContainsTests {
	
	private List<String> list;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.listFactory.newList();
	}
	
	/*
	 * Escenarios
	 * Una lista vac?a no contiene un elemento arbitrario			
     * Una lista con varios elementos no contiene al elemento 			
     * Una lista con un elemento contiene al elemento			
     * Una lista con varios elemento contiene al elemento			
     * Una lista vac?a no contiene null			
     * Una lista con elementos no contiene null			
	 */

	/**
	 * GIVEN: La lista est? vac?a
	 * WHEN: comprobar si tiene un elemento arbitrario
	 * THEN: devuelve false
	 */
	@Test
	public void missingElement1Test() {
		assertEquals(false, list.contains(  "A"));
	}
	
	/**
	 * GIVEN: La lista contiene 3 elementos
	 * WHEN: comprobar si tiene un elemento arbitrario
	 * THEN: devuelve false
	 */
	@Test
	public void missingElement2Test() {
		list.add(  "A");
		list.add(  "B");
		list.add(  "C");
		
		assertEquals(false, list.contains(  "D"));
	}
	
	/**
	 * GIVEN: La lista contiene 1 elemento
	 * WHEN: comprobar si tiene un elemento arbitrario
	 * THEN: devuelve true
	 */
	@Test
	public void elementInListTest() {
		list.add(  "A");
		
		assertEquals(true, list.contains(  "A"));
	}
	
	/**
	 * GIVEN: La lista contiene 3 elemento
	 * WHEN: comprobar si tiene un elemento arbitrario
	 * THEN: devuelve true
	 */
	@Test
	public void elementsInListTest() {
		list.add(  "A");
		list.add(  "B");
		list.add(  "C");
		
		assertEquals(true, list.contains(  "B"));
	}
	
	/**
	 * GIVEN: La lista est? vac?a
	 * WHEN: comprobar si tiene un elemento null
	 * THEN: lanza una excepci?n
	 */
	@Test
	(expected= NullPointerException.class)
	public void nullElementTest() {
			list.contains(null);		
	}
	
	/**
	 * GIVEN: La lista contiene 3 elementos
	 * WHEN: comprobar si tiene un elemento null
	 * THEN: lanza una excepci?n
	 */
	@Test
	public void nullElementInListTest() {
		list.add(  "A");
		list.add(  "B");
		list.add(  "C");
		try {
			list.contains(null);
			fail();
		}catch (NullPointerException e) {
			
		}
		
	}
	
	

}
