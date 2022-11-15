package saulv.util.collections.queue;

import saulv.util.collections.ArrayList;

/** 
 * @author Saúl Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class ArrayListQueue<T> extends AbstractQueue<T> {

	public ArrayListQueue() {
		list = new ArrayList<T>();
	}
	
}
