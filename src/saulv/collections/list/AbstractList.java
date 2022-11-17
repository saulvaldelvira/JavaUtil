package saulv.collections.list;

import java.util.List;

import saulv.collections.Util;
import saulv.util.checks.ArgumentChecks;

public abstract class AbstractList<E> implements List<E>{

	protected int numberOfElements;

	public AbstractList() {
		super();
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
		return indexOf(Util.castToE(o))!=- 1;
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
			if(this.get(i).equals(Util.castToE(o))) {
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
	
}