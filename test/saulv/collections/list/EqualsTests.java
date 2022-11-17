package saulv.collections.list;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import saulv.collections.setting.Settings;
public class EqualsTests {
	
	private List<String> l1;
	private List<String> l2;

	/*
	 * Casos:
	 * 1 Dos listas vacías de tipo ArrayList son iguales
	 * 2 Dos lisa vacías de tipo LinkedList son iguales
	 * 3 Dos listas vacías de ambos tipos son iguales
	 * 4 Dos listas de tipo ArrayList con los mismos elementos en la misma posición son iguales
	 * 5 Dos listas de tipo LinkedList con los mismos elementos en la misma posición son iguales
	 * 6 Dos listas de ambos tipos con los mismsos elementos en la misa posición son iguales
	 * 7 Dos listas de tipo ArrayList con los mismos elementos en diferente posición no son iguales
	 * 8 Dos listas de tipo LinkedList con los mismos elementos endiferentes posiciones no sn iguales
	 * 9 Dos listas de ambos tipos con los mismos elementos en diferentes posiciones no son iguales
	 * 10 Dos listas de tipo ArrayList con diferentes elementos no son iguales
	 * 11 Dos listas de tipo LinkedList con diferentes elementos no son iguales
	 * 12 Dos listas de ambos tipos con diferentes elementos no son iguales
	 */
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		l1 = Settings.factory.newList();
		l2 = Settings.factory.newList();
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas vacías de tipo ArrayList
	 * THEN son iguales
	 */
	@Test
	public void twoEmptyArrayLists() {
		l1 = new ArrayList<String>();
		l2 = new ArrayList<String>();
		assertEquals(l1,l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos lisa vacías de tipo LinkedList son iguales
	 * THEN son iguales
	 */
	@Test
	public void twoEmptyLinkedLists() {
		assertEquals(l1,l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas vacías de ambos tipos
	 * THEN son iguales
	 */
	@Test
	public void twoEmptyDiferentLists() {
		l1 = new LinkedList<String>();
		l2 = new ArrayList<String>();
		assertTrue(l1.equals(l2));
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo ArrayList con los mismos elementos en la misma posición
	 * THEN son iguales
	 */
	@Test
	public void twoArrayListsSameElements() {
		l1 = new ArrayList<String>();
		l2 = new ArrayList<String>();
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		l1.add(0, x1);
		l2.add(0, x1);
		l1.add(1, x2);
		l2.add(1, x2);
		assertEquals(l1, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo LinkedList con los mismos elementos en la misma posición
	 * THEN son iguales
	 */
	@Test
	public void twolinkedListsSameElements() {
		l1 = new LinkedList<String>();
		l2 = new LinkedList<String>();
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		l1.add(0, x1);
		l2.add(0, x1);
		l1.add(1, x2);
		l2.add(1, x2);
		assertEquals(l1, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de ambos tipos con los mismsos elementos en la misa posición
	 * THEN son iguales
	 */
	@Test
	public void twoListsSameElements() {
		l1 = new LinkedList<String>();
		l2 = new ArrayList<String>();
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		l1.add(0, x1);
		l2.add(0, x1);
		l1.add(1, x2);
		l2.add(1, x2);
		assertTrue(l1.equals(l2));
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo ArrayList con los mismos elementos en diferente posición
	 * THEN no son iguales
	 */
	@Test
	public void twoArrayListsDiferentPositions() {
		l1 = new ArrayList<String>();
		l2 = new ArrayList<String>();
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		l1.add(0, x1);
		l2.add(0, x1);
		l1.add(0, x2);
		l2.add(1, x2);
		
		assertNotEquals(l1, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo LinkedList con los mismos elementos endiferentes posiciones
	 * THEN no son iguales
	 */
	@Test
	public void twoLinkedListsDiferentPositions() {
		l1 = new LinkedList<String>();
		l2 = new LinkedList<String>();
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		l1.add(0, x1);
		l2.add(0, x1);
		l1.add(1, x2);
		l2.add(0, x2);
		assertNotEquals(l1, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de ambos tipos con los mismos elementos en diferentes posiciones
	 * THEN no son iguales
	 */
	@Test
	public void twoListsDiferentPositions() {
		l1 = new ArrayList<String>();
		l2 = new ArrayList<String>();
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		l1.add(0, x1);
		l2.add(0, x2);
		l1.add(1, x1);
		l2.add(1, x2);
		assertNotEquals(l1, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo ArrayList con diferentes elementos
	 * THEN no son iguales
	 */
	@Test
	public void twoArrayListsDiferentElements() {
		l1 = new ArrayList<String>();
		l2 = new ArrayList<String>();
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		l1.add(0, x1);
		l2.add(0, x2);
		l1.add(1, x1);
		l2.add(1, x2);
		assertNotEquals(l1, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo LinkedList con diferentes elementos
	 * THEN no son iguales
	 */
	@Test
	public void twoLinkedListsDiferentElements() {
		l1 = new LinkedList<String>();
		l2 = new LinkedList<String>();
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		l1.add(0, x1);
		l2.add(0, x2);
		l1.add(1, x1);
		l2.add(1, x2);
		assertNotEquals(l1, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de ambos tipos con diferentes elementos
	 * THEN no son iguales
	 */
	@Test
	public void twoListsDiferentElements() {
		l1 = new ArrayList<String>();
		l2 = new LinkedList<String>();
		String x1 = new String("Patata");
		String x2 = new String("Aceituna");
		l1.add(0, x1);
		l2.add(0, x2);
		l1.add(1, x1);
		l2.add(1, x2);
		assertNotEquals(l1, l2);
	}
	
}
