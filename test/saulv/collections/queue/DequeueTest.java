/**
 * 
 */
package saulv.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import saulv.collections.setting.Settings;



/**
 * @author Saúl Valdelvira Iglesias
 * @version 29/03/2021
 */
public class DequeueTest {

	AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * Casos 
	 * 1-Lista vacía->Lanza IndexOutOfBoundsException
	 * 2-Lista con un elemento->Lo elimina y la lista queda vacía
	 * 3-Lista con varios elementos->Lo elimina y reduce en uno el tamaño 
	 */
	
	/**
	 * GIVEN una cola vacía
	 * WHEN se llama al método dequeue
	 * THEN lanza una IndexOutOfBoundsException
	 */
	@Test
	(expected= IndexOutOfBoundsException.class)
	public void emptyTest() {
		queue.dequeue();
	}
	
	/**
	 * GIVEN una cola con un solo elemento 
	 * WHEN se llama al método dequeue
	 * THEN lo elimina y la lista queda vacía
	 */
	@Test
	public void oneElementTest() {
		queue.enqueue("Hola");
		queue.dequeue();
		assertEquals(0, queue.size());
	}

	/**
	 * GIVEN una cola con un varios elementos
	 * WHEN se llama al método dequeue
	 * THEN elimina el primer elemento y reduce en uno el tamaño 
	 */
	@Test
	public void multipleElementTest() {
		queue.enqueue("abra");
		queue.enqueue("kadabra");
		queue.dequeue();
		assertEquals(1, queue.size());
		assertEquals("kadabra", queue.peek());
	}
	
}
