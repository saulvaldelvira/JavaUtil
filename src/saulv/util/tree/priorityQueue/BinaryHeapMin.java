package saulv.util.tree.priorityQueue;

public class BinaryHeapMin <T extends Comparable<T>> implements PriorityQueue<T> {
	private T[] monticulo;
	private int numElementos;
	
	/**
	 * Constructor de un monticulo de m�nimos de dimensi�n n
	 * @param n, el tama�o del mont�culo
	 */
	@SuppressWarnings("unchecked")
	public BinaryHeapMin (int n) {
		monticulo = (T[]) new Comparable[n];
		numElementos=0;
	}
	
	/**
	 * A�ade un elemento al mont�culo
	 * @return 
	 * 		*-2 si el elemento a a�adir es nulo
	 * 		*-1 si el monticulo est� lleno
	 * 		* 0 si a�ade el elemento correctamente
	 */
	@Override
	public int add(T elemento) {
		if(elemento==null)	return -2;
		if(numElementos==monticulo.length)	return -1;
		monticulo[numElementos]=elemento;
		numElementos++;
		filtradoAscendente(numElementos-1);
		return 0;
	}

	/**
	 * Saca el primer elemento del momt�culo (posisici�n 0)
	 * @return el elemento, de tipo gen�rico T
	 */
	@Override
	public T sacar() {
		if(isEmpty())	return null;
		T elemento = monticulo[0];
		monticulo[0] = monticulo[numElementos-1];
		monticulo[numElementos-1]=null;
		numElementos--;
		filtradoDescendente(0);
		return elemento;
	}

	/**
	 * Elimina el elemento especificado como par�metro
	 * @param elemento, el elemento a eliminar del mont�culo
	 * @return 
	 * 		*-2 si el elemento a eliminar es nulo o no hay elementos en el monticulo
	 * 		*-1 si el elemento no existe en el monticulo
	 * 		* 0 si se elimina el elemento correctamente
	 */
	@Override
	public int remove(T elemento) {
		if(elemento==null || isEmpty())	return -2;
		for(int i=0; i<monticulo.length; i++) {
			if(monticulo[i].compareTo(elemento)==0) {
				monticulo[i] = monticulo[numElementos-1];
				monticulo[numElementos-1]=null;
				numElementos--;
				filtradoDescendente(i);
				return 0;
			}
		}
		return -1;
	}

	/**
	 * Devuelve si el mont�culo esta vac�o
	 * @return true si est� vac�o, false en caso contrario
	 */
	@Override
	public boolean isEmpty() {
		return numElementos==0;
	}

	/**
	 * Vac�a el mont�culo de elementos
	 */
	@Override
	public void clear() {
		for(int i = 0; i<monticulo.length; i++)	
			monticulo[i] = null;
		numElementos=0;
	}

	/**
	 * Cambia la prioridad del elemento en la posicion dada como par�metro por 
	 * el elemento espceificado. Despu�s realiza un filtrado a partir de dicha posici�n;
	 * @param pos, la posici�n
	 * @param elemento, el elemento para sustituir
	 * @return 
	 * 		* 0 si se sustituye correctamente
	 * 		*-1 si el elemento en la posicion dada y el elemento pasado como par�metro son iguales
	 * 		*-2 si la posicion es 
	 */
	@Override
	public int cambiarPrioridad(int pos, T elemento) {
		if(pos<0||elemento==null||pos>=numElementos) return -2;
		int compare = monticulo[pos].compareTo(elemento);
		monticulo[pos]=elemento;
		if(compare<0)
			filtradoDescendente(pos);
		else if(compare>0)
			filtradoAscendente(pos);
		else	return -1;
		return 0;
	}

	/**
	 * Realiza un filtrado ascendente del mont�culo. Si el elemento en la 
	 * posici�n dada es menor que su padre, los intercambia. Sigue as� hasta
	 * llegar a la ra�z 
	 * @param pos, la posici�n de inicio del filtrado.
	 */
	private void filtradoAscendente(int pos) {
		while(pos>0) {
			T padre = monticulo[(pos-1)/2];
			if(padre.compareTo(monticulo[pos])>0) {
				monticulo[(pos-1)/2] = monticulo[pos];
				monticulo[pos] = padre;
			}
			pos--;
		}
	}
	
	/**
	 * Realiza un filtrado descendente del mont�culo partiendo de la posici�n 
	 * dada como par�metro. Si el elemento en una posici�n i del monticulo es 
	 * mayor que alguno de sus hijos, los intercambia. En caso de ser mayor que 
	 * ambos, se intercambia por el menor de los dos. 
	 * @param pos, la posici�n de inicio.
	 */
	private void filtradoDescendente(int pos) {
		while (pos<numElementos) {
			T padre = monticulo[pos];
			T hijoIzda = getElement(pos*2 + 1);
			T hijoDcha = getElement(pos*2 + 2);
			if(hijoDcha==null) {
				if(hijoIzda==null) {
					pos++;
					continue;
				}
				if(hijoIzda.compareTo(padre)<0) {
					monticulo[pos*2 +1]=padre;
					monticulo[pos] = hijoIzda;
				}
			}else if(hijoIzda==null) {
				if(hijoDcha.compareTo(padre)<0) {
					monticulo[pos*2 +2]=padre;
					monticulo[pos] = hijoDcha;
				}
			}
			else {
				int compareIzda = padre.compareTo(hijoIzda);
				int compareDcha = padre.compareTo(hijoDcha);
				if(compareIzda>0) {
					if(compareDcha>0) {
						int compare = hijoDcha.compareTo(hijoIzda);
						if(compare<0) {
							monticulo[pos*2 + 2] = padre;
							monticulo[pos] = hijoDcha;
						}else {
							monticulo[pos*2 + 1] = padre;
							monticulo[pos] = hijoIzda;
						}
					}
				}else if(compareDcha>0) {
					monticulo[pos*2 + 2] = padre;
					monticulo[pos] = hijoDcha;
				}
			}
			pos++;
		}
	}
	
	private T getElement(int pos) {
		return pos<0 || pos>=numElementos? null: monticulo[pos];
	}
	
	public String toString() {
		String result = "";
		for(int i=0; i<numElementos; i++) {
			result += monticulo[i].toString();
			result += i!=numElementos-1?"\t" : "";
		}
		return result;
	}
	
}
