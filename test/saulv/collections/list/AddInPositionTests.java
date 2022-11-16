package saulv.collections.list;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import saulv.collections.setting.Settings;

public class AddInPositionTests {
	
	private List<String> list;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}
	
	/*
     * Casos:
     * 1- Add en la posición 0 de una lista vacía añade el elemento
     * 2- Add en la posición 0 de una lista con varios elementos añade el elemento y mueve el resto una posición a la derecha
     * 3- Add en una posición intermedia de una lista añade el elemento y mueve el resto una posición a la derecha
     * 4- Add en la última posición de una lista con elementos añade el elemento
     * 5- Add en la posición después del último de una lista con elementos añade el elemento 
     * 6- Intentar añadir  en una posición negativa, se lanza IndexOutOfBoundsException 
     * 7- Intentar añadir en una posicón > size(), se lanza IndexOutOfBoundsException
     * 8- Intentar añadir un null, se lanza IllegalArgumentException
     */

	/**
     * GIVEN Una lista vacía
     * WHEN Se añade un elemento en el índice 0
     * THEN Se añade correctamente
     */
	@Test
	public void emptyList() {
		
		list.add(0,  "test");
		
		assertEquals(0, list.indexOf("test"));
	}

	/**
     * GIVEN Una lista no vacía
     * WHEN Se añade un elemento en el índice 0
     * THEN Se añade correctamente
     */
	@Test
	public void filledList0() {
		
		list.add(0,  "test");
		list.add(0,  "test2");
		list.add(0,  "test3");
		list.add(0,  "test4");
		list.add(0, "test5");
		
		assertEquals(0, list.indexOf("test5"));
		assertEquals(1, list.indexOf("test4"));
	}
	
	 /**
     * GIVEN Una lista no vacía
     * WHEN Se añade un elemento en un índice intermedio
     * THEN Se añade correctamente
     */
	@Test
	public void filledListintermediateIndex() {
		
		list.add(0, "test");
		list.add(1,  "test2");
		list.add(2,  "test3");
		list.add(3,  "test4");
		list.add(2,  "test5");
		
		assertEquals(2, list.indexOf("test5"));
		assertEquals(3, list.indexOf("test3"));
	}
	
	/**
     * GIVEN Una lista no vacía
     * WHEN Se añade un elemento en la última posición
     * THEN Se añade correctamente
     */
	@Test
	public void filledListLastIndex() {
		
		list.add(0,  "test");
		list.add(1,  "test2");
		list.add(2,  "test3");
		list.add(3,  "test4");
		list.add(list.size(),  "test5");
		
		assertEquals(list.size()-1, list.indexOf("test5"));
		assertEquals(2, list.indexOf("test3"));
	}
	
	/**
     * GIVEN Una lista no vacía
     * WHEN Se añade un elemento después de la última posición
     * THEN Se añade correctamente
     */
	@Test
	public void filledListOverLimitIndex() {
		
		list.add(0,   "test");
		list.add(1,   "test2");
		list.add(2,   "test3");
		list.add(3,   "test4");
		list.add(4,   "test5");
		
		assertEquals(4 , list.indexOf("test5"));
		assertEquals(2, list.indexOf("test3"));
	}
	
	 /**
     * GIVEN Una lista vacía
     * WHEN Se intenta añadir un elemento en un índice negativo
     * THEN Salta IndexOutOfBoundsException
     */
	@Test 
	(expected = IndexOutOfBoundsException.class)
	public void emptyListNegativeIndex() {
		
		list.add(-1,   "test");
		
	}
	
	 /**
     * GIVEN Una lista vacía
     * WHEN Se intenta añadir un elemento en una posición mayor que size
     * THEN Salta IndexOutOfBoundsException
     */
	@Test 
	(expected = IndexOutOfBoundsException.class)
	public void emptyListIndexOverLimit() {
		
		list.add(list.size() + 1,  "test");
		
	}
	
	/**
     * GIVEN Una lista vacía
     * WHEN Se intenta añadir un elemento null
     * THEN Salta IllegalArgumentException
     */
	@Test 
	(expected = IllegalArgumentException.class)
	public void emptyListNullParameter() {
		
		list.add(0, null);
		
	}
	
}
