package saulv.util.hash;

/**
 * Tabla Hash abstracta. 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 15/12/2021
 *
 * @param <T> (tipo genérico)
 */
public abstract class AbstractHash<T> {
	//CABECERAS DE MÉTODOS
	abstract public int getNumOfElements();
	abstract public int getSize();
	abstract public int add(T elemento);
	abstract public T find(T elemento);
	abstract public int remove(T elemento);
	abstract public String toString();
	
	//MÉTODOS COMUNES
	protected int fHash(T elemento) {
		int pos = elemento.hashCode()%getSize();
		if (pos < 0) return pos+getSize();
		else return pos;
	}

	/**
	 * Devuelve true si el número pasado como parámetro es un número primo
	 * @param numero, el numero. De tipo int
	 * @return true si es primo, false en caso contrario
	 */
	protected boolean isPositivePrime(int numero) {
		for (int i = 2; i < numero; ++i)
			if(numero % i == 0) return false;
		return true;
	}
	
	/**
	 * Dado un numero pasado como parámetro, devuelve el siguiente número primo a este
	 * @param numero, tipo int
	 * @return el siguiente número primo a este, de tipo int
	 */
	protected int nextPrimeNumber(int numero) {
		while(!isPositivePrime(++numero));
		return numero;
	}
	
	/**
	 * Dado un numero pasado como parámetro, devuelve el número primo anterior a este
	 * @param numero, tipo int
	 * @return el número primo anterior a este, de tipo int
	 */
	protected int previousPrimeNumber(int numero) {
		while(!isPositivePrime(--numero));
		return numero;
	}
}
