/**
 * 
 */
package saulv.util.collections.stack;

import saulv.util.collections.LinkedList;

/** 
 * @author Sa�l Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class LinkedListStack<T> extends AbstractStack<T>{

	public LinkedListStack() {
		list = new LinkedList<T>();
	}
}
