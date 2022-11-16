package saulv.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import saulv.collections.setting.Settings;


/**
 * @author Saúl Valdelvira Iglesias
 * @version 29/03/2021
 */
public class PeekTest {

AbstractQueue<String> queue;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		queue=Settings.queueFactory.newQueue();
	}
	
	/*
	 * casos
	 * 1-Cola vacía->Lanza una IllegalStateException
	 * 2-Cola con un elemento->Devuelve ese elemento
	 * 3-Cola con varios elementos->Devuelve el primero de la cola
	 */
	
	/**
	 * GIVEN una cola vacía 
	 * WHEN se llama al método peak()
	 * THEN lanza una IllegalStateException
	 */
	@Test
	(expected=IllegalStateException.class)
	public void emptyTest() {
		queue.peek();
	}
	
	/**
	 * GIVEN una cola con un solo elemento 
	 * WHEN se llama al método peak()
	 * THEN devuelve ese elemento 
	 */
	@Test
	public void oneElementTest() {
		queue.enqueue("Saúl");
		assertEquals("Saúl", queue.peek());
	}
	
	/**
	 * GIVEN una cola con varios elementos
	 * WHEN se llama al método peak()
	 * THEN devuelve el primer elemento de la cola
	 */
	@Test
	public void variousElementsTest() {
		queue.enqueue("Saúl");
		queue.enqueue("Helado");
		queue.enqueue("azufre$");
		
		assertEquals("Saúl", queue.peek());
	}

}
