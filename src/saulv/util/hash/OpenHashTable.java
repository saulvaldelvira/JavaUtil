package saulv.util.hash;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import saulv.util.tree.avl.*;


/**
 * Tabla Hash abierta. 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 15/12/2021
 *
 * @param <T> (tipo genérico)
 */
public class OpenHashTable<T extends Comparable<T>> extends AbstractHash<T> {
	//Umbrales
	public static final double MINIMUN_LF = 0.16;
	public static final double MAXIMUN_LF = 0.5;
	///
	private int numElementos;
	private AVLTree<T> tabla[];
	private double minlf;
	private double maxlf;
	
	/**
	 * Constructor de una tabla hash abierta 
	 * @param tam, el tamaño de la tabla.
	 */
	@SuppressWarnings("unchecked")
	public OpenHashTable(int tam) {
		numElementos = 0;
		minlf = MINIMUN_LF;
		maxlf = MAXIMUN_LF;
		if(!isPositivePrime(tam))	tam=nextPrimeNumber(tam);
		tabla = (AVLTree<T>[]) Array.newInstance(saulv.util.tree.avl.AVLTree.class, tam);
		for(int i=0; i<tam; i++)
			tabla[i] = new AVLTree<T>();
	}
	
	/**
	 * Constructor de una tabla hash abierta 
	 * @param tam, el tamaño de la tabla.
	 * @param min el valor minimo para el factor de carga
	 * @param max el valor máximo para el factor de carga
	 */
	@SuppressWarnings("unchecked")
	public OpenHashTable(int tam, int min, int max) {
		numElementos = 0;
		minlf = min;
		maxlf = max;
		if(!isPositivePrime(tam))	tam=nextPrimeNumber(tam);
		tabla = (AVLTree<T>[]) Array.newInstance(saulv.util.tree.avl.AVLTree.class, tam);
		for(int i=0; i<tam; i++)
			tabla[i] = new AVLTree<T>();
	}
	
	/**
	 * Devuelve el factor de carga de la tabla
	 * @return el factor da carga, tipo double
	 */
	private double getLoadFactor() {
		return (double) numElementos/tabla.length;
	}
	
	/**
	 * Devuelve el número de elementos de la tabla
	 * @return numberOfElements, de tipo int
	 */
	@Override
	public int getNumOfElements() {
		return numElementos;
	}

	/**
	 * Devuelve el tamaño de la tabla
	 * @return el tamaño, de tipo int
	 */
	@Override
	public int getSize() {
		return tabla.length;
	}

	/**
	 * Añade un elemento a la tabla. Busca su posición usando el método fHash 
	 * para encontrar la posición donde añadirlo y llamando al método add del 
	 * arbol AVL en dicha posición.
	 * En caso de ser necesario, invoca al método redispersion(), que aumenta el 
	 * tamaño de la tabla.
	 * @return 
	 * 		* 0 si añade el elemento correctamente
	 * 		*-1 si no consigue añadir el elemento
	 * 		*-2 si el elemento pasado como parámetro es null
	 */
	@Override
	public int add(T elemento) {
		if(elemento == null) return -2;
		int pos = fHash(elemento);
		tabla[pos].addNode(elemento);
		numElementos++;
		if(getLoadFactor()>=maxlf)	redispersion();
		return 0;
	}

	/**
	 * Aumenta el tamaño de la tabla. El nuevo tamaño es el doble del actual, o
	 * en caso de no ser primo, el número primo siguiente a ese.
	 */
	@SuppressWarnings("unchecked")
	private void redispersion() {
		List<T> elements = new ArrayList<T>();
		for(AVLTree<T> t: tabla)
			t.getElements(elements);
		
		int tam = tabla.length*2;
		if(!isPositivePrime(tam))	tam = nextPrimeNumber(tam);
		tabla = (AVLTree<T>[]) Array.newInstance(AVLTree.class, tam);
		numElementos = 0;
		for(int i=0; i<tam; i++)
			tabla[i]=new AVLTree<T>();
		
		for(T e: elements)
			add(e);
		
	}
	
	/**
	 * Busca en la tabla un elemento. 
	 * @param elemento, el elemento a buscar. Si es null, el método devolverá null
	 * @return el elemento en caso de encontralo y estar LLENO o null en cualquier
	 * otro caso
	 */
	@Override
	public T find(T elemento) {
		if(elemento == null) return null;
		int pos = fHash(elemento);
		AVLNode<T> node = tabla[pos].searchNode(elemento);
		if(node==null)	return null;
		else return node.getInfo();
	}

	/**
	 * Elimina un elemento de la tabla
	 * @param el elemento a borrar
	 * @return 
	 * 		* 0 si elimina el elemento correctamente
	 * 		*-1 si no consigue eliminar el elemento
	 * 		*-2 si el elemento pasado como parámetro es null
	 */
	@Override
	public int remove(T elemento) {
		if(elemento == null) return -2;
		int pos = fHash(elemento);
		tabla[pos].removeNode(elemento);
		numElementos--;
		if(getLoadFactor()<=minlf)	redispersionInversa();
		return 0;
	}
	
	/**
	 * Disminuye el tamaño de la tabla a la mitad, o al anterior número primo 
	 * caso de no serlo.
	 */
	@SuppressWarnings("unchecked")
	private void redispersionInversa() {
		List<T> elements = new ArrayList<T>();
		for(AVLTree<T> t: tabla)
			t.getElements(elements);
		
		int tam = tabla.length/2;
		if(!isPositivePrime(tam))	tam = previousPrimeNumber(tam);
		tabla = (AVLTree<T>[]) Array.newInstance(AVLTree.class, tam);
		numElementos = 0;
		for(int i=0; i<tam; i++)
			tabla[i]=new AVLTree<T>();
		
		for(T e: elements)
			add(e);
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		for(int i=0;i< getSize();i++){
			cadena.append(tabla[i].toString());
			cadena.append(";");
		}
		cadena.append("[Size: ");
		cadena.append(getSize());
		cadena.append(" Num.Elems.: ");
		cadena.append(getNumOfElements());
		cadena.append("]");
		return cadena.toString();
	}

}
