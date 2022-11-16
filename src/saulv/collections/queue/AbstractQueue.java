package saulv.collections.queue;

import saulv.collections.list.List;
import saulv.util.checks.StateChecks;

/** 
 * @author Saúl Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class AbstractQueue<T> implements Queue<T> {
	
	protected List<T> list;

	/**
	 * Añade un elemento dado al final de la cola 
	 * @param element, de tipo Object 
	 */
	@Override
	public void enqueue(T element) {
		list.add(element);		
	}

	/**
	 * Elimina el primer elemento de la cola
	 * @return el elemento eliminado, de tipo Object 
	 */
	@Override
	public Object dequeue() {
		return list.remove(0);
	}

	/**
	 * Devuelve el primer elemento en la cola
	 * @return el elemento, de tipo Object 
	 */
	@Override
	public Object peek() {
		StateChecks.isTrue(!isEmpty());
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

	
	
	
}
