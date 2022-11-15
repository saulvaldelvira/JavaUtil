package saulv.util.tree;


public class Persona implements Comparable<Persona> {
	private int edad;
	private String nombre;
	
	public Persona(int e, String n) {
		edad = e;
		nombre = n;
	}
	
	public Persona(int a) {
		edad = a;
	}
	
	public String toString() {
		return "["+nombre+":"+edad+"]";
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método Compare to de la clase Persona
	 * Compara por edad (prioridad al que tenga mayor edad) 
	 * A igual edad, compara por nombre (alfabéticamente)
	 */
	@Override
	public int compareTo(Persona o) {
		if(edad>o.getEdad())	return 1;
		else if(edad<o.getEdad())	return -1;
		else {
			int shorter = shorterName(nombre, o.getNombre());
			for(int i=0; i<shorter; i++) {
				char c1 = nombre.charAt(i);
				char c2 = o.getNombre().charAt(i);
				if(c1<c2) return 1;
				else if(c2<c1) return -1;
			}
			if(nombre.length()==shorter && o.getNombre().length()==shorter)		return 0;
			else {
				if(nombre.length()<o.getNombre().length())	return 1;
				else return -1;
			}
		}
	}
	
	private int shorterName(String n1, String n2) {
		return n1.length()<n2.length()? n1.length(): n2.length();
	}

}
