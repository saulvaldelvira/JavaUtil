package saulv.tree.avl;

public class AVLNode<T extends Comparable<T>>{
	private T info;
	private AVLNode<T> left;
	private AVLNode<T> right;
	private int balanceFactor;
	private int height;
	 
	public AVLNode(T clave) {
		setInfo(clave);
		this.left = null;
		this.right = null;
		this.balanceFactor = 0;
		this.height = 0;
	}
	
	/**
	 * Devuelve el valor del atributo info
	 * @return el contenido del Nodo, de tipo T
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * Establece el valor del atributo info
	 * @param clave, el valor que asignar a info. De tipo T
	 */
	public void setInfo(T clave) {
		this.info = clave;
	}

	/**
	 * Devuelve el nodo hijo por la izquierda
	 * @return de tipo AVLNode<T>
	 */
	public AVLNode<T> getLeft() {
		return left;
	}

	/**
	 * Establece el valor del nodo hijo por la izquierda
	 * @param nodo, el nodo que asignar por la izquierda. De tipo AVLNode<T>
	 */
	public void setLeft(AVLNode<T> nodo) {
		this.left = nodo;
	}

	/**
	 * Devuelve el nodo hijo por la derecha
	 * @return de tipo AVLnode<T>
	 */
	public AVLNode<T> getRight() {
		return right;
	}

	/**
	 * Establece el nodo dado como parámetro como el hijo de este nodo por la derecha
	 * @param nodo, de tipo AVLNode<T>
	 */
	public void setRight(AVLNode<T> nodo) {
		this.right = nodo;
	}
	
	/**
	 * Devuelve la altura del nodo
	 * @return la altura, de tipo int
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Devuelvel el balanceFactor del Nodo
	 * @return balanceFactor, de tipo int
	 */
	public int getBF() {
		return balanceFactor;
	}
	
	/**
	 * Actualiza el valor de los atributos height y balanceFactor
	 * La altura de un nodo null es -1
	 */
	public void updateBFHeight() {
		int lHeight;
		if(getLeft()!=null) lHeight = getLeft().getHeight();
		else lHeight = -1;
		
		int rHeight;
		if(getRight()!=null) rHeight = getRight().getHeight();
		else rHeight = -1;
		
		this.balanceFactor = rHeight - lHeight;
		this.height = 1 + max(rHeight, lHeight);
	}
	
	/**
	 * Dados dos números enteros, devuelve el mayor de ellos. 
	 * En caso de ser iguales, devuelve el valor de uno de ellos.
	 * @param rHeight, el primer valor a comprobar. De tipo int
	 * @param lHeight, el segundo valor a comprobar. De tipo int
	 * @return el mayor de los dos, de tipo int
	 */
	private int max(int rHeight, int lHeight) {
		if(rHeight>lHeight) return rHeight;
		else return lHeight;
	}

	/**
	 * Devuelve una cadena representando al Nodo con el siguiente formato:
	 * 		*Info*:BF=*factor de balanceo*
	 * @return la cadena, de tipo String.
	 */
	public String toString() {
		return info.toString() + ":BF=" + getBF();
	}
}
