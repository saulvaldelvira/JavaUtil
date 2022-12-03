package saulv.collections.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;

public class AddLastTests {
	
	private List<Object> list;
	private Object o1;
	private Object o2;
	private Object elementToAdd;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.listFactory.newList();
		o1=new Object();
		o2=new Object();
		elementToAdd= new Object();
	}

	/*
	 * Escenarios
	 * positivos
	 * 1- Add en una lista vacía añade el elemento en la primera posición y devuelve true
	 * 2- Add en una lista con varios elementos, añade el elemento en la última posición y devuelve true
	 * 3- Se puede añadir un elemento repetido
	 * negativos 
	 * 4- Intentar añadir un null, se lanza IllegalArgumentException
	 */
	
//	1- Add en una lista vacía añade el elemento en la primera posición y devuelve true
	/**
	 * GIVEN una lista vacía
	 * WHEN se llama al metodo add(Object element)
	 * THEN añade el elemento a la primera posicion y devuelve true 
	 */
	@Test
	public void emptyTest() {
		assertTrue(list.add(  elementToAdd));
		assertEquals(elementToAdd, list.get(0));
	}

//	2- Add en una lista con varios elementos, añade el elemento en la última posición y devuelve true
	/**
	 * GIVEN una lista con varios elementos
	 * WHEN se llama al metodo add(Object element)
	 * THEN añade el elemento a la ultima posicion y devuelve true 
	 */
	@Test
	public void listWithElementsTest() {
		list.add(  o1);
		list.add(  o2);
		assertTrue(list.add(  elementToAdd));
		assertEquals(elementToAdd, list.get(2));
	}
	
//	3- Se puede añadir un elemento repetido
	/**
	 * GIVEN una lista con varios elementos
	 * WHEN se llama al metodo add(Object element) con un elemento ya existente en la lista
	 * THEN añade el elemento a la ultima posicion y devuelve true 
	 */
	@Test
	public void addRepeatedElementTest() {
		list.add(  o1);
		list.add(  o2);
		assertTrue(list.add(  o1));
		assertEquals(o1, list.get(2));
	}
	
	/**
	 * GIVEN una lista con varios elementos
	 * WHEN se llama al metodo add(null) 
	 * THEN lanza un IllegalArgumentException
	 */
	@Test
	(expected= NullPointerException.class)
	public void addNullElementTest() {
		list.add(null);
	}
}
