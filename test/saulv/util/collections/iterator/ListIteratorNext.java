/**
 * 
 */
package saulv.util.collections.iterator;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import saulv.util.collections.List;


/** 
 * @author Saúl Valdelvira Iglesias
 * @version 28/03/2021
 */
public class ListIteratorNext {

	protected List<String> list;
	protected Iterator<String> iterator;
	
	/*
	 * casos
	 * 1-Lista vacía->Lanza una NoSuchElementException
	 * 2-Lista con un elemento, devuelve ese elemento
	 * 3-Lista con elementos, devuelve el siguiente 
	 * 4-Lista con varios elementos, que está en el final->Lanza una NoSuchElementException
	 */

//	1-Lista vacía->Lanza una NoSuchElementException
	/**
	 * GIVEN un iterador de una lista vacía
	 * WHEN se llama al metodo next
	 * THEN lanza una NoSuchElementException
	 */
	@Test
	(expected= NoSuchElementException.class)
	public void emptyList() {
		iterator = list.iterator();
		iterator.next();
	}
	
//	 2-Lista con un elemento, devuelve ese elemento
	/**
	 * GIVEN un iterador de una lista con un elemento
	 * WHEN se llama al metodo next
	 * THEN devuelve ese elemento 
	 */
	@Test
	public void oneElement() {
		list.add("hola");
		iterator = list.iterator();
		assertEquals("hola", iterator.next());
	}
	
//	3-Lista con elementos, devuelve el siguiente 
	/**
	 * GIVEN un iterador de una lista con varios elementos
	 * WHEN se llama al metodo next
	 * THEN devuelve el siguiente elemento 
	 */
	@Test
	public void variousElements() {
		list.add("hola");
		list.add("caracola");
		iterator = list.iterator();
		assertEquals("hola", iterator.next());
		assertEquals("caracola", iterator.next());
	}
	
//	4-Lista con varios elementos, que está en el final->Lanza una NoSuchElementException
	/**
	 * GIVEN un iterador de una lista con varios elementos
	 * WHEN se llama al metodo next
	 * THEN devuelve el siguiente elemento 
	 */
	@Test
	(expected= NoSuchElementException.class)
	public void finalElement() {
		list.add("hola");
		list.add("caracola");
		iterator = list.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
	}
	
}
