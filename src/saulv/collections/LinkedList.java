package saulv.collections;

import java.util.Iterator;

import saulv.util.checks.ArgumentChecks;
import saulv.util.checks.IllegalStateChecks;
import saulv.util.checks.IndexChecks;
import saulv.util.checks.NoSuchElementChecks;

/**
 * 
 * @author Saúl Valdelvira Iglesias
 * @version 21/03/2021
 *
 */
public class LinkedList<T> extends AbstractList<T> implements List<T> {

	private class Node {
		T value;
		Node next;
		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private Node head;
	private int numberOfElements;
	
	/**
	 * Cosntrucor de una linked list
	 */
	public LinkedList() {
		head=null;
		numberOfElements=0;
	}
	
	/**
	 * Genera una copia de la lista pasada como parámetro 
	 * @param list, de tipo List<T>
	 */
	public LinkedList(List<T> list) {
		this();
		for(T obj: list) {
			this.add(obj);
		}
	}
	
	
	/**
	 * Devuelve el tamaño de la lista, es decir, el número de elementos
	 * que almacena
	 * 
	 * @return el número de elementos, de tipo int
	 */
	@Override
	public int size() {
		return numberOfElements;
	}

	/**
	 * Devuelve true si está vacía, es decir, si no almacena ningún objeto 
	 * 
	 * @return truo o false, de tipo boolean 
	 */
	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	/**
	 * Devuelve true si la lista contiene al menos un objeto tal que 
	 * *ese objeto*.equals(obj) sea true
	 * @param obj, de tipo Object
	 * @return true o false, boolean 
	 */
	@Override
	public boolean contains(T obj) {
		ArgumentChecks.isTrue(obj!=null, "El objeto a buscar no puede ser null");
		
		return indexOf(obj)!=- 1;
	}

	/**
	 * Añade el objeto pasado como parámetro a la ultima posicion de la lista
	 * en caso de no haber ningun elemento, delega esta accion la método 
	 * addFirst()
	 * 
	 * @param element, de tipo Object
	 */
	@Override
	public boolean add(T element) {
		ArgumentChecks.isTrue(element!=null, "El parámetro element no puede ser nulo");
		
		if (head==null)
			this.addFirst(element);
		else {
			Node last = getNode(size()-1);
			last.next = new Node(element, null);
			numberOfElements++;
		}
		return get(size()-1)==element;
		
	}

	/**
	 * Añade el primer elemento de la lista, creando un nodo, que se asocia a head
	 * 
	 * @param element, de tipo Object
	 */
	private void addFirst(T element) {
		head = new Node(element, head);
		numberOfElements++;		
	}

	/**
	 * Elimina un Objeto de la lista y devuelve true, en caso de que se produca 
	 * algun cambio en la lista, o false en su defecto 
	 */
	@Override
	public boolean remove(T obj) {
		ArgumentChecks.isTrue(obj!=null, "El parámetro element no puede ser nulo");
		
		int pos = indexOf(obj);
		if(pos==-1) {
			return false;
		}else {
			remove(pos);
			return true;
		}
	}


	/**
	 * Elimina todos los elementos de la lista
	 */
	@Override
	public void clear() {
		head=null;
		numberOfElements=0;

	}

	/**
	 * Devuelve el objeto que se encunentra en la posicion dada como parámetro 
	 * 
	 * @param index, la posicion, de tipo int 
	 * @return el objeto que se encuentra en dicha posicion, de tipo Object
	 */
	@Override
	public T get(int index) {
		IndexChecks.isTrue(!(index < 0 || index >= size()), "El parametro index debe estar en los limites de la lista");
		
		return getNode(index).value;
	}

	/**
	 * Establece el valor del objeto almacenado en la posicion dada como parámetro, como 
	 * el objeto pasado como parámetro 
	 * @param index, la posicion. De tipo int
	 * @param value, el elemento que sustituirá al de la posicion index
	 * 
	 * @return el objeto que había en la posicon index antes del cambio
	 */
	@Override
	public T set(int index, T value) {
		IndexChecks.isTrue(!(index < 0 || index >= size()), "El parametro index debe estar en los limites de la lista");
		
		T aux=getNode(index).value;
		getNode(index).value = value;
		return aux;
	}

	/**
	 * Añade en la posicion dada como parámetro el objeto dado como parámetro. 
	 * @param index, la posicion. De tipo int
	 * @param element, el elemento a añadir. De tipo Object
	 */
	@Override
	public void add(int index, T element) {
		ArgumentChecks.isTrue(element!=null, "El parametro element no puede ser nulo");
		IndexChecks.isTrue(!(index < 0 || index > size()), "El parametro index debe estar en los limites de la lista");
		
		if (index==0)
			addFirst(element);
		else {
			Node previous = getNode(index-1);
			previous.next = new Node(element, previous.next);
			numberOfElements++;
		}

	}

	/**
	 * Elimina el objeto que se encuentre en la posición dada como parámetro y mueve 
	 * los elementos siguientes una posicion a la izquierda 
	 * 
	 * @param pos, la posicion. De tipo int
	 * @return el objeto eliminado, de tipo Object
	 */
	@Override
	public T remove(int pos) {
		IndexChecks.isTrue(!(pos < 0 || pos >= size()), "El parametro index debe estar en los limites de la lista");
		
		T value;
		if(pos==0) {
			value=head.value;
			head=head.next;
		}else {
			Node previous=getNode(pos-1);
			value=previous.next.value;
			previous.next=previous.next.next;
		}
		numberOfElements--;
		return value;
	}

	private Node getNode(int index) {
		Node aux = this.head;
		for(int i=0; i<index ;i++) {
			aux = aux.next;
		}
		return aux;
	}
		 
	
	/**
	 * Devuelve la posicion de un objeto dado como parámetro en la lista, o -1 
	 * si no se encuentra en esta
	 * 
	 * @param o, el objeto a buscar. De tipo Object
	 */
	@Override
	public int indexOf(Object o) {
		Node aux=head;
		int i=0;
		while(aux!=null  && !aux.value.equals(o)) {
			aux=aux.next;
			i++;
		}
		return aux==null? -1: i;
	}

	@Override
	public int hashCode() {
		int result = 1;
		for(int i=0; i<numberOfElements; i++) {
			if(getNode(i).value!=null)
				result = 31 * result + (getNode(i).value == null ? 0 : getNode(i).value.hashCode());
		}
		return result;
	}

	/**
	 * Devuelve true si el objeto pasado como parámetro es una lista de igual tamaño
	 * y con los mismos elementos en las mismas posiciones que esta lista 
	 * 
	 * @param obj, el objeto a comparar. De tipo Object
	 * @return true o false. Boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof List))
			return false;
		@SuppressWarnings("unchecked")
		List<T> other = (List<T>) obj;
		if (numberOfElements != other.size())
			return false;
		for(int i=0; i<size(); i++) {
			if(! this.get(i).equals(other.get(i)))
				return false;
		}
		return true;
	}

	/**
	 * Devuelve una cadena que reune los toString de los elementos de la lista 
	 * de la siguiente forma
	 * [*toString del elemento1*, *toString del elemento2, etc...]
	 */
	@Override
	public String toString() {
		String result= "[";
		for(int i=0;i<size();i++) {
			if(i<size()-1)
				result=result+getNode(i).value.toString()+", ";
			else {
				result=result+getNode(i).value.toString();
			}				
		}
		return result+"]";
	}

	
	
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
			
	private class LinkedListIterator implements Iterator<T>{
		private Node next = head;
		private Node lastReturned=null;
		private int nextPos=0;
		
		@Override
		public boolean hasNext() {
			return next!=null;
		}
		
		@Override
		public T next() {
			NoSuchElementChecks.isTrue(hasNext());
			
			lastReturned=next;
			next=next.next;
			nextPos++;
			return lastReturned.value;
		}
		
		/**
		 * Elimina el elemento anterior
		 */
		public void remove() {
			IllegalStateChecks.isTrue(lastReturned!=null, "No hay elemento que se pueda eliminar");
			LinkedList.this.remove(nextPos-1);
			nextPos--;
			lastReturned=null;
		}
		
	}
}
		




	