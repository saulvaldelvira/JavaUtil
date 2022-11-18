package saulv.tree.avl;
import saulv.tree.AbstractNode;
/**
 * Represents a node of an Balanced Tree ({@link AVLTree})
 * @author Saúl Valdelvira Iglesias
 *
 * @param <T> the type of the info stored in the node
 */
public class AVLNode<T extends Comparable<T>> extends AbstractNode<T>{
	private int height;
	public AVLNode(T i) {
		super(i);
		height = 0;
	}
	
	/**
	 * Updates the height of the node
	 */
	public void updateHeight() {
		if(right==null && left==null)
			height = 0;
		else if(left==null)
			height = ((AVLNode<T>) right).height + 1;
		else if(right==null)
			height = ((AVLNode<T>) left).height + 1;
		else
			height = Math.max(((AVLNode<T>) left).height, ((AVLNode<T>) right).height) + 1;
	}
	
	/**
	 * @return the balance factor of the node 
	 */
	public int getBF() {
		int rigthH = right==null? -1 : ((AVLNode<T>) right).height,
			leftH = left==null? -1 : ((AVLNode<T>) left).height;
		return rigthH - leftH;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return info + "(" + getBF() + ")";
	}
		
}