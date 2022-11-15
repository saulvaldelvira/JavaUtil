/*
 * 
 * @author Saúl Valdelvira Iglesias
 * @version 14/04/2021
 *
 */
package saulv.util.log;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;

/**
 * A very basic implementation of a logger utility.
 * For this the date are sent to the System.err standard output.
 * The format of every lines is: <timestamp> <message>
 */
public class Logger {

	public static final String FILE = "NewsStandLog.txt";
	public static final boolean APPEND = true;
	private static PrintStream out = System.err;

	/**
	 * Sends the string received as message to the log prefixing it with 
	 * a timestamp 
	 * @param message
	 */
	public static void log(String message) {
		try {
			BufferedWriter out = new BufferedWriter(new PrintWriter(new FileWriter(FILE,APPEND)));
			try {
				out.write(new Date()  + " ");
				out.write(message);
				out.newLine();
			}finally {
				out.close();
			}
		} catch (IOException e) {
			out.print(new Date()  + " " );
			out.print( message );
			out.println();
		}
	}

	/**
	 * Sends the full stack trace of the exception received to the log
	 * prefixing it with a timestamp 
	 * @param t, the exception to be logged
	 */
	public static void log(Throwable t) {
		try {
			BufferedWriter out = new BufferedWriter(new PrintWriter(new FileWriter(FILE,APPEND)));
			try {
				out.write(new Date()  + " ");
				out.write(t.getMessage());
				out.newLine();
			}finally {
				out.close();
			}
		} catch (IOException e) {
			out.print(new Date()  + " " );
			out.print( t.getMessage() );
			out.println();
		}
	}
}
