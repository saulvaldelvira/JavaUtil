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
public class ArrayList<E> extends AbstractList<E> implements List<E> {

	private final static int INITIAL_CAPACITY = 20;
	
	private E[] elements;
	/**
	 * Construye un objeto ArrayList con un tama?o inicial determinado
	 * @param capacity, de tipo int
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		elements=(E[]) new Object[capacity];
		numberOfElements = 0;
	}
	
	/**
	 * Cosntructor por defecto de un ArrayList
	 * el tama?o inicial es de 20
	 */
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	/**
	 * Genera una copia de la lista pasada como par?metro 
	 * @param list, de tipo List<T>
	 */
	public ArrayList(List<E> list) {
		this();
		for(E obj: list) {
			this.add(obj);
		}
	}
	
	/**
	 * A?ade el objeto pasado como par?metro a la ultima posicion de la lista
	 * 
	 * @param o, de tipo Object
	 */
	@Override
	public boolean add(E element) {
		//if(!permitNull)
			ArgumentChecks.isNotNull(element);
		checkMemory();
		elements[size()] = element;
		numberOfElements++;
		return true;
	}

	private void checkMemory() {
		if (size() >= elements.length)
			moreMemory(size()+1);
	}
	
	/**
	 * Aumenta el tama?o de elements en caso de que hiviera falta contener mas 
	 * Objetos en el
	 * 
	 * @param numElem, el numero de elementos que necesitara almacenar, como m?nimo
	 * el nuevo Array elements 
	 */
	private void moreMemory(int numElem) {
		if (numElem > elements.length) {
		@SuppressWarnings("unchecked")
		E[] aux = (E[]) new Object[Math.max( numElem,
								2*elements.length)];
		System.arraycopy(elements, 0, aux, 0, elements.length);
		elements=aux;
		}
	}
	
	/**
	 * Elimina un Objeto de la lista y devuelve true, en caso de que se produca 
	 * algun cambio en la lista, o false en su defecto 
	 */
	@Override
	public boolean remove(Object o) {
		ArgumentChecks.isNotNull(o);
		if(indexOf(Util.castAs(o))==-1) {
			return false;
		}else{
			remove(indexOf(Util.castAs(o)));
			return true;
		}
		
	}

	/**
	 * Elimina todos los elementos de la lista
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		elements=(E[]) new Object[INITIAL_CAPACITY];
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
		
		return elements[index];
	}

	/**
	 * Establece el valor del objeto almacenado en la posicion dada como par?metro, como 
	 * el objeto pasado como par?metro 
	 * @param index, la posicion. De tipo int
	 * @param element, el elemento que sustituir? al de la posicion index
	 * 
	 * @return el objeto que hab?a en la posicon index antes del cambio
	 */
	@Override
	public E set(int index, E element) {
		ArgumentChecks.isTrue(element!=null, "El parametro element no puede ser nulo");
		IndexChecks.isTrue(!(index < 0 || index >= size()), "El parametro index debe estar en los limites de la lista");
		
		E obj = elements[index];
		elements[index]=element;
		return obj;
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
		numberOfElements++;
		checkMemory();
		for(int i=size()-1; i>=index; i--)
			elements[i+1] = elements[i];
		elements[index] = element;

	}

	/**
	 * Elimina el objeto que se encuentre en la posici?n dada como par?metro y mueve 
	 * los elementos siguientes una posicion a la izquierda 
	 * 
	 * @param index, la posicion. De tipo int
	 * @return el objeto eliminado, de tipo Object
	 */
	@Override
	public E remove(int index) {
		IndexChecks.isTrue(!(index < 0 || index >= size()), "El parametro index debe estar en los limites de la lista");
		
		E value = elements[index];
		for(int j=index; j<size(); j++)
			elements[j] = elements[j+1];
		elements[size()]=null;
		numberOfElements--;
		return value;

	}

	@Override
	public int hashCode() {
		int result = 1;
		for (E e : elements) {
			if(e!=null)
				result = 31 * result + (e == null ? 0 : e.hashCode());
		}
		return result;
		
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
				result=result+elements[i].toString()+", ";
			else {
				result=result+elements[i].toString();
			}				
		}
		return result+"]";
	
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<E>{
		private int nextPos=0;
		private E next=null;
		
		@Override
		public boolean hasNext() {
			return nextPos<size();
		}

		@Override
		public E next() {
			NoSuchElementChecks.isTrue(hasNext());
			
			next=ArrayList.this.get(nextPos);
			nextPos++;
			return next;
		}
		
		/**
		 * Elimina el elemento anterior
		 */
		public void remove() {
			IllegalStateChecks.isTrue(nextPos-1 >=0, "No hay elemento que se pueda eliminar");
			ArrayList.this.remove(nextPos-1);
			nextPos--;
		}
		
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		ArrayList<E> result = new ArrayList<E>();
		while(fromIndex<toIndex)
			result.add( this.get(fromIndex++) );
		return result;
	}

}
