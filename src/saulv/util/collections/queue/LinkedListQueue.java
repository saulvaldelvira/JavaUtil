package saulv.util.collections.queue;

import saulv.util.collections.LinkedList;

/** 
 * @author Saúl Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class LinkedListQueue<T> extends AbstractQueue<T> {
	
	public LinkedListQueue() {
		list = new LinkedList<T>();
	}
	
}
