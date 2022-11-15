package saulv.util.collections.stack;

public interface Stack<T> 
{	
	/**
	 * Pushes (adds) an item onto the top of the stack.
	 * @param element the object to be pushed
	 */
	public void push(T element);
	
	/**
	 * Returns the object at the top of the stack without removing it.
	 * @return the object at the top of the stack
	 */
	public Object peek();
	
	/**
	 * Removes and returns the object at the top of the stack.
	 * @return the object removed from the sack
	 */
	public Object pop();
	
	/**
	 * Returns the number of elements in the stack.
	 * @return the number of elements in the stack
	 */
	public int size();
	
	/**
	 * Returns whether the stack is empty or not.
	 * @return true if the stack is empty; false otherwise.
	 */
	public boolean isEmpty();	
}
