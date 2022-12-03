package saulv.exception;

public class EmptyStructureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyStructureException() {
		super("The structure is empty");
	}
	
	public EmptyStructureException(String msg) {
		super(msg);
	}
	

}
