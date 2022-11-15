package util.collections.iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import util.collections.List;

/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 28/03/2021
 */
public class ListIteratorHasNextTest<T> {
	
	protected List<String> list;
	protected Iterator<String> iterator;

	
	/*
	 *casos
	 *1-Lista vacia, llamo a hasNext->devuelve false
	 *2-lista con un elemento llamo a hasNext->devuelve false
	 *3-Lista con varios elementos llamo a hasNext->devuelve true
	 */
	
	
//	1-Lista vacia, llamo a hasNext->devuelve false
	/**
	 * GIVEN un iterador de una lista vacía
	 * WHEN se llama al método hasNext()
	 * THEN devuelve false
	 */
	@Test
	public void EmptyList() {
		iterator = list.iterator();
		assertFalse(iterator.hasNext());
	}

//	2-lista con un elemento llamo a hasNext->devuelve false
	/**
	 * GIVEN un iterador de una lista con un solo elemento
	 * WHEN se llama al método hasNext()
	 * THEN devuelve true
	 */
	@Test
	public void oneElement() {
		list.add("hahaha");
		iterator = list.iterator();
		assertTrue(iterator.hasNext());
	}
	
//	3-Lista con varios elementos llamo a hasNext->devuelve true
	/**
	 * GIVEN un iterador de una lista con varios elementos 
	 * WHEN se llama al método hasNext()
	 * THEN devuelve true 
	 */
	@Test
	public void variousElements() {
		list.add("hahaha");
		list.add("hola");
		iterator = list.iterator();
		assertTrue(iterator.hasNext());
	}
}