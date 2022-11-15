/**
 * 
 */
package saulv.util.collections.stack;

import saulv.util.collections.ArrayList;

/** 
 * @author Saúl Valdelvira Iglesias
 * @param <T>
 * @verison 28/03/2021
 */
public class ArrayListStack<T> extends AbstractStack<T>{

	public ArrayListStack() {
		list = new ArrayList<T>();
	}
}
