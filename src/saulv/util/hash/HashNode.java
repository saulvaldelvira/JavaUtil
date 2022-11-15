package saulv.util.hash;

public class HashNode <T> {
	public static final int BORRADO = -1;
	public static final int VACIO = 0;
	public static final int LLENO = 1;
	private T info;
	private int estado;
	
	/**
	 * Constructor de un nodo Hash. <br>
	 * Inicialmente la información es {@code null} y el estado es {@link #VACIO}
	 */
	public HashNode() {
		info = null;
		estado = VACIO;
	}
	
	/**
	 * Devuelve la informacion que contiene el nodo
	 * @return {@link #info}, de tipo genérico T
	 */
	public T getinfo() {
		return info;
	}
	
	/**
	 * Establece el valor de la información y cambia el estado a lleno
	 * @param elemento, el valor que asignar a info
	 */
	public void setInfo(T elemento) {
		this.info = elemento;
		this.estado = LLENO;
	}
	
	/**
	 * Cambia el estado del nodo a BORRADO
	 * @implSpec Este método no elimina la información del nodo, solo cambia 
	 * 			 el estado a BORRADO
	 */
	public void remove() {
		this.estado = BORRADO;
	}
	
	/**
	 * Devuelve el estado del nodo
	 * @return El estado, de tipo int. <br> Puede ser {@link #BORRADO}, {@link #VACIO} o {@link #LLENO}
	 */
	public int getStatus() {
		return estado;
	}
	
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder("{");
		switch(getStatus()){
			case LLENO:
				cadena.append(info.toString());
				break;
			case VACIO:
				cadena.append("_E_");
				break;
			case BORRADO:
				cadena.append("_D_");
		}
		cadena.append("}");
		return cadena.toString();
	}
}
