package saulv.util.checks;



public class ArgumentChecks {

	private static String DEFAULT_MESSAGE = "Something went wrong ... ";
	private static String outputMessage = null;
	
	public static void isTrue ( boolean condition ) {
		outputMessage = DEFAULT_MESSAGE;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}

	public static void isTrue ( boolean condition, String message ) {
		outputMessage = message;
		if (!condition) 
			throw new IllegalArgumentException(outputMessage);
	}
	
	public static void isFalse(boolean condition) {
		outputMessage = DEFAULT_MESSAGE;
		if(condition)
			throw new IllegalArgumentException(outputMessage);
	}
	
	public static void isFalse(boolean condition, String message) {
		outputMessage = message;
		if(condition)
			throw new IllegalArgumentException(outputMessage);
	}
	
	public static void isNotNull(Object obj) {
		isTrue(obj!=null, "El parámetro no puede ser null");
	}
	
	public static void isNotEmpty(String str) {
		isTrue(str!=null && !str.isBlank(), "La cadena no puede estar vacía");
	}
	
	public static void positiveNumberCheck(int number) {
		isTrue(number>=0, "El parámetro no puede ser negativo");
	}
}
	
	
