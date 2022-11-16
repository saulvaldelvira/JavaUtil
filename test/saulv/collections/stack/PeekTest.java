package saulv.collections.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import saulv.collections.setting.Settings;
import saulv.collections.stack.AbstractStack;
/**
 * @author Saúl Valdelvira Iglesias
 * @version 29/03/2021
 */
public class PeekTest {

AbstractStack<String> stack;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		stack=Settings.stackFactory.newStack();
	}
	
	/*
	 * casos
	 * 1-Cola vacía->Lanza una IllegalStateException
	 * 2-Cola con un elemento->Devuelve ese elemento
	 * 3-Cola con varios elementos->Devuelve el ultimo elemento agregado a la cola
	 */
	
	/**
	 * GIVEN una pila vacía 
	 * WHEN se llama al método peak()
	 * THEN lanza una IllegalStateException
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyTest() {
		stack.peek();
	}

	/**
	 * GIVEN una pila con un elemento 
	 * WHEN se llama al método peak()
	 * THEN devuelve ese mismo elemento
	 */
	@Test
	public void singleElementTest() {
		stack.push("Elemento tipo String");
		assertEquals("Elemento tipo String",stack.peek());
	}
	
	/**
	 * GIVEN una pila con varios elementos
	 * WHEN se llama al método peak()
	 * THEN devuelve el ultimo elemento añadido 
	 */
	@Test
	public void multipleElementsTest() {
		stack.push("Elemento tipo String");
		stack.push("Elemento  2, tipo String");
		
		assertEquals("Elemento  2, tipo String",stack.peek());
	}
	
}
