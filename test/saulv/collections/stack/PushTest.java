package saulv.collections.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import saulv.collections.setting.Settings;
/**
 * @author Saúl Valdelvira Iglesias
 * @version 29/03/2021
 */
public class PushTest {

AbstractStack<String> stack;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		stack=Settings.stackFactory.newStack();
	}
	
	/*
	 * Casos 
	 * 1-Pila vacia->Añade el elemento 
	 * 2-Pila con elementos->Añade el elemento al principio de la pila
	 */
	
	/**
	 * GIVEN una pila vacia
	 * WHEN se mete uno nuevo 
	 * THEN el tamaño aumenta en 1
	 */
	@Test
	public void emptyStackTest() {
		stack.push("hola");
		assertEquals(1, stack.size());
		assertEquals("hola", stack.peek());
	}

	/**
	 * GIVEN una pila con elemntos
	 * WHEN se mete uno nuevo 
	 * THEN el tamaño aumenta en 1 y se añade el elemento al principio de la pila
	 */
	@Test
	public void notEmptyStackTest() {
		stack.push("hola");
		stack.push("Que");
		stack.push("tal");
		
		assertEquals(3, stack.size());
		assertEquals("tal", stack.peek());
	}
	
}
