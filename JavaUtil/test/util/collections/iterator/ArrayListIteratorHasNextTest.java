/**
 * 
 */
package util.collections.iterator;



import org.junit.Before;

import util.collections.ArrayList;
/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 28/03/2021
 */
public class ArrayListIteratorHasNextTest<T> extends ListIteratorHasNextTest<T> {

	@Before
	public void setUp() {
		list= new ArrayList<String>();
	}

}
