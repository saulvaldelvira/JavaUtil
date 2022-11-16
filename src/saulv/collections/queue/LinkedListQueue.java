package saulv.collections.queue;

import saulv.collections.LinkedList;

/** 
 * @author Saúl Valdelvira Iglesias
 * @verison 28/03/2021
 */
public class LinkedListQueue<T> extends AbstractQueue<T> {
	
	public LinkedListQueue() {
		list = new LinkedList<T>();
	}
	
}
