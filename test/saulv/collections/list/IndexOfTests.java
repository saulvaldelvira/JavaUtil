package saulv.collections.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;

public class IndexOfTests {
	
	private List<String> list;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.listFactory.newList();
	}

	/**
	 * ESCENARIOS:
	 * 
	 * El index de un elemento que no existe es -1
	 * El index de null es -1
	 * El index de cada elemento en la lista es el correcto
	 * En una lista con elementos repetidos, el indexOf de un elemento devuelve la posición de la primera aparición
	 */
	
	/**
	 * GIVEN:El index de un elemento que no existe es -1
	 * WHEN: indexOf()
	 * THEN: devuelve -1
	 */
	@Test
	public void indexOfNoElementtest() {
		list.add("A");
		list.add("B");
			
		assertEquals(-1, list.indexOf("C"));

	}
	
	/**
	 * GIVEN:El index de null es -1
	 * WHEN: indexOf()
	 * THEN: devuelve -1
	 */
	@Test
	public void indexOfNullObjecttest() {	
		try {
			list.indexOf(null);
			fail();
		}catch(NullPointerException e) {
			
		}
	}
	
	/**
	 * GIVEN:El index de cada elemento en la lista es el correcto
	 * WHEN: indexOf()
	 * THEN: devuelve la posición de cada elemento
	 */
	@Test
	public void indexOfCorrecttest() {
		list.add("A");
		list.add("B");
			
		assertEquals(0, list.indexOf("A"));
		assertEquals(1, list.indexOf("B"));
	}
	
	/**
	 * GIVEN:En una lista con elementos repetidos, el indexOf de un elemento devuelve la posición de la primera aparición
	 * WHEN: indexOf()
	 * THEN: devuelve la primera posición del elemento repetido
	 */
	@Test
	public void indexOfRepetedtest() {
		list.add("A");
		list.add("B");
		list.add("A");
			
		assertEquals(0, list.indexOf("A"));
	}

}
