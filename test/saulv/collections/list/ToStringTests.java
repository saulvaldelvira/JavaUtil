package saulv.collections.list;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;

public class ToStringTests {
	
	private List<String> list;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.listFactory.newList();
	}

	/*
	 * Escenarios
	 * 1- Una lista vacía tiene "[]" como toString				
     * 2- Una lista con un elemento "A" tiene "[A]" como toString				
     * 3- Una lista con dos elementos "A" y "B" tiene "[A, B]" como toString				
	 */
	
	/**
	 * GIVEN: Lista vacía
	 * WHEN: se llama al método toString
	 * THEN: devuelve "[]"
	 */
	@Test
	public void toStringEmptyTest() {
		assertEquals("[]", list.toString());
	}
	
	/**
	 * GIVEN: Lista contiene "A"
	 * WHEN: se llama al método toString
	 * THEN: devuelve "[A]"
	 */
	@Test
	public void toStringContainsElementTest() {
		list.add("A");
		
		assertEquals("[A]", list.toString());
	}
	
	/**
	 * GIVEN: Lista contiene "A"
	 * WHEN: se llama al método toString
	 * THEN: devuelve "[A]"
	 */
	@Test
	public void toStringContainsElementsTest() {
		list.add("A");
		list.add("B");
		
		assertEquals("[A, B]", list.toString());
	}

	
}
