package saulv.tree.bst;
import saulv.tree.AbstractNode;

/**
 * Represents a Node of a Binary Search Tree.
// * @author Saúl Valdelvira Iglesias
 *
 * @param <T> the type of the info stored in the node
 */
public class BSTNode <T extends Comparable<T>> extends AbstractNode<T>{
	public BSTNode(T clave) {
		super(clave);
	}
} 