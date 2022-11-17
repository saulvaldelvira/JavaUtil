package saulv.collections;

public class Util {
	/**
	 * For legacy reasons, java collections use Object instead of E.
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static <E> E castAs(Object o) {
		return (E) o;
	}
}
