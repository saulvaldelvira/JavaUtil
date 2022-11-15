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

}
