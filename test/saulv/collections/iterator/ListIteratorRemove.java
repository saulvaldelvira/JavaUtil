package saulv.collections.iterator;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import saulv.collections.list.List;
/** 
 * @author Saúl Valdelvira Iglesias
 * @version 28/03/2021
 */
public class ListIteratorRemove {

	protected List<String> list;
	protected Iterator<String> iterator;
	
	/*
	 * Casos 
	 * 1-Lista vacia->Lanza una illegalStateException
	 * 2-Lista con un elemento->Lanza una illegalStateException
	 * 3-Lista con varios elementos, en una posicion distinta a la primera 
	 */

//	1-Lista vacia->Lanza una illegalStateException
	/**
	 * GIVEN un iterador de una lista vacia 
	 * WHEN se llama al metodo remove 
	 * THEN Lanza una illegalStateException
	 */
	@Test 
	(expected= IllegalStateException.class)
	public void emptyTest() {
		iterator = list.iterator();
		iterator.remove();
	}
	
//	2-Lista con un elemento->Lanza una illegalStateException
	/**
	 * GIVEN un iterador de una lista con un elemento  
	 * WHEN se llama al metodo remove 
	 * THEN Lanza una illegalStateException
	 */
	@Test 
	(expected= IllegalStateException.class)
	public void onlyOneElementTest() {
		list.add("hola");
		iterator = list.iterator();
		iterator.remove();
	}
	
//	3-Lista con varios elementos, en una posicion distinta a la primera 
	/**
	 * GIVEN un iterador de una lista con varios elementos  
	 * WHEN se llama al metodo remove, estando en una posicion distinta de la 0
	 * THEN elimina el objeto y disminuye el tamaño 
	 */
	@Test 
	public void variousElementsTest() {
		list.add("hola");
		list.add("buenas");
		iterator = list.iterator();
		iterator.next();
		iterator.remove();
		assertEquals(1, list.size());
		assertEquals("buenas", iterator.next());
	}
	
}
