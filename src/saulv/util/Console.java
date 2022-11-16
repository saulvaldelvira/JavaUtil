/*
 * 
 * @author Saúl Valdelvira Iglesias
 * @version 14/04/2021
 *
 */

package saulv.util;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *	Offers utility methods for user-console interaction 
 */
public class Console {
	
	private static PrintStream out = System.out;
	private static Scanner keyboard = new Scanner( System.in );

	public Console(PrintStream p, Scanner i) {
		out = p;
		keyboard = i;
	}
	
	public static String readString(String msg) {
		out.println( msg + ": ");
		keyboard.useDelimiter( System.lineSeparator() );
		String res = keyboard.next();
		keyboard.reset();
		return res;
	}

	public static int readInteger(String msg) {
		out.println( msg + ": ");
		return keyboard.nextInt();
	}

	public static void println(Object o) {
		out.println( o.toString() );
	}
	
	public static void println(String msg) {
		out.println( msg );
	}

	public static void printf(String fmt, Object... params) {
		out.printf( fmt, params );
	}

}
