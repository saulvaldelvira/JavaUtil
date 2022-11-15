package util.collections.queue;

import util.collections.LinkedList;

/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @verison 28/03/2021
 */
public class LinkedListQueue<T> extends AbstractQueue<T> {
	
	public LinkedListQueue() {
		list = new LinkedList<T>();
	}
	
}
