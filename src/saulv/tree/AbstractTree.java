package saulv.tree;

import java.util.ArrayList;
import java.util.Collection;

import saulv.tree.exception.ElementNotPresentException;
import saulv.tree.exception.EmptyStructureException;
import saulv.tree.exception.RepeatedElementException;

public abstract class AbstractTree<T extends Comparable<T>, N extends AbstractNode<T>> implements Tree<T> {
	public static final String SEPARATOR = "-"; // toString()
	N root;
	int nElements;
	
	public AbstractTree() {
		root = null;
		nElements = 0;
	}
	
	public N getRoot(){
		return root;
	}
	
	@Override
	public void add(T element) {
		if(element == null)
			throw new NullPointerException("The given element is null");
		root = addR(element, root);
	}
	
	/**
	 * Recursive method to support {@link Tree#add(Comparable)}
	 * @param element to add
	 * @param node actual node try add into
	 * @return the node after the operation
	 */
	protected abstract N addR(T element, N node);
	
	@Override
	public void addAll(T[] elements) {
		if(elements == null)
			throw new NullPointerException("The array of elements is null");
		for(int i=0; i<elements.length; i++)
			if(elements[i]!=null)
				add(elements[i]);
	}
	
	@Override
	public void remove(T element) {
		if(element==null)
			throw new NullPointerException("The element "+ element + " is null");
		if(root==null)
			throw new EmptyStructureException("This tree is empty");
		root = removeR(element, root);
	}
	
	/**
	 * Recursive method to support {@link Tree#remove(Comparable)}
	 * @param element to remove
	 * @param node the current node of the search
	 * @throws ElementNotPresentException if the element does not exist in the tree
	 * @return the new node after the operation
	 */
	protected abstract N removeR(T element, N node);
	
	@Override
	public void removeAll(T[] elements) {
		if(elements == null)
			throw new NullPointerException("The array of elements is null");
		for(int i=0; i<elements.length; i++)
			if(elements[i]!=null)
				remove(elements[i]);
	}
	
	public boolean contains(T element) {
		return get(element)!=null;
	}
	
	@Override
	public T get(T element) {
		if(element == null)
			throw new NullPointerException("The given element is null");
		return searchR(element, root);
	}
	
	/**
	 * Recursive method to support {@link AbstractTree#search(Comparable)}
	 * @param element to search for
	 * @param node actual node to search in
	 * @return true if exists, false otherwise
	 */
	private T searchR(T element, N node) {
		if(node==null)	return null;
		int c = element.compareTo(node.getInfo());
		if(c>0)
			return searchR(element, node.getRight());
		else if(c<0)
			return searchR(element, node.getLeft());
		else
			return node.info;
	}
	
	@Override
	public T getMax(AbstractNode<T> node) {
		if(node==null)
			return null;
		if(node.getRight()==null)
			return node.getInfo();
		else
			return getMax(node.getRight());
	}

	@Override
	public boolean empty() {
		return root==null;
	}
	
	@Override
	public int getHeight() {
		return getHeightR(root);
	}	
	
	/**
	 * Recursive method to support the public {@link AbstractTree#getHeight()}
	 * @param node, the actual node
	 * @return the height of this node, or 0 if it reaches the bottom-
	 */
	private int getHeightR(N node) {
		if(node == null) return 0;
		int lHeight = 1 + getHeightR(node.getLeft()),
			rHeight = 1 + getHeightR(node.getRight());
		return lHeight > rHeight ? lHeight : rHeight;
	}
	
	@SuppressWarnings("unchecked")
	public Tree<T> joins(Tree<T> other){
		Tree<T> result;
		try {
			result = (Tree<T>) this.getClass().getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			return null;
		}
		ArrayList<T> elements = this.getElements(new ArrayList<T>());
		other.addElementsTo(elements);
		for(T element: elements)
			try {
				result.add(element);
			}catch(RepeatedElementException e) {
				//if the element already exists, just ignore it
			}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <C extends Collection<T>> C getElements(C clas){
		C result = null;
		
		try {
			result = (C) clas.getClass().getDeclaredConstructor().newInstance();
			addElementsTo(result);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}
	
	public void addElementsTo(Collection<T> c){
		addElementsToR(c, root);
	}
	
	/**
	 * Recursive method to support {@link AbstractTree#getElements(Collection)} that 
	 * searches in the tree for the elements and adds them into a collection.
	 * @param c    : the collection to store the element in
	 * @param node : the current node
	 */
	private void addElementsToR(Collection<T> c, N node){
		if(node==null)
			return;
		c.add(node.getInfo());
		addElementsToR(c, node.getRight());
		addElementsToR(c, node.getLeft());
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractTree<T,N> other = (AbstractTree<T,N>) obj;
		return getElements(new ArrayList<T>()).equals(other.getElements(new ArrayList<T>()));
	}

	@Override
	public String toString() {
		return toStringR(root);
	}
	
	public String toStringR(N node) {
		if(node==null)
			return SEPARATOR;
		return node.toString() + toStringR(node.getLeft()) + toStringR(node.getRight());
		
	}
	
	/*
	 * public String preOrder() {
		String cadena = preOrderRecursivo(root);
		return cadena;// .substring(0, cadena.length()-1);
	}

	private String preOrderRecursivo(AVLNode<T> node) {
		if (node == null)
			return "";
		if (node.getLeft() == null && node.getRight() == null)
			return node.toString();
		else if (node.getLeft() == null)
			return node.getInfo() + "\t" + preOrderRecursivo(node.getRight());
		else if (node.getRight() == null)
			return node.getInfo() + "\t" + preOrderRecursivo(node.getLeft());
		else
			return node.getInfo() + "\t" + preOrderRecursivo(node.getLeft()) + "\t"
					+ preOrderRecursivo(node.getRight());
	}

	
	public String postOrder() {
		String cadena = postOrderRecursivo(root);
		return cadena;// .substring(0, cadena.length()-1);
	}

	private String postOrderRecursivo(AVLNode<T> node) {
		if (node == null)
			return "";
		if (node.getLeft() == null && node.getRight() == null)
			return node.toString();
		else if (node.getLeft() == null)
			return postOrderRecursivo(node.getRight()) + "\t" + node;
		else if (node.getRight() == null)
			return postOrderRecursivo(node.getLeft()) + "\t" + node;
		else
			return postOrderRecursivo(node.getLeft()) + "\t" + postOrderRecursivo(node.getRight()) + "\t" + node;
	}

	
	public String inOrder() {
		String cadena = inOrderRecursivo(root);
		return cadena;// .substring(0, cadena.length()-1);
	}

	private String inOrderRecursivo(AVLNode<T> node) {
		if (node == null)
			return "";
		if (node.getLeft() == null && node.getRight() == null)
			return node.toString();
		else if (node.getLeft() == null)
			return node + "\t" + inOrderRecursivo(node.getRight());
		else if (node.getRight() == null)
			return inOrderRecursivo(node.getLeft()) + "\t" + node;
		else
			return inOrderRecursivo(node.getLeft()) + "\t" + node + "\t" + inOrderRecursivo(node.getRight());
	}*/
}
