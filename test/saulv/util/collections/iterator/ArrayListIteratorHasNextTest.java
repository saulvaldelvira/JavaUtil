/**
 * 
 */
package saulv.util.collections.iterator;



import org.junit.Before;

import saulv.util.collections.ArrayList;
/** 
 * @author Sa�l Valdelvira Iglesias
 * @version 28/03/2021
 */
public class ArrayListIteratorHasNextTest<T> extends ListIteratorHasNextTest<T> {

	@Before
	public void setUp() {
		list= new ArrayList<String>();
	}

}
