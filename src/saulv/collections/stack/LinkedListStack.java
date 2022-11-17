/**
 * 
 */
package saulv.collections.stack;

import saulv.collections.list.LinkedList;

/** 
 * @author Saúl Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class LinkedListStack<T> extends AbstractStack<T>{

	private static final long serialVersionUID = 1L;

	public LinkedListStack() {
		list = new LinkedList<T>();
	}
}
