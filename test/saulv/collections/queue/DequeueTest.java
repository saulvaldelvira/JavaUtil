/**
 * 
 */
package saulv.collections.queue;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import saulv.collections.setting.Settings;



/**
 * @author Sa�l Valdelvira Iglesias
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
	 * 1-Lista vac�a->Lanza IndexOutOfBoundsException
	 * 2-Lista con un elemento->Lo elimina y la lista queda vac�a
	 * 3-Lista con varios elementos->Lo elimina y reduce en uno el tama�o 
	 */
	
	/**
	 * GIVEN una cola vac�a
	 * WHEN se llama al m�todo dequeue
	 * THEN lanza una IndexOutOfBoundsException
	 */
	@Test
	(expected= NoSuchElementException.class)
	public void emptyTest() {
		queue.remove();
	}
	
	/**
	 * GIVEN una cola con un solo elemento 
	 * WHEN se llama al m�todo remove
	 * THEN lo elimina y la lista queda vac�a
	 */
	@Test
	public void oneElementTest() {
		queue.add("Hola");
		queue.remove();
		assertEquals(0, queue.size());
	}

	/**
	 * GIVEN una cola con un varios elementos
	 * WHEN se llama al m�todo remove
	 * THEN elimina el primer elemento y reduce en uno el tama�o 
	 */
	@Test
	public void multipleElementTest() {
		queue.add("abra");
		queue.add("kadabra");
		queue.remove();
		assertEquals(1, queue.size());
		assertEquals("kadabra", queue.peek());
	}
	
}
