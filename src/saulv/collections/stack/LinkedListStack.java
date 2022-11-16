/**
 * 
 */
package saulv.collections.stack;

import saulv.collections.LinkedList;

/** 
 * @author Saúl Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class LinkedListStack<T> extends AbstractStack<T>{

	public LinkedListStack() {
		list = new LinkedList<T>();
	}
}
