/**
 * 
 */
package saulv.collections.iterator;



import org.junit.Before;

import saulv.collections.ArrayList;
/** 
 * @author Saúl Valdelvira Iglesias
 * @version 28/03/2021
 */
public class ArrayListIteratorHasNextTest<T> extends ListIteratorHasNextTest<T> {

	@Before
	public void setUp() {
		list= new ArrayList<String>();
	}

}
