package util.collections.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.collections.setting.Settings;
/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 29/03/2021
 */
public class IsEmptyTest {

AbstractStack<String> stack;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		stack=Settings.stackFactory.newStack();
	}
	
	/*
	 * casos 
	 * 1-Pila vacía. Devuelve true
	 * 2-Pila con elementos. Devuelve false
	 */
	
	/**
	 * GIVEN una pila vacia 
	 * WHEN se llama al metodo isEmpty()
	 * THEN devuelve true
	 */
	@Test
	public void emptyTest() {
		assertTrue(stack.isEmpty());
	}

	/**
	 * GIVEN una pila con al menos un elemento  
	 * WHEN se llama al metodo isEmpty()
	 * THEN devuelve false
	 */
	@Test
	public void notEmptyTest() {
		stack.push("probando");
		assertFalse(stack.isEmpty());
	}
	
}
