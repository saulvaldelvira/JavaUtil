package saulv.collections.queue;

import saulv.collections.ArrayList;

/** 
 * @author Sa�l Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class ArrayListQueue<T> extends AbstractQueue<T> {

	public ArrayListQueue() {
		list = new ArrayList<T>();
	}
	
}
