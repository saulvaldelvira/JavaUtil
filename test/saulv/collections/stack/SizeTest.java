package saulv.collections.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;
/**
 * @author Saúl Valdelvira Iglesias
 * @version 29/03/2021
 */
public class SizeTest {
	
AbstractStack<String> stack;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		stack=Settings.stackFactory.newStack();
	}
	
	/*
	 * casos
	 * 1-Pila vacía->Devuelve 0
	 * 2-Pila con elementos->Devuelve el numero de elementos
	 */
	
	/**
	 * GIVEN una pila vacía
	 * WHEN se llama al método size()
	 * THEN devuelve 0
	 */
	@Test
	public void emptyTest() {
		assertEquals(0, stack.size());
	}
	
	/**
	 * GIVEN una pila con elementos
	 * WHEN se llama al método size()
	 * THEN devuelve el número de elementos
	 */
	@Test
	public void withElementsTest() {
		stack.push("Probando");
		stack.push("la");
		stack.push("pila");
		
		assertEquals(3, stack.size());
	}

}
