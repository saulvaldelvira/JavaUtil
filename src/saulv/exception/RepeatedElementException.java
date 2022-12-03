package saulv.exception;

public class RepeatedElementException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RepeatedElementException() {
		super("The elemnt already exists in the estructure");
	}
	
	public RepeatedElementException(String msg) {
		super(msg);
	}
	
	public RepeatedElementException(Object o) {
		super("The element " + o + " already exists in the structure");
	}

}
