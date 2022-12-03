package saulv.collections.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import saulv.collections.Util;
import saulv.util.checks.ArgumentChecks;

public abstract class AbstractList<E> implements List<E>{

	protected int numberOfElements;
	//protected boolean permitNull;
	
	public AbstractList() {
		numberOfElements = 0;
		//permitNull = false;
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
	 * Añade el objeto pasado como parámetro a la ultima posicion de la lista
	 * 
	 * @param o, de tipo Object
	 */
	@Override
	public abstract boolean add(E element);
	
	/**
	 * Devuelve true si está vacía, es decir, si no almacena ningún objeto 
	 * 
	 * @return truo o false, de tipo boolean 
	 */
	@Override
	public boolean isEmpty() {
		return(numberOfElements==0);
	}

	/**
	 * Devuelve true si la lista contiene al menos un objeto tal que 
	 * *ese objeto*.equals(o) sea true
	 * @param o, de tipo Object
	 * @return true o false, boolean 
	 */
	@Override
	public boolean contains(Object o) {
		ArgumentChecks.isNotNull(o);
		return indexOf(Util.castAs(o))!=- 1;
	}

	/**
	 * Devuelve la posicion de un objeto dado como parámetro en la lista, o -1 
	 * si no se encuentra en esta
	 * 
	 * @param o, el objeto a buscar. De tipo Object
	 */
	@Override
	public int indexOf(Object o) {
		ArgumentChecks.isNotNull(o);
		for(int i=0; i<this.size();i++) {
			if(this.get(i).equals(Util.castAs(o))) {
				return i;
			}
		}
		return -1;
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
		List<E> other = (List<E>) obj;
		if (numberOfElements != other.size())
			return false;
		for(int i=0; i<size(); i++) {
			if(! this.get(i).equals(other.get(i)))
				return false;
		}
		return true;
	}
	
	@Override
	public Object[] toArray() {
		Object[] result = new Object[size()];
		for(int i=0; i<size(); i++)
			result[i]=get(i);
		return result;
	}
	
	@Override
	public <T> T[] toArray(T[] a) {
		T[] result;
		if(a.length<size())
			result = Util.castAs(new Object[size()]);
		else result = a;
		
		for(int i=0; i<size(); i++)
			result[i] = Util.castAs(get(i));
		
		if(result.length>size())
			result[size()] = null;
		return result;
		
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		Iterator<?> iterator = c.iterator();
		while(iterator.hasNext())
			if(!contains(iterator.next()))
				return false;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		Iterator<?> iterator = c.iterator();
		while(iterator.hasNext())
			add(Util.castAs(iterator.next()));
		return true;
	}

	//TODO: For now it adds the backwards
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		Iterator<?> iterator = c.iterator();
		while(iterator.hasNext())
			add(index, Util.castAs(iterator.next()));
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		Iterator<?> iterator = c.iterator();
		while(iterator.hasNext())
			remove(iterator.next());
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		for(int i=0; i<size(); i++)
			if(!c.contains(get(i)))
				remove(i);
		return true;
	}
	
	@Override
	public int lastIndexOf(Object o) {
		ArgumentChecks.isNotNull(o);
		int result = -1;
		for(int i=0; i<this.size();i++) {
			if(this.get(i).equals(Util.castAs(o))) {
				result = i;
			}
		}
		return result;
	}
	
	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}