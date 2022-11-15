package saulv.util.hash;

import java.lang.reflect.Array;

/**
 * Tabla Hash cerrada. 
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 15/12/2021
 *
 * @param <T> (tipo genérico)
 */
public class ClosedHashTable<T> extends AbstractHash<T> {
	//Umbrales
	public static final double MINIMUN_LF = 0.16;
	public static final double MAXIMUN_LF = 0.5;
	//
	public static final int EXPLORACION_LINEAL = 1;
	public static final int EXPLORACION_CUADRATICA = 2;
	public static final int EXPLORACION_DISPERSION_DOBLE = 3;
	private int numElementos;
	private HashNode<T> tabla[];
	private int tipoExploracion;
	private double minlf;
	private double maxlf;
	
	/**
	 * Constructor de una tabla Hash cerrada. Los valores minimo y máximo para
	 * el factor de carga se establecen según las dos constantes definidas.
	 * @param tam, el tamaño de la tabla. De tipo int
	 * @param tipo, el tipo de exploracion. De tipo int
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, int tipo) {
		numElementos = 0;
		tipoExploracion = tipo;
		if(!isPositivePrime(tam))
			tam = nextPrimeNumber(tam);
		tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		for (int i=0; i<tam; i++)	
			tabla[i] = new HashNode<T>();
		minlf = MINIMUN_LF;
		maxlf = MAXIMUN_LF;
	}
	
	/**
	 * Constructor de una tabla Hash cerrada
	 * @param tam, el tamaño de la tabla. De tipo int
	 * @param tipo, el tipo de exploracion. De tipo int
	 * @param min, el factor de carga mínimo de la tabla
	 * @param max, el factor de carga máximo de la tabla
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTable(int tam, int tipo, double min, double max) {
		numElementos = 0;
		tipoExploracion = tipo;
		if(!isPositivePrime(tam))
			tam = nextPrimeNumber(tam);
		tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		for (int i=0; i<tam; i++)	
			tabla[i] = new HashNode<T>();
		minlf = min;
		maxlf = max;
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
	 * Añade un elemento a la tabla. Busca su posición usando el método fHash de 
	 * forma iterativa hasta que encuentre una posicion libre. 
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
		int intento = 1;
		
		while(tabla[pos].getStatus()==HashNode.LLENO && intento<getSize()) {
			pos = explora(pos, intento, elemento);
			intento++;
		}
		if(tabla[pos].getStatus()!=HashNode.LLENO) {
			tabla[pos].setInfo(elemento);
			numElementos++;
			if(getLoadFactor()>=maxlf)	redispersion();
			return 0;
		}
		
		return -1;
	}
	
	/**
	 * Aumenta el tamaño de la tabla. El nuevo tamaño es el doble del actual, o
	 * en caso de no ser primo, el número primo siguiente a ese.
	 * Deja en la nueva tabla solo los elementos de la antigua que tuvieran el
	 * estado LLENO
	 */
	@SuppressWarnings("unchecked")
	private void redispersion() {
		numElementos=0;
		HashNode<T> aux[] = tabla;
		int tam = tabla.length*2;
		if(!isPositivePrime(tam))	tam=nextPrimeNumber(tam);
		tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		for (int i=0; i<tam; i++)	
			tabla[i] = new HashNode<T>();
		for (HashNode<T> n: aux) {
			if(n.getStatus()==HashNode.LLENO)	
				add(n.getinfo());
		}
	}
	
	/**
	 * Dada una posicion, el número del intento y un elemento, devuelve el 
	 * siguiente valor para pos. 
	 * Esta método se usa en los metodos add y remove. 
	 * @param pos, la posicion
	 * @param intento, el número del intento
	 * @param elemento, el elemento con el que se está trabjando
	 * @return el nuevo valor para pos, de tipo int
	 */
	private int explora(int pos, int intento, T elemento){
		switch(tipoExploracion) {
		case EXPLORACION_LINEAL: 
			pos = fHash(elemento) + intento % getSize(); break;
		case EXPLORACION_CUADRATICA: 
			pos = (fHash(elemento) + (intento*intento)) % getSize(); break;
		case EXPLORACION_DISPERSION_DOBLE:
			pos = (fHash(elemento) + (intento * (previousPrimeNumber(tabla.length) - fHash(elemento) % tabla.length))) % tabla.length; 
			break;
		}
		return pos;
	}

	/**
	 * Busca en la tabla un elemento. 
	 * @param elemento, el elemento a buscar. Si es null, el método devolverá null
	 * @return el elemento en caso de encontralo y estar LLENO o null en cualquier
	 * otro caso
	 */
	@Override
	public T find(T elemento) {
		if(elemento==null) return null;
		int pos = fHash(elemento);
		int intento = 1;
		while(intento<tabla.length) {
			switch(tabla[pos].getStatus()) {
			case HashNode.VACIO: return null;
			case HashNode.LLENO: 
				if(tabla[pos].getinfo().equals(elemento)) return tabla[pos].getinfo();
				break;
			case HashNode.BORRADO:
				if(tabla[pos].getinfo().equals(elemento)) return null;
				break;
			}
			pos = explora(pos, intento, elemento);
			intento++;
		}
		return null;
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
		if(elemento==null) return -2;
		int pos = fHash(elemento);
		int intento = 1;
		while(intento<tabla.length && pos<tabla.length) {
			if(tabla[pos].getStatus()!=HashNode.VACIO) {
				if(tabla[pos].getinfo().equals(elemento)) {
					tabla[pos].remove();
					numElementos--;
					if(getLoadFactor()<=minlf)	redispersionInversa();
					return 0;
				}
			}
			pos = explora(pos, intento, elemento);
			intento++;
		}
		return -1;
	}

	/**
	 * Disminuye el tamaño de la tabla a la mitad, o al anterior número primo 
	 * caso de no serlo.
	 * Deja en la nueva tabla solo los elementos de la antigua que tuvieran el
	 * estado LLENO
	 */
	@SuppressWarnings("unchecked")
	private void redispersionInversa() {
		numElementos=0;
		HashNode<T> aux[] = tabla;
		int tam = tabla.length/2;
		if(!isPositivePrime(tam))	tam=previousPrimeNumber(tam);
		tabla = (HashNode<T>[]) Array.newInstance(HashNode.class, tam);
		for (int i=0; i<tam; i++)	
			tabla[i] = new HashNode<T>();
		for (HashNode<T> n: aux) {
			if(n.getStatus()==HashNode.LLENO)	
				add(n.getinfo());
		}
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
