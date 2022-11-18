package saulv.tree.bst;

import saulv.tree.AbstractTree;
import saulv.tree.exception.ElementNotPresentException;
import saulv.tree.exception.RepeatedElementException;
/**
 * Represents a Binary Search Tree. <br>
 * More info: <a>https://en.wikipedia.org/wiki/Binary_search_tree</a>
 * @author Saúl Valdelvira Iglesias
 *
 * @param <T> the type of the info stored in the node
 */
public class BSTree<T extends Comparable<T>> extends AbstractTree<T, BSTNode<T>> {
	
	public BSTree() {
		super();
	}
	
	protected BSTNode<T> addR(T element, BSTNode<T> node) {
		if(node==null)
			return new BSTNode<T>(element);
		int c = element.compareTo(node.getInfo());
		if(c>0)
			node.setRight(addR(element, node.getRight()));
		else if(c<0)
			node.setLeft(addR(element, node.getLeft()));
		else
			throw new RepeatedElementException(element);
		return node;
	}
	
	protected BSTNode<T> removeR(T element, BSTNode<T> node) {
		if(node==null)
			throw new ElementNotPresentException(element);
		int c = element.compareTo(node.getInfo());
		if(c==0) {
			if(node.getLeft()==null)
				return node.getRight();
			else if(node.getRight()==null)
				return node.getLeft();
			else {
				node.setInfo(getMax(node.getLeft()));
				node.setLeft(removeR(node.getInfo(), node.getLeft()));
			}
				
		}else if(c<0)
			node.setLeft(removeR(element, node.getLeft()));
		else
			node.setRight(removeR(element, node.getRight()));
		return node;
	}
} 