package saulv.collections.queue;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;


/**
 * @author Sa?l Valdelvira Iglesias
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
	 * 1-Cola vac?a->Lanza una IllegalStateException
	 * 2-Cola con un elemento->Devuelve ese elemento
	 * 3-Cola con varios elementos->Devuelve el primero de la cola
	 */
	
	/**
	 * GIVEN una cola vac?a 
	 * WHEN se llama al m?todo peak()
	 * THEN lanza una IllegalStateException
	 */
	@Test
	public void emptyTest() {
		queue.peek();
	}
	
	/**
	 * GIVEN una cola con un solo elemento 
	 * WHEN se llama al m?todo peak()
	 * THEN devuelve ese elemento 
	 */
	@Test
	public void oneElementTest() {
		queue.add("Sa?l");
		assertEquals("Sa?l", queue.peek());
	}
	
	/**
	 * GIVEN una cola con varios elementos
	 * WHEN se llama al m?todo peak()
	 * THEN devuelve el primer elemento de la cola
	 */
	@Test
	public void variousElementsTest() {
		queue.add("Sa?l");
		queue.add("Helado");
		queue.add("azufre$");
		
		assertEquals("Sa?l", queue.peek());
	}

}
