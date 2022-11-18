package saulv.tree.avl;

import saulv.tree.exception.ElementNotPresentException;
import saulv.tree.exception.RepeatedElementException;
import saulv.tree.AbstractTree;

/**
 * Represents an AVL Tree. <br>
 * More info: <a>https://en.wikipedia.org/wiki/AVL_tree</a>
 * @author Saúl Valdelvira Iglesias (UO283685)
 *
 * @param <T> the type of the info stored in the tree
 */
public class AVLTree<T extends Comparable<T>> extends AbstractTree<T, AVLNode<T>> {
	public static final int MAX_DISBALANCE = 2; // updateBF()
	
	private AVLNode<T> root;
	
	public AVLTree() {
		super();
	}
	
	public AVLNode<T> getRoot(){
		return root;
	}
		
	protected AVLNode<T> addR(T element, AVLNode<T> node) {
		if(node==null)
			return new AVLNode<T>(element);
		int c = element.compareTo(node.getInfo());
		if(c>0)
			node.setRight(addR(element, node.getRight()));
		else if(c<0)
			node.setLeft(addR(element, node.getLeft()));
		else
			throw new RepeatedElementException(element);
		return updateBF(node);
	}

	protected AVLNode<T> removeR(T element, AVLNode<T> node) {
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
		return updateBF(node);
	}
	
	/**
	 * Updates the height of the given node and performs a rotation if necessary
	 * @param node to update
	 * @return the same node after the update
	 */
	private AVLNode<T> updateBF(AVLNode<T> node){
		node.updateHeight();
		int bf = node.getBF();
		if(bf <= -MAX_DISBALANCE)
			if(((AVLNode<T>) node.getLeft()).getBF() <= 0)
				node = singleLeftRotation(node);
			else
				node = doubleLeftRotation(node);
		else if(bf >= MAX_DISBALANCE)
			if(((AVLNode<T>) node.getRight()).getBF() >= 0)
				node = singleRightRotation(node);
			else 
				node = doubleRightRotation(node);
		node.updateHeight();
		return node;
	}
	
	/**
	 * Performs a double right rotation on the given node
	 * @param node to perform the rotation in
	 * @return that same node after the rotation
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> node) {
		AVLNode<T> auxA = node.getRight(),
				   auxB = auxA.getLeft();
		node.setRight(auxB.getLeft());
		auxA.setLeft(auxB.getRight());
		auxB.setRight(auxA);	
		auxB.setLeft(node);
		auxA.updateHeight();
		node.updateHeight();
		return auxB;
		/*nodo.setRight(singleLeftRotation(nodo.getRight()));
		return singleRightRotation(nodo);*/
	}

	/**
	 * Performs a single right rotation on the given node
	 * @param node to perform the rotation in
	 * @return that same node after the rotation
	 */
	private AVLNode<T> singleRightRotation(AVLNode<T> node) {
		AVLNode<T> aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		node.updateHeight();
		return aux;
	}

	/**
	 * Performs a double left rotation on the given node
	 * @param node to perform the rotation in
	 * @return that same node after the rotation
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> node) {
		AVLNode<T> auxA = node.getLeft(),
				   auxB = auxA.getRight();
		node.setLeft(auxB.getRight());
		auxA.setRight(auxB.getLeft());
		auxB.setLeft(auxA);	
		auxB.setRight(node);
		auxA.updateHeight();
		node.updateHeight();
		return auxB;
		/*nodo.setLeft(singleRightRotation(nodo.getLeft()));
		return singleLeftRotation(nodo);*/
	}

	/**
	 * Performs a single left rotation on the given node
	 * @param node to perform the rotation in
	 * @return that same node after the rotation
	 */
	private AVLNode<T> singleLeftRotation(AVLNode<T> node) {
		AVLNode<T> aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		node.updateHeight(); //Aux height is updated in updateBF()
		return aux;
	}	
} 
