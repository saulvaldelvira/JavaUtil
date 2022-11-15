/**
 * 
 */
package saulv.util.checks;

import java.util.NoSuchElementException;

/** 
 * @author Saúl Valdelvira Iglesias
 * @version 23/03/2021
 */
public class NoSuchElementChecks {
	
	private static String DEFAULT_MESSAGE = "Something went wrong ... ";
	private static String outputMessage = null;
	
	public static void isTrue ( boolean condition ) {
		outputMessage = DEFAULT_MESSAGE;
		if (!condition) 
			throw new NoSuchElementException(outputMessage);
	}

	public static void isTrue ( boolean condition, String message ) {
		outputMessage = message;
		if (!condition) 
			throw new NoSuchElementException(outputMessage);
	}
	
//	public static void isFalse(boolean condition) {
//		outputMessage = DEFAULT_MESSAGE;
//		if(condition)
//			throw new NoSuchElementException(outputMessage);
//	}
//	
//	public static void isFalse(boolean condition, String message) {
//		outputMessage = message;
//		if(condition)
//			throw new NoSuchElementException(outputMessage);
//	}
}
