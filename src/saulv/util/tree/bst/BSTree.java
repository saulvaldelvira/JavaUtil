package saulv.util.tree.bst;

public class BSTree<T extends Comparable<T>> {
	private BSTNode<T> raiz; //nodo raiz del �rbol BST
	
	public BSTree() {
		this.raiz = null;
	}
	
	/**
	 * Buusca en el arbol un nodo que contenga la clave dada como par�metro
	 * @param clave, la clave a buscar en el �rbol. De tipo T
	 * @return
	 * 		Devuelve null si no encuenta el elemento o si la clave o el elemento son null
	 * 		Devuelve el nodo en caso de encontrar uno que contenga la clave buscada
	 */
	public BSTNode<T> searchNode(T clave){
		if(raiz == null || clave == null)	return null;
		else	return searchNodeR(raiz, clave);
	}
	
	/**
	 * M�todo recursivo que dados un nodo y una clave, busca en el mismo o en 
	 * sus hijos un elemento que tenga la misma clave que la especificada. 
	 * @param node el nodo del que partir
	 * @param clave, la clave para comparar
	 * @return el nodo 
	 */
	private BSTNode<T> searchNodeR(BSTNode<T> node, T clave) {
		int compare = node.getInfo().compareTo(clave);
		if(compare==0)
			return node;
		else if(compare < 0) {
			if(node.getRight()!=null)	
				return searchNodeR(node.getRight(), clave); //si la clave del nodo es > que la clave buscada hay que buscar por los hijos de la izquierda
		}	
		else if(compare > 0) {
			if(node.getLeft()!=null)
				return searchNodeR(node.getLeft(), clave); //y si es < 0 hay que buscar por los hijos de la derecha
		}
		return null;
	}

	/**
	 * A�ade un elemento al �rbol. 
	 * @param clave, la clave del elemento a a�adir
	 * @return
	 * 		-2 si la clave dada como par�metro es null
	 * 		-1 si la clave ya existe
	 * 		 0 si lo a�ade correctamente
	 */
	public int addNode(T clave) {
		if(clave == null)
			return -2;
		if(raiz == null) {
			raiz = new BSTNode<T>(clave);
			return 0;
		}
		return addNodeR(raiz, clave);
		
	}
	
	private int addNodeR(BSTNode<T> node, T clave) {
		int compare = node.getInfo().compareTo(clave);
		if(compare>0) {
			if(node.getLeft()==null) {
				node.setLeft(new BSTNode<T>(clave));
				return 0;
			}else 
				return addNodeR(node.getLeft(), clave);
		}
		
		else if(compare<0) {
			if(node.getRight()==null) {
				node.setRight(new BSTNode<T>(clave));
				return 0;
			}else
				return addNodeR(node.getRight(), clave);
		}
		else
			return -1;
		
	}

	/**
	 * Devuelve una cadena con el recorrido preOrder del �rbol
	 * @return
	 */
	public String preOrder() {
		String cadena = preOrderRecursivo(raiz);
		return cadena;//.substring(0, cadena.length()-1);
	}
	
	private String preOrderRecursivo(BSTNode<T> node) {
		if(node==null) return "";
		if(node.getLeft()==null && node.getRight()==null)
			return node.getInfo().toString();
		else if(node.getLeft()==null)
			return node.getInfo() + "\t" + preOrderRecursivo(node.getRight());
		else if(node.getRight()==null)
			return node.getInfo() + "\t" + preOrderRecursivo(node.getLeft());
		else
			return node.getInfo() + "\t" + preOrderRecursivo(node.getLeft()) + "\t" + preOrderRecursivo(node.getRight());	
	}

	/**
	 * Devuelve una cadena con el recorrido postOrder del �rbol
	 * @return
	 */
	public String postOrder() {
		String cadena  = postOrderRecursivo(raiz);
		return cadena;//.substring(0, cadena.length()-1);
	}
	
	private String postOrderRecursivo(BSTNode<T> node) {
		if(node==null) return "";
		if(node.getLeft()==null && node.getRight()==null)
			return node.getInfo().toString();
		else if(node.getLeft()==null)
			return  postOrderRecursivo(node.getRight()) + "\t" + node.getInfo();
		else if(node.getRight()==null)
			return  postOrderRecursivo(node.getLeft()) + "\t" + node.getInfo();
		else
			return postOrderRecursivo(node.getLeft()) + "\t" + postOrderRecursivo(node.getRight()) + "\t" + node.getInfo();
	}

	/**
	 * Devuelve una cadena con el recorrido inOrder del �rbol
	 * @return
	 */
	public String inOrder() {
		String cadena = inOrderRecursivo(raiz);
		return cadena;//.substring(0, cadena.length()-1);
	}
	
	private String inOrderRecursivo(BSTNode<T> node) {
		if(node==null) return "";
		if(node.getLeft()==null && node.getRight()==null)
			return node.getInfo().toString();
		else if(node.getLeft()==null)
			return node.getInfo() + "\t" + inOrderRecursivo(node.getRight());
		else if(node.getRight()==null)
			return inOrderRecursivo(node.getLeft()) + "\t" + node.getInfo();
		else
			return  inOrderRecursivo(node.getLeft()) + "\t" + node.getInfo() + "\t" + inOrderRecursivo(node.getRight());
	}

	/**
	 * Elimina un nodo del �rbol
	 * @param clave, la clave del nodo a eliminar
	 * @return
	 * 		 0 si elimina el nodo correctamente
	 * 		-2 si la clave o el arbol son null
	 * 		-1 si la clave no existe
	 */
	public int removeNode(T clave) {
		if(clave==null || raiz==null)
			return -2;
		else if(searchNode(clave)==null)
			return -1;
		raiz = removeNodeR(raiz, clave);
		return 0;
	}

	/**
	 * M�todo recursivo que elimina un nodo dada su clave, y partiendo de una rama
	 * dada como par�metro
	 * @param node, el nodo de partida
	 * @param clave, la clave a eliminar 
	 * @return el nodo de partida pero sin el nodo que se ten�a que eliminar
	 */
	private BSTNode<T> removeNodeR(BSTNode<T> node, T clave) {
		if(node.getInfo().compareTo(clave)==0) {
			if(node.getLeft()==null && node.getRight()==null)
				return null;
			else if(node.getLeft()==null)
				return node.getRight();
			else if(node.getRight()==null)
				return node.getLeft();
			else {
				T mayor = getHighest(node.getLeft());
				removeNode(mayor);
				node.setInfo(mayor);
				return node;
			}
		}
		
		int compare = node.getInfo().compareTo(clave);
		if(compare < 0) {
			node.setRight(removeNodeR(node.getRight(), clave));
			return node;
		}else {
			node.setLeft(removeNodeR(node.getLeft(), clave));
			return node;
		}		
	}

	/**
	 * Devuelve el mayor de los nodos que haya a partir del que se de como par�metro
	 * @param node, el nodo de partida
	 * @return el mayor 
	 */
	private T getHighest(BSTNode<T> node) {
		if(node.getRight()==null)
			return node.getInfo();
		else 
			return getHighest(node.getRight());
			
	}
} 
