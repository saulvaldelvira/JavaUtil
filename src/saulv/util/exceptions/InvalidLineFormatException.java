/*
 * 
 * @author Saúl Valdelvira Iglesias
 * @version 14/04/2021
 *
 */
package saulv.util.exceptions;


@SuppressWarnings("serial")
public class InvalidLineFormatException extends Exception {

	private int lineNumber;
	
	public InvalidLineFormatException(int ln, String msg) {
		super(msg);
		lineNumber=ln;
	}
	
	@Override
	public String getMessage() {
		return "Error en linea " + lineNumber + ": " + super.getMessage();
	}
}
