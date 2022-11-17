package saulv.collections.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

import saulv.collections.Util;
import saulv.util.checks.StateChecks;

/** 
 * @author Saúl Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class AbstractQueue<E> implements Queue<E> {
	
	protected List<E> list;

	/**
	 * Añade un elemento dado al final de la cola 
	 * @param element, de tipo Object 
	 * @return 
	 */
	@Override
	public boolean add(Object element) {
		return list.add(Util.castToE(element));		
	}

	/**
	 * Elimina el primer elemento de la cola
	 * @return el elemento eliminado, de tipo T 
	 */
	@Override
	public E remove() {
		StateChecks.isFalse(isEmpty(), new NoSuchElementException("The queue is empty"));
		return list.remove(0);
	}
	
	@Override
	public E poll() {
		if(isEmpty()) return null;
		return list.remove(0);
	}

	@Override
	public E element() {
		StateChecks.isFalse(isEmpty(), new NoSuchElementException("The queue is empty"));
		return list.get(0);
	}
	
	@Override
	public E peek() {
		if(isEmpty()) return null;
		return list.get(0);
	}
	
	/**
	 * Devuelve true si la lista está vacía
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Devuelve el tamaño de la cola
	 * @return el tamaño, de tipo int
	 */
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

	
	
	
}
