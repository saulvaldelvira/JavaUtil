package saulv.collections.list;

import java.util.Iterator;
import java.util.List;

import saulv.collections.Util;
import saulv.util.checks.ArgumentChecks;
import saulv.util.checks.IllegalStateChecks;
import saulv.util.checks.IndexChecks;
import saulv.util.checks.NoSuchElementChecks;

/**
 * 
 * @author Sa?l Valdelvira Iglesias
 * @version 21/03/2021
 *
 */
public class LinkedList<E> extends AbstractList<E> implements List<E> {

	private class Node {
		E value;
		Node next;
		public Node(E value, Node next) {
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
	 * Genera una copia de la lista pasada como par?metro 
	 * @param list, de tipo List<T>
	 */
	public LinkedList(List<E> list) {
		this();
		for(E obj: list) {
			this.add(obj);
		}
	}
	
	
	/**
	 * Devuelve el tama?o de la lista, es decir, el n?mero de elementos
	 * que almacena
	 * 
	 * @return el n?mero de elementos, de tipo int
	 */
	@Override
	public int size() {
		return numberOfElements;
	}

	/**
	 * Devuelve true si est? vac?a, es decir, si no almacena ning?n objeto 
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
	public boolean contains(Object obj) {
		ArgumentChecks.isNotNull(obj);		
		return indexOf(obj)!=- 1;
	}

	/**
	 * A?ade el objeto pasado como par?metro a la ultima posicion de la lista
	 * en caso de no haber ningun elemento, delega esta accion la m?todo 
	 * addFirst()
	 * 
	 * @param element, de tipo Object
	 */
	@Override
	public boolean add(E element) {
		//if(!permitNull)
			ArgumentChecks.isNotNull(element);
		
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
	 * A?ade el primer elemento de la lista, creando un nodo, que se asocia a head
	 * 
	 * @param element, de tipo Object
	 */
	private void addFirst(E element) {
		head = new Node(element, head);
		numberOfElements++;		
	}

	/**
	 * Elimina un Objeto de la lista y devuelve true, en caso de que se produca 
	 * algun cambio en la lista, o false en su defecto 
	 */
	@Override
	public boolean remove(Object obj) {
		ArgumentChecks.isNotNull(obj);
		
		int pos = indexOf(Util.castAs(obj));
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
	 * Devuelve el objeto que se encunentra en la posicion dada como par?metro 
	 * 
	 * @param index, la posicion, de tipo int 
	 * @return el objeto que se encuentra en dicha posicion, de tipo Object
	 */
	@Override
	public E get(int index) {
		IndexChecks.isTrue(!(index < 0 || index >= size()), "El parametro index debe estar en los limites de la lista");
		
		return getNode(index).value;
	}

	/**
	 * Establece el valor del objeto almacenado en la posicion dada como par?metro, como 
	 * el objeto pasado como par?metro 
	 * @param index, la posicion. De tipo int
	 * @param value, el elemento que sustituir? al de la posicion index
	 * 
	 * @return el objeto que hab?a en la posicon index antes del cambio
	 */
	@Override
	public E set(int index, E value) {
		IndexChecks.isTrue(!(index < 0 || index >= size()), "El parametro index debe estar en los limites de la lista");
		
		E aux=getNode(index).value;
		getNode(index).value = value;
		return aux;
	}

	/**
	 * A?ade en la posicion dada como par?metro el objeto dado como par?metro. 
	 * @param index, la posicion. De tipo int
	 * @param element, el elemento a a?adir. De tipo Object
	 */
	@Override
	public void add(int index, E element) {
		ArgumentChecks.isNotNull(element);
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
	 * Elimina el objeto que se encuentre en la posici?n dada como par?metro y mueve 
	 * los elementos siguientes una posicion a la izquierda 
	 * 
	 * @param pos, la posicion. De tipo int
	 * @return el objeto eliminado, de tipo Object
	 */
	@Override
	public E remove(int pos) {
		IndexChecks.isTrue(!(pos < 0 || pos >= size()), "El parametro index debe estar en los limites de la lista");
		
		E value;
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
	 * Devuelve la posicion de un objeto dado como par?metro en la lista, o -1 
	 * si no se encuentra en esta
	 * 
	 * @param o, el objeto a buscar. De tipo Object
	 */
	@Override
	public int indexOf(Object o) {
		ArgumentChecks.isNotNull(o);
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
	 * Devuelve true si el objeto pasado como par?metro es una lista de igual tama?o
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
		List<E> other = (List<E>) obj;
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
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
			
	private class LinkedListIterator implements Iterator<E>{
		private Node next = head;
		private Node lastReturned=null;
		private int nextPos=0;
		
		@Override
		public boolean hasNext() {
			return next!=null;
		}
		
		@Override
		public E next() {
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
	
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		LinkedList<E> result = new LinkedList<E>();
		while(fromIndex<toIndex)
			result.add( this.get(fromIndex++) );
		return result;
	}

}
		




	