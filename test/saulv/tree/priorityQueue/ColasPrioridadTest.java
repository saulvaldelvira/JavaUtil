package saulv.tree.priorityQueue;

import static org.junit.Assert.*;

import org.junit.Test;

import saulv.tree.priorityQueue.BinaryHeapMin;

public class ColasPrioridadTest {

	@Test
	public void addTest() {
		BinaryHeapMin<Integer> heap = new BinaryHeapMin<Integer>(10);
		assertEquals(0, heap.add(12));
		assertEquals(0, heap.add(14));
		assertEquals(0, heap.add(15));
		assertEquals(0, heap.add(20));
		assertEquals(0, heap.add(16));
		assertEquals(0, heap.add(17));
		assertEquals(0, heap.add(19));
		assertEquals(0, heap.add(24));
		assertEquals(0, heap.add(18));
		assertEquals(0, heap.add(10));
		assertEquals("10\t12\t15\t18\t14\t17\t19\t24\t20\t16", heap.toString());
	}
	
	@Test
	public void removeTest() {
		BinaryHeapMin<Integer> heap = new BinaryHeapMin<Integer>(10);
		assertEquals(-2, heap.remove(4));
		heap.add(12);
		heap.add(14);
		heap.add(15);
		heap.add(20);
		heap.add(16);
		heap.add(17);
		heap.add(19);
		heap.add(24);
		heap.add(18);
		heap.add(10);
		assertEquals(-2, heap.remove(null));
		assertEquals(-1, heap.remove(13));
		assertEquals(0, heap.remove(18));
		assertEquals("10\t12\t15\t16\t14\t17\t19\t24\t20", heap.toString());
		assertEquals(0, heap.remove(10));	
		assertEquals("12\t14\t15\t16\t20\t17\t19\t24", heap.toString());
		assertEquals(0, heap.remove(12));	
		assertEquals("14\t16\t15\t24\t20\t17\t19", heap.toString());
		assertEquals(0, heap.remove(16));	
		assertEquals("14\t19\t15\t24\t20\t17", heap.toString());
		assertEquals(0, heap.remove(15));	
		assertEquals("14\t19\t17\t24\t20", heap.toString());
		assertEquals(0, heap.remove(20));	
		assertEquals("14\t19\t17\t24", heap.toString());
		assertEquals(0, heap.remove(14));	
		assertEquals("17\t19\t24", heap.toString());
		assertEquals(0, heap.remove(17));	
		assertEquals("19\t24", heap.toString());
		assertEquals(0, heap.remove(19));	
		assertEquals("24", heap.toString());
		assertEquals(0, heap.remove(24));	
		assertEquals("", heap.toString());
	}
	
	@Test
	public void sacarTest() {
		BinaryHeapMin<Integer> heap = new BinaryHeapMin<Integer>(10);
		assertEquals(null, heap.sacar());
		heap.add(12);
		heap.add(14);
		heap.add(15);
		heap.add(20);
		heap.add(16);
		heap.add(17);
		heap.add(19);
		heap.add(24);
		heap.add(18);
		heap.add(10);
		assertEquals(Integer.valueOf(10), heap.sacar());
		assertEquals("12\t14\t15\t18\t16\t17\t19\t24\t20", heap.toString());
		assertEquals(Integer.valueOf(12), heap.sacar());
		assertEquals("14\t16\t15\t18\t20\t17\t19\t24", heap.toString());
	}

	@Test
	public void clearTest() {
		BinaryHeapMin<Integer> heap = new BinaryHeapMin<Integer>(10);
		heap.add(12);
		heap.add(14);
		heap.add(15);
		heap.add(20);
		heap.add(16);
		heap.add(17);
		heap.add(19);
		heap.add(24);
		heap.add(18);
		heap.add(10);
		assertEquals("10\t12\t15\t18\t14\t17\t19\t24\t20\t16", heap.toString());
		heap.clear();
		assertEquals("", heap.toString());
	}
	
	@Test
	public void isEmptyTest() {
		BinaryHeapMin<Integer> heap = new BinaryHeapMin<Integer>(10);
		assertEquals(true, heap.isEmpty());
		heap.add(4);
		assertEquals(false, heap.isEmpty());
		heap.remove(4);
		assertEquals(true, heap.isEmpty());
	}
	
	@Test
	public void cambiarPrioridadTest() {
		BinaryHeapMin<Integer> heap = new BinaryHeapMin<Integer>(10);
		assertEquals(-2, heap.cambiarPrioridad(0, 12));
		heap.add(12);
		heap.add(14);
		heap.add(15);
		heap.add(20);
		heap.add(16);
		heap.add(17);
		heap.add(19);
		heap.add(24);
		heap.add(30);
		assertEquals(-2, heap.cambiarPrioridad(-8, 12));
		assertEquals(-2, heap.cambiarPrioridad(12, 1));
		assertEquals(-2, heap.cambiarPrioridad(2, null));
		assertEquals(0, heap.cambiarPrioridad(3, 5));
		assertEquals("5\t12\t15\t14\t16\t17\t19\t24\t30", heap.toString());
		assertEquals(0, heap.cambiarPrioridad(1, 21));
		assertEquals("5\t14\t15\t21\t16\t17\t19\t24\t30", heap.toString());
	}
}
