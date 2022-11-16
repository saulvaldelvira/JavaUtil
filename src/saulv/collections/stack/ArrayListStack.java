/**
 * 
 */
package saulv.collections.stack;

import saulv.collections.list.ArrayList;

/** 
 * @author Sa�l Valdelvira Iglesias
 * @param <T>
 * @verison 28/03/2021
 */
public class ArrayListStack<T> extends AbstractStack<T>{

	public ArrayListStack() {
		list = new ArrayList<T>();
	}
}
