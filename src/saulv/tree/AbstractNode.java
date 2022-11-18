package saulv.tree;

public abstract class AbstractNode<T extends Comparable<T>> {
	protected T info;
	protected AbstractNode<T> right;
	protected AbstractNode<T> left;
	public AbstractNode(T i) {
		info = i;
		right = null;
		left = null;
	}
	
	//GETTERS Y SETTERS
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	@SuppressWarnings("unchecked")
	public <N extends AbstractNode<T>> N getRight() {
		return (N) right;
	}
	public void setRight(AbstractNode<T> right) {
		this.right = right;
	}
	@SuppressWarnings("unchecked")
	public  <N extends AbstractNode<T>> N getLeft() {
		return (N) left;
	}
	public void setLeft(AbstractNode<T> left) {
		this.left = left;
	}
	
	@Override
	public String toString() {
		return info.toString();
	}
}
