package saulv.util.tree.bst;

public class BSTNode <T extends Comparable<T>>{
	private T info; //Contenido del Nodo, de tipo genérico T
	private BSTNode<T> left; //el nodo hijo izquierdo
	private BSTNode<T> right; //el nodo hijo derecho
	
	/**
	 * Constructor de un objeto de la clase BSTNode
	 * Los atributos left y right se inicializan a null
	 * @param clave, el valor del atributo info
	 */
	public BSTNode(T clave) {
		setInfo(clave);
		setLeft(null);
		setRight(null);
	}
	
	/**
	 * Establece el valor del atributo info
	 * @param clave, el valor para info. de tipo genérico T
	 */
	public void setInfo(T clave) {
		this.info = clave;
	}
	
	/**
	 * Devuelve el valor de info
	 * @return el valor de info, tipo T
	 */
	public T getInfo() {
		return this.info;
	}
	
	/**
	 * Asigna el parámetro nodo dado al atributo left
	 * @param nodo, de tipo BSTNode<T>
	 */
	public void setLeft(BSTNode<T> nodo) {
		this.left = nodo;
	}
	
	/**
	 * Asigna el parámetro nodo dado al atributo right
	 * @param nodo, de tipo BSTNode<T>
	 */
	public void setRight(BSTNode<T> nodo) {
		this.right = nodo;
	}
	
	/**
	 * Devuelve el valor del atributo left
	 * @return left, de tipo BSTNode<T>
	 */
	public BSTNode<T> getLeft(){
		return this.left;
	}
	
	/**
	 * Devuelve el valor del atributo right
	 * @return left, de tipo BSTNode<T>
	 */
	public BSTNode<T> getRight(){
		return this.right;
	}
	
	/**
	 * Devuelve el toString del parámetro info
	 * @return el String
	 */
	public String toString() {
		return info.toString();
	}	
	
} 
