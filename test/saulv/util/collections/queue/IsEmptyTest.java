package saulv.util.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import saulv.util.collections.setting.Settings;
/**
 * @author Saúl Valdelvira Iglesias
 * @version 29/03/2021
 */
public class IsEmptyTest {

AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * casos 
	 * 1-Cola vacía. Devuelve true
	 * 2-Cola con elementos. Devuelve false
	 */
	
	/**
	 * GIVEN una cola vacia 
	 * WHEN se llama al metodo isEmpty
	 * THEN devuelve true
	 */
	@Test
	public void emptyTest() {
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * GIVEN una cola con elementos 
	 * WHEN se llama al metodo isEmpty
	 * THEN devuelve false
	 */
	@Test
	public void queueWithElementsTest() {
		queue.enqueue("H");
		assertFalse(queue.isEmpty());
	}

}
