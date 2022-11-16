package saulv.collections.iterator;



import org.junit.Before;

import saulv.collections.list.LinkedList;
/** 
 * @author Saúl Valdelvira Iglesias
 * @version 28/03/2021
 */
public class LinkedListIteratorRemove extends ListIteratorRemove {

	@Before
	public void setUp() {
		list=new LinkedList<String>();
	}

}
