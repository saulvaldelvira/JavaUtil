package saulv.util.checks;

public class StateChecks {

	public static void isTrue(boolean condition) {
		if (!condition) {
		   throw new IllegalStateException( "Estado del objeto inconsistente" );
		}
	}

	public static void isTrue(boolean condition, String msg) {
		if (!condition) {
		throw new IllegalStateException( msg );
		}
	}
	
	public static void isTrue(boolean condition, RuntimeException e) {
		if (!condition) {
		   throw e;
		}
	}
	
	public static void isFalse(boolean condition, RuntimeException e) {
		if (condition) {
		   throw e;
		}
	}

}
