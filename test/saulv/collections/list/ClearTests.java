package saulv.collections.list;

import static org.junit.Assert.assertTrue;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;

public class ClearTests {
	
	private List<String> list;
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.listFactory.newList();
	}

	/**
	 * GIVEN: an empty list
	 * WHEN: clear() is invoked
	 * THEN: the list remains empty
	 */
	@Test
	public void test() {
		list.clear();
		
		assertTrue( list.size() == 0 );
	}
	
	/**
	 * GIVEN: a list with just one element
	 * WHEN: clear() is invoked
	 * THEN: the list is empty
	 */
	@Test
	public void testClearWithOne() {
		list.add(  "A" );
		
		list.clear();
		
		assertTrue( list.size() == 0 );
		assertTrue( list.contains(  "A" ) == false );
	}
	
	/**
	 * GIVEN: a list with several elements
	 * WHEN: clear() is invoked
	 * THEN: the list is empty
	 */
	@Test
	public void testClearWithSeveral() {
		list.add(  "A" );
		list.add(  "B" );
		list.add(  "C" );
		list.add(  "D" );

		list.clear();
		
		assertEquals(0, list.size());
		assertTrue( list.contains(  "A" ) == false );
	}

}
