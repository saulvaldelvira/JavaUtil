package saulv.tree;

import java.util.Collection;

import saulv.exception.EmptyStructureException;

/**
 * Interface that defines the functionality of a Tree
 * @author Saúl
 *
 * @param <T>
 * @version 1.0
 */
public interface Tree<T extends Comparable<T>>{
	/**
	 * Adds an element in the tree.
	 * @param element to add
	 * @return 
	 * @throws NullPointerException if the element is null
	 */
	public void add(T element);
	
	/**
	 * Adds all the elements of the array to the tree. Ignores the null elements
	 * @param the elements to add
	 * @throws NullPointerException if the array is null.
	 */
	public void addAll(T[] elements);
	
	/**
	 * Removes an element from the tree.
	 * @param element to remove.
	 * @throws NullPointerException if the given element is null
	 * @throws EmptyStructureException if the tree is empty
	 */
	public void remove(T element);
	
	/**
	 * Removes all the elements of the array to the tree. Ignores the null elements
	 * @param the elements to remove
	 * @throws NullPointerException if the array is null.
	 */
	public void removeAll(T[] elements);
	
	/**
	 * Returns whether the element specified as a parameter exists or not in the tree
	 * @param element to look for
	 * @throws NullPointerException if the element is null
	 * @return true if exists, false otherwise
	 */
	public boolean contains(T element);
	
	/**
	 * Returns the element specified as a parameter or null if it can't find it
	 * @param element to look for
	 * @throws NullPointerException if the element is null
	 * @return the element if it exists, null otherwise
	 */
	public T get(T element);
	
	/**
	 * Returns the max value stored in the tree, starting in the node 
	 * given as a parameter
	 * @param node to start the search in
	 * @return the max value
	 */
	public T getMax(AbstractNode<T> node);
	
	/**
	 * @return true if the tree is empty, false otherwise
	 */
	public boolean empty();
	
	/**
	 * Returns tree's height
	 * @return the height. int
	 */
	public int getHeight();
	
	/**
	 * Given a AVLTree as a parameter, returns a new AVLTree
	 * containing all the elements from both trees. <br>
	 * This method does not modify the original trees.
	 * @param other : the AVLTree to join.
	 * @return a new AVLTree, representing the joint of the two.
	 */
	public Tree<T> joins(Tree<T> other);
	
	/**
	 * Returns a new Collection with all the elements of the Tree.
	 * @param <C> the type of the collection. Must Extends Collection<T>
	 * @param clas an object of the same type as the desired return type
	 * @return the new Colelction
	 */
	public <C extends Collection<T>> C getElements(C clas);
	
	/**
	 * Given a collection, adds all the elements in the tree to it
	 * @param c the Collencion to add
	 */
	public void addElementsTo(Collection<T> c);
}
