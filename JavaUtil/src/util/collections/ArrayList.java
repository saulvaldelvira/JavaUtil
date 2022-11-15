package util.collections;



import java.util.Iterator;

import util.checks.ArgumentChecks;
import util.checks.IllegalStateChecks;
import util.checks.IndexChecks;
import util.checks.NoSuchElementChecks;

/**
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 21/03/2021
 *
 */
public class ArrayList<T> extends AbstractList<T> implements List<T> {

	private final static int INITIAL_CAPACITY = 20;
	
	private T[] elements;
	/**
	 * Construye un objeto ArrayList con un tamaño inicial determinado
	 * @param capacity, de tipo int
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		elements=(T[]) new Object[capacity];
		numberOfElements = 0;
	}
	
	/**
	 * Cosntructor por defecto de un ArrayList
	 * el tamaño inicial es de 20
	 */
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	/**
	 * Genera una copia de la lista pasada como parámetro 
	 * @param list, de tipo List<T>
	 */
	public ArrayList(List<T> list) {
		this();
		for(T obj: list) {
			this.add(obj);
		}
	}
	
	/**
	 * Añade el objeto pasado como parámetro a la ultima posicion de la lista
	 * 
	 * @param o, de tipo Object
	 */
	@Override
	public boolean add(T element) {
		ArgumentChecks.isTrue(element!=null, "El parámetro element no puede ser null");
		if (size() >= elements.length) {
			moreMemory(size()+1);
		}
		elements[size()] = element;
		numberOfElements++;
		return true;
	}

	/**
	 * Aumenta el tamaño de elements en caso de que hiviera falta contener mas 
	 * Objetos en el
	 * 
	 * @param numElem, el numero de elementos que necesitara almacenar, como mínimo
	 * el nuevo Array elements 
	 */
	private void moreMemory(int numElem) {
		if (numElem > elements.length) {
		@SuppressWarnings("unchecked")
		T[] aux = (T[]) new Object[Math.max( numElem,
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
	public boolean remove(T o) {
		ArgumentChecks.isNotNull(o);
		
		if(indexOf(o)==-1) {
			return false;
		}else{
			remove(indexOf(o));
			return true;
		}
		
	}

	/**
	 * Elimina todos los elementos de la lista
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		elements=(T[]) new Object[INITIAL_CAPACITY];
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
		
		return elements[index];
	}

	/**
	 * Establece el valor del objeto almacenado en la posicion dada como parámetro, como 
	 * el objeto pasado como parámetro 
	 * @param index, la posicion. De tipo int
	 * @param element, el elemento que sustituirá al de la posicion index
	 * 
	 * @return el objeto que había en la posicon index antes del cambio
	 */
	@Override
	public T set(int index, T element) {
		ArgumentChecks.isTrue(element!=null, "El parametro element no puede ser nulo");
		IndexChecks.isTrue(!(index < 0 || index >= size()), "El parametro index debe estar en los limites de la lista");
		
		T obj = elements[index];
		elements[index]=element;
		return obj;
	}

	/**
	 * Añade en la posicion dada como parámetro el objeto dado como parámetro. 
	 * @param index, la posicion. De tipo int
	 * @param element, el elemento a añadir. De tipo Object
	 */
	@Override
	public void add(int index, T element) {
		ArgumentChecks.isTrue(element!=null, "El parámetro element no puede ser nulo");
		IndexChecks.isTrue(!(index < 0 || index > size()), "El parametro index debe estar en los limites de la lista");
		
		for(int i=size(); i>index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		numberOfElements++;

	}

	/**
	 * Elimina el objeto que se encuentre en la posición dada como parámetro y mueve 
	 * los elementos siguientes una posicion a la izquierda 
	 * 
	 * @param index, la posicion. De tipo int
	 * @return el objeto eliminado, de tipo Object
	 */
	@Override
	public T remove(int index) {
		IndexChecks.isTrue(!(index < 0 || index >= size()), "El parametro index debe estar en los limites de la lista");
		
		T value = elements[index];
		for(int j=index; j<size()-1; j++)
			elements[j] = elements[j+1];
		elements[size()]=null;
		numberOfElements--;
		return value;

	}

	@Override
	public int hashCode() {
		int result = 1;
		for (T e : elements) {
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
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<T>{
		private int nextPos=0;
		private T next=null;
		
		@Override
		public boolean hasNext() {
			return nextPos<size();
		}

		@Override
		public T next() {
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
	

}
