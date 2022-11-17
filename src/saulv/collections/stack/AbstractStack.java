/**
 * 
 */
package saulv.collections.stack;

import saulv.util.checks.StateChecks;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/** 
 * @author Saúl Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class AbstractStack<E> extends Stack<E>{

	private static final long serialVersionUID = 1L;
	protected List<E> list;
	
	/**
	 * Añade un elemento dado en la parte superior de la pila 
	 * @param element, de tipo Object 
	 * @return 
	 */
	public E push(E element) {
		list.add(element);
		return element;
	}
	
	/**
	 * Elimina y devuelve el elemento en la parte superior de la pila
	 * @return el objeto, de tipo Object  
	 */
	public E pop() {
		return list.remove(list.size()-1);
	}
	
	/**
	 * 	Devuelve el elemento en la parte superior de la pila
	 * @return el objeto, de tipo Object  
	 */
	public E peek() {
		StateChecks.isFalse(isEmpty(), new EmptyStackException());
		return list.get(list.size()-1);
	}
	
	/**
	 * Indica si la pila etsa vacia o no 
	 * @return true o false, de tipo boolean 
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Devuelve el tamaño de la pila 
	 * @return el tamaño, de tipo int 
	 */
	public int size() {
		return list.size();
	}
}
