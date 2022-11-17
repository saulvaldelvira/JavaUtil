/**
 * 
 */
package saulv.collections.stack;

import saulv.collections.list.ArrayList;

/** 
 * @author Saúl Valdelvira Iglesias
 * @param <T>
 * @verison 28/03/2021
 */
public class ArrayListStack<T> extends AbstractStack<T>{

	private static final long serialVersionUID = 1L;

	public ArrayListStack() {
		list = new ArrayList<T>();
	}
}
