package saulv.collections.list;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;

public class SizeTests {
	
	private List<String> list;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.listFactory.newList();
	}

	/**
	* GIVEN Una lista vac?a
	* WHEN Llamamos al size()
	* THEN Devuelve 0
	*/
	@Test
	public void emptyListTest() {
	assertEquals(0, list.size());
	}

	/**
	* GIVEN Una lista con un elemento
	* WHEN Llamamos al size()
	* THEN Devuelve 1
	*/
	@Test
	public void listWithOneElementTest() {
	list.add(0,"A");
	assertEquals(1, list.size());

	}
	/**
	* GIVEN Una lista con un elemento
	* WHEN Llamamos al size()
	* THEN Devuelve 1
	*/
	@Test
	public void listWithElementsTest() {
	list.add(0,"A");
	list.add(0,"B");
	list.add(0, "C");
	assertEquals(3, list.size());

	}
	
	/**
	 * GIVEN una lista
	 * WHEN llamamos a size despues de haber a?adido un objeto
	 * THEN devuelve el tama?o +1
	 */
	@Test
	public void sizeIncrementsOnce() {
		int size = list.size();
		list.add(0, "nuevo");
		assertEquals(size+1, list.size());
	}

	/**
	 * GIVEN una lista
	 * WHEN llamamos a size despues de haber removido un obbjeto
	 * THEN devuelve el tama?o -1
	 */
	@Test
	public void sizeDecrementsOnce() {
		list.add(0, "nuevo");
		int size = list.size();
		list.remove(0);
		assertEquals(size-1, list.size());
	}
}
