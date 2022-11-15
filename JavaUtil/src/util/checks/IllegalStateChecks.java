/**
 * 
 */
package util.checks;

/**
 * @author Saúl
 *
 */
public class IllegalStateChecks {

	private static String DEFAULT_MESSAGE = "Something went wrong ... ";
	private static String outputMessage = null;
	
	public static void isTrue(boolean condition) {
		outputMessage = DEFAULT_MESSAGE;
		if(!condition)
			throw new IllegalStateException(outputMessage);
	}
	
	public static void isTrue(boolean condition, String message) {
		outputMessage = message;
		if(!condition)
			throw new IllegalStateException(outputMessage);
	}
	
//	public static void isFalse(boolean condition) {
//		outputMessage = DEFAULT_MESSAGE;
//		if(condition)
//			throw new IllegalStateException(outputMessage);
//	}
//	
//	public static void isFalse(boolean condition, String message) {
//		outputMessage = message;
//		if(condition)
//			throw new IllegalStateException(outputMessage);
//	}
}
