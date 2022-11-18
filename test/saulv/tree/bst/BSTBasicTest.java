package saulv.tree.bst;

import static org.junit.Assert.*;

import org.junit.Test;



public class BSTBasicTest {

	@Test
	public void testAddTostring() {
		BSTree<Character> a = new BSTree<Character>();
		a.add('b');
		assertEquals("b--", a.toString());
		a.add('a');
		assertEquals("ba---", a.toString());
		a.add('d');
		assertEquals("ba--d--", a.toString());
		a.add('c');
		assertEquals("ba--dc---", a.toString());
		a.add('g');
		assertEquals("ba--dc--g--", a.toString());
		a.add('i');
		assertEquals("ba--dc--g-i--", a.toString());
		a.add('h');
		assertEquals("ba--dc--g-ih---", a.toString());
 
		try {
			a.add(null);
			fail();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		try {
			a.add('h');
			fail();
		}catch(saulv.tree.exception.RepeatedElementException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddSearch() {
		BSTree<Character> a = new BSTree<Character>();
		a.add('b');
		a.add('a');
		a.add('d');
		a.add('c');
		a.add('g');
		a.add('i');
		a.add('h');
		assertEquals(true, a.contains('i'));
		assertEquals(false, a.contains('f'));
		
		try {
			a.contains(null);
			fail();
		}catch (NullPointerException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testGetMax() {
		BSTree<Character> a = new BSTree<Character>();
		
		a.add('b');
		a.add('a');
		a.add('d');
		a.add('c');
		a.add('g');
		a.add('i');
		a.add('h');
		assertEquals('i', (char) a.getMax(a.getRoot()));

	}
}
