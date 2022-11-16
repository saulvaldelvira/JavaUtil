/**
 * 
 */
package saulv.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import saulv.collections.queue.AbstractQueue;
import saulv.collections.setting.Settings;

/**
 * @author Saúl Valdelvira Iglesias
 * @version 29/03/2021
 */
public class EnqueueTest<T> {

	AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * Casos 
	 * 1-Lista vacia->Añade el elemento 
	 * 2-Lista con elementos->Añade el elemento 
	 */
	
	/**
	 * GIVEN una cola vacia
	 * WHEN se mete uno nuevo 
	 * THEN el tamaño aumenta en 1
	 */
	@Test
	public void emptyListTest() {
		queue.enqueue("hola");
		assertEquals(1, queue.size());
		assertEquals("hola", queue.peek());
	}
	
	/**
	 * GIVEN una cola con elementos
	 * WHEN se mete uno nuevo 
	 * THEN mete el elementos en la ultima posicion de la cola
	 */
	@Test
	public void elementsInListTest() {
		queue.enqueue("hola");
		queue.enqueue("que");
		queue.enqueue("tal");
		
		assertEquals(3, queue.size());
		assertEquals("hola", queue.peek());
		queue.dequeue();
		assertEquals("que", queue.peek());
		queue.dequeue();
		assertEquals("tal", queue.peek());
	}

}
