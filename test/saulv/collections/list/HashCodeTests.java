package saulv.collections.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import saulv.setting.Settings;

public class HashCodeTests {
	
	private List<String> list;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.listFactory.newList();
	}

	/**
	 * GIVEN dada una lista vac?a
	 * WHEN llamamos al hasCode()
	 * THEN devuelve 1
	 */
	@Test
	public void hashCodeEmptyList()
	{
		assertEquals(1, list.hashCode());
	}
	
	/**
	 * GIVEN dada una no vac?a
	 * WHEN llamamos al hashCode()
	 * THEN devuelve el hashCode calculado
	 */
	@Test
	public void hashCodeFullListt()
	{
		list.add(0,"string1");
		list.add(1,"string2");
		list.add(2,"string3");
		list.add(1,"string");
		int hashCode = 1;
		
		for (int i = 0; i < list.size(); i++)
		{
			hashCode = (hashCode * 31) + list.get(i).hashCode();
		}
		
		assertEquals(hashCode, list.hashCode());
	}
	
	/**
	 * GIVEN dada una no vac?a
	 * WHEN llamamos al hasCode()
	 * THEN devuelve el hashCode calculado
	 */
	@Test
	public void hashCode2FullLists()
	{
		list.add(0,"string1");
		list.add(1,"string2");
		list.add(2,"string3");
		list.add(1,"string");
		List<String> secondList = list;
		int hashCode = 1;
		int secondHashCode = 1;
		
		for (int i = 0; i < list.size(); i++)
		{
			hashCode = (hashCode * 31) + list.get(i).hashCode();
			secondHashCode = (secondHashCode * 31) + secondList.get(i).hashCode();
		}
		
		assertTrue(hashCode == secondHashCode);
	}

	
	/**
     * GIVEN Dada dos listas iguales de diferente tipo
     * WHEN llamamos al hashCode()
     * THEN Devuelve el mismo hashCode()
     */
    @Test
    public void hashCodeDifferentTypesLists() {
        @SuppressWarnings("unchecked")
		List<String> list2 = Settings.listFactory.newList();
        list.add(0, "A");
        list.add(0, "B");
        list.add(0, "C");

        list2.add(0, "A");
        list2.add(0, "B");
        list2.add(0, "C");

        assertEquals(list.hashCode(), list2.hashCode());
    }
    /**
     * GIVEN Dada dos listas con los mismos elementos en posiciones diferentes
     * WHEN llamamos al hashCode()
     * THEN Los hashCode() son diferentes
     */
    @Test
    public void hashCodeDifferentOrderLists() {
        @SuppressWarnings("unchecked")
		List<String> list2 = Settings.listFactory.newList();
        list.add(0, "A");
        list.add(0, "B");
        list.add(0, "C");

        list2.add(0, "B");
        list2.add(0, "C");
        list2.add(0, "A");

        assertNotEquals(list.hashCode(), list2.hashCode());
    }
}
