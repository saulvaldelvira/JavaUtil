package saulv.tree.avl;

import java.util.List;

public class AVLTree<T extends Comparable<T>> {
	private AVLNode<T> raiz;

	public AVLTree() {
		raiz = null;
	}

	/**
	 * Añade un elemento al árbol.
	 * 
	 * @param clave, la clave del elemento a añadir
	 * @return -2 si la clave dada como parámetro es null -1 si la clave ya existe 0
	 *         si lo añade correctamente
	 */
	public int addNode(T clave) {
		if (clave == null)
			return -2;
		if (raiz == null) {
			raiz = new AVLNode<T>(clave);
			return 0;
		}
		if (searchNode(clave) != null)
			return -1;
		raiz = addNodeR(raiz, clave);
		updateAndBalanceIfNecesary(raiz);
		return 0;
	}

	private AVLNode<T> addNodeR(AVLNode<T> node, T clave) {
		int compare = node.getInfo().compareTo(clave);
		if (compare > 0) {
			if (node.getLeft() == null) {
				node.setLeft(new AVLNode<T>(clave));
				node = updateAndBalanceIfNecesary(node);
				return node;
			} else {
				node.setLeft(addNodeR(node.getLeft(), clave));
				;
				node = updateAndBalanceIfNecesary(node);
				return node;
			}
		}

		else if (compare < 0) {
			if (node.getRight() == null) {
				node.setRight(new AVLNode<T>(clave));
				node = updateAndBalanceIfNecesary(node);
				return node;
			} else {
				node.setRight(addNodeR(node.getRight(), clave));
				node = updateAndBalanceIfNecesary(node);
				return node;
			}
		} else
			return node;

	}

	/**
	 * Actualiza el factor de balance y la altura del nodo. 
	 * En caso de ser necesario, realiza una rotación del mismo.
	 * @param nodo, el nodo a actualizar
	 * @return el nodo ya actualizado
	 */
	private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> nodo) {
		nodo.updateBFHeight();
		if (nodo.getBF() == -2) {
			if (nodo.getLeft().getBF() == 1)
				nodo = doubleLeftRotation(nodo);
			else
				nodo = singleLeftRotation(nodo);
		} else if (nodo.getBF() == 2) {
			if (nodo.getRight().getBF() == -1)
				nodo = doubleRightRotation(nodo);
			else
				nodo = singleRightRotation(nodo);
		}
		return nodo;
	}

	/**
	 * Realiza una rotacion simple por la izquierda del nodo
	 * @param nodo, el nodo a rotar
	 * @return el nodo ya rotado
	 */
	private AVLNode<T> singleLeftRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getLeft();
		nodo.setLeft(aux.getRight());
		nodo.updateBFHeight();
		aux.setRight(nodo);
		aux.updateBFHeight();
		return aux;
	}

	/**
	 * Realiza una rotacion doble por la izquierda del nodo
	 * @param nodo, el nodo a rotar
	 * @return el nodo ya rotado
	 */
	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) {
		nodo.setLeft(singleRightRotation(nodo.getLeft()));
		return singleLeftRotation(nodo);
	}

	/**
	 * Realiza una rotacion simple por la derecha del nodo
	 * @param nodo, el nodo a rotar
	 * @return el nodo ya rotado
	 */
	private AVLNode<T> singleRightRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getRight();
		nodo.setRight(aux.getLeft());
		nodo.updateBFHeight();
		aux.setLeft(nodo);
		aux.updateBFHeight();
		return aux;
	}

	/**
	 * Realiza una rotacion doble por la derecha del nodo
	 * @param nodo, el nodo a rotar
	 * @return el nodo ya rotado
	 */
	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) {
		nodo.setRight(singleLeftRotation(nodo.getRight()));
		return singleRightRotation(nodo);
	}

	/**
	 * Buusca en el arbol un nodo que contenga la clave dada como parámetro
	 * 
	 * @param clave, la clave a buscar en el árbol. De tipo T
	 * @return Devuelve null si no encuenta el elemento o si la clave o el elemento
	 *         son null Devuelve el nodo en caso de encontrar uno que contenga la
	 *         clave buscada
	 */
	public AVLNode<T> searchNode(T clave) {
		if (raiz == null || clave == null)
			return null;
		else
			return recursiveSearch(raiz, clave);

	}

	/**
	 * Método recursivo que dados un nodo y una clave, busca en el mismo o en sus
	 * hijos un elemento que tenga la misma clave que la especificada.
	 * 
	 * @param node   el nodo del que partir
	 * @param clave, la clave para comparar
	 * @return el nodo
	 */
	private AVLNode<T> recursiveSearch(AVLNode<T> node, T clave) {
		int compare = node.getInfo().compareTo(clave);
		if (compare == 0)
			return node;
		else if (compare < 0) {
			if (node.getRight() != null)
				return recursiveSearch(node.getRight(), clave); // si la clave del nodo es > que la clave buscada hay
																// que buscar por los hijos de la izquierda
		} else if (compare > 0) {
			if (node.getLeft() != null)
				return recursiveSearch(node.getLeft(), clave); // y si es < 0 hay que buscar por los hijos de la derecha
		}
		return null;
	}

	/**
	 * Devuelve una cadena con el recorrido preOrder del árbol
	 * 
	 * @return
	 */
	public String preOrder() {
		String cadena = preOrderRecursivo(raiz);
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

	/**
	 * Devuelve una cadena con el recorrido postOrder del árbol
	 * 
	 * @return una cadena con el recorrido postOrder del árbol
	 */
	public String postOrder() {
		String cadena = postOrderRecursivo(raiz);
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

	/**
	 * Devuelve una cadena con el recorrido inOrder del árbol
	 * 
	 * @return
	 */
	public String inOrder() {
		String cadena = inOrderRecursivo(raiz);
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
	}

	/**
	 * Devuelve el nodo padre del nodo cuya clave se da como
	 * @param clave, la clave del nodo cuyo padre se quiere conseguir
	 * @return el nodo padre
	 */
	public AVLNode<T> padreDe(T clave) {
		if (raiz == null || clave == null || searchNode(clave)==null)
			return null;
		return padreDeR(raiz, clave);
	}

	private AVLNode<T> padreDeR(AVLNode<T> node, T clave) {
		int compare = node.getInfo().compareTo(clave);
		if (compare == 0)
			return node;
		else if (compare < 0) {
			if (node.getRight() != null) {
				if (node.getRight().getInfo().compareTo(clave) == 0)
					return node;
				else
					return padreDeR(node.getRight(), clave); // si la clave del nodo es > que la clave buscada
																	// hay que buscar por los hijos de la izquierda
			}
		} else if (compare > 0) {
			if (node.getLeft() != null) {
				if (node.getLeft().getInfo().compareTo(clave) == 0)
					return node;
				else
					return padreDeR(node.getLeft(), clave); // y si es < 0 hay que buscar por los hijos de la
																	// derecha
			}
		}
		return null;
	}

	/**
	 * Devuelve el número de aristas entre dos claves dadas
	 * @param clave1 la clave de partida
	 * @param clave2 la clave destino
	 * @return el número de aristas entre ellas, -2 si las claves o la raíz son nulas
	 * 		o -1 si alguna de las claves no existe en el árbol
	 */
	public int numAristas(T clave1, T clave2) {
		int numAristas = 0;
		if (clave1 == null || clave2 == null || raiz == null)
			return -2;
		else if(searchNode(clave1)==null || searchNode(clave2)==null) return -1;
		else if(clave1.compareTo(clave2)==0) return numAristas;
		else
			return numAristasR(numAristas, clave1, clave2);
	}

	private int numAristasR(int n, T c1, T c2) {
		AVLNode<T> p1 = padreDe(c1);
		AVLNode<T> p2 = padreDe(c2);
		if (p1 == null) {
			if (p2 == null)
				return n;
			else {
				n++;
				return numAristasR(n, c1, p2.getInfo());
			}

		} else if (p2 == null) {
			n++;
			return numAristasR(n, p1.getInfo(), c2);
		} 
		else if(p1.getInfo().compareTo(c2)==0 || p2.getInfo().compareTo(c1)==0)
			return ++n;
		else if(p1.getInfo().compareTo(p2.getInfo())==0) {
			n+=2;
			return n;
		}
		else {
			n += 2;
			return numAristasR(n, p1.getInfo(), p2.getInfo());
		}
	}

	/**
	 * Elimina un nodo del Árbol
	 * @param clave, la clave del nodo a eliminar
	 * @return
	 * 		* 0 si lo elimina correctamente
	 * 		*-1 si no existe el nodo
	 * 		*-2 si la clave o la raíz son nulas
	 */
	public int removeNode(T clave) {
		if (clave == null || raiz == null)
			return -2;
		if (searchNode(clave) == null)
			return -1;
		raiz = removeNodeR(raiz, clave);
		return 0;
	}

	private AVLNode<T> removeNodeR(AVLNode<T> node, T clave) {
		if (node == null)
			return null;
		int compare = node.getInfo().compareTo(clave);
		if (compare == 0) {
			if (node.getRight() == null && node.getLeft() == null)
				return null;
			else if (node.getRight() == null)
				return node.getLeft();
			else {
				if (node.getLeft() == null)
					return node.getRight();
				else {
					T max = max(node.getLeft());
					node.setLeft(removeNodeR(node.getLeft(), max));
					node.setInfo(max);
				}
			}
		}
		if (compare < 0) {
			node.setRight(removeNodeR(node.getRight(), clave));
		}

		else if (compare > 0) {
			node.setLeft(removeNodeR(node.getLeft(), clave));
		}
		return updateAndBalanceIfNecesary(node);
	}

	/**
	 * Devuelve la máxima clave por la derecha a partir de un nodo dado
	 * @param node, el nodo a partir del que buscar
	 * @return la clave
	 */
	private T max(AVLNode<T> node) {
		if (node == null)
			return null;
		while(node.getRight()!=null) node = node.getRight();
		return node.getInfo();
	}
	
	/**
	 * Dada una lista que se pasa como parámetro añade a esta todas las claves 
	 * del Árbol
	 */
	public void getElements(List<T> list) {
		getElementsR(raiz, list);
	}
	
	private void getElementsR(AVLNode<T> node, List<T> elements) {
		if(node==null)	return;
		else	{
			elements.add(node.getInfo());
			getElementsR(node.getLeft(), elements);
			getElementsR(node.getRight(), elements);
		}
	}
}
