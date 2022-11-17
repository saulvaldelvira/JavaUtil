package saulv.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import saulv.collections.setting.Settings;


/**
 * @author Saúl Valdelvira Iglesias
 * @version 29/03/2021
 */
public class SizeTest {

AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * casos
	 * 1-Cola vacía->Devuelve 0
	 * 2-Cola con elementos->Devuelve el numero de elementos
	 */
	
	/**
	 * GIVEN una cola vacía
	 * WHEN se llama al método size()
	 * THEN devuelve 0
	 */
	@Test
	public void emptyTest() {
		assertEquals(0, queue.size());
	}

	/**
	 * GIVEN una cola con elementos
	 * WHEN se llama al método size()
	 * THEN devuelve el número de elementos
	 */
	@Test
	public void elementsTest() {
		queue.add("hey");
		queue.add("jeje");
		assertEquals(2, queue.size());
	}
	
}
