/**
 * 
 */
package util.checks;

/** 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 23/03/2021
 */
public class IndexChecks {

	private static String DEFAULT_MESSAGE = "Something went wrong ... ";
	private static String outputMessage = null;
	
	public static void isTrue(boolean condition) {
		outputMessage = DEFAULT_MESSAGE;
		if(!condition)
			throw new IndexOutOfBoundsException(outputMessage);
	}
	
	public static void isTrue(boolean condition, String message) {
		outputMessage = message;
		if(!condition)
			throw new IndexOutOfBoundsException(outputMessage);
	}
	
//	public static void isFalse(boolean condition) {
//		outputMessage = DEFAULT_MESSAGE;
//		if(condition)
//			throw new IndexOutOfBoundsException(outputMessage);
//	}
//	
//	public static void isFalse(boolean condition, String message) {
//		outputMessage = message;
//		if(condition)
//			throw new IndexOutOfBoundsException(outputMessage);
//	}
}

