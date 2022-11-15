package saulv.util.collections.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import saulv.util.collections.setting.Settings;
/**
 * @author Saúl Valdelvira Iglesias
 * @version 29/03/2021
 */
public class PopTest {

AbstractStack<String> stack;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		stack=Settings.stackFactory.newStack();
	}
	
	/*
	 * Casos 
	 * 1-Pila vacía->Lanza IndexOutOfBoundsException
	 * 2-Pila con un elemento->Lo elimina y la lista queda vacía
	 * 3-Pila con varios elementos->Lo elimina y reduce en uno el tamaño 
	 */
	
	/**
	 * GIVEN una pila vacía
	 * WHEN se llama al método dequeue
	 * THEN lanza una IndexOutOfBoundsException
	 */
	@Test
	(expected= IndexOutOfBoundsException.class)
	public void emptyTest() {
		stack.pop();
	}

	/**
	 * GIVEN una pila con un elemento
	 * WHEN se llama al método dequeue
	 * THEN elimina ese elemento y reduce el tamaño en uno 
	 */
	@Test
	public void singleElementTest() {
		stack.push("Eliminar");
		
		assertEquals("Eliminar", stack.pop());
		assertEquals(0, stack.size());
	}
	
	/**
	 * GIVEN una pila con varios elementos
	 * WHEN se llama al método dequeue
	 * THEN elimina el ultimo elemento añadido y reduce en uno el tamaño
	 */
	@Test
	public void multipleElementsTest() {
		stack.push("Eliminar");
		stack.push("más");
		stack.push("tarde");
		
		assertEquals("tarde", stack.pop());
		assertEquals(2, stack.size());
	}
	
}
