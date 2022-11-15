package util.collections.queue;

import util.collections.ArrayList;

/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @verison 28/03/2021
 */
public class ArrayListQueue<T> extends AbstractQueue<T> {

	public ArrayListQueue() {
		list = new ArrayList<T>();
	}
	
}
