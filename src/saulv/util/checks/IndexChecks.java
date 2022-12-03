/**
 * 
 */
package saulv.util.checks;

/** 
 * @author Saúl Valdelvira Iglesias
 * @version 23/03/2021
 */
public class IndexChecks {

	private static String DEFAULT_MESSAGE = "Something went wrong ... ";
	
	public static void isTrue(boolean condition) {
		if(!condition)
			throw new IndexOutOfBoundsException(DEFAULT_MESSAGE);
	}
	
	public static void isTrue(boolean condition, String message) {
		if(!condition)
			throw new IndexOutOfBoundsException(message);
	}
}

