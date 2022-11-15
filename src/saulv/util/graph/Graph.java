package saulv.util.graph;

import java.text.DecimalFormat;

public class Graph<T> {
	private double[][] weights;
	private boolean[][] edges;
	private T[] nodes;
	private int size;
	private double[][] A;
	private T[][] P;
	private String cadenaDFS;
	
	@SuppressWarnings("unchecked")
	public Graph(int dimension) {
		nodes = (T[]) new Object[dimension];
		weights = new double[dimension][dimension];
		edges = new boolean[dimension][dimension];
		size=0;
	}
	
	public int getSize() {
		return size;
	}
	
	/**
	 * Devuelve la posición del nodo dado como parámetro o -1 en caso de no 
	 * pertenecer al grafo
	 * @param node, el nodo del que se quiere obtener la posición
	 * @return la posición, de tipo int
	 */
	public int getNode(T node) {
		if(node!=null) {
			for(int i=0; i<size; i++) {
				if(nodes[i].equals(node))
					return i;
			}
		}
		return -1;
	}
	
	/**
	 * Devuelve true si el nodo existe en el grafo, o false en caso contrario
	 * @param node, el nodo a comprobar
	 * @return true o false
	 */
	public boolean existNode(T node) {
		if(node!=null) {
			for(int i=0; i<size; i++) {
				if(nodes[i].equals(node))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Elimina una arista entre los dos nodos dados como parámetro
	 * @param source, el nodo origen de la arista a eliminar
	 * @param target, el nodo destino de la arista a eliminar
	 * @return 
	 * 		 0 si se elimina correctamente la arista
	 * 		-1 caso de no existir el nodo origen
	 * 		-2 caso de no existir el nodo destino
	 * 		-3 caso de no existir nunguno de los dos nodos dados
	 * 		-4 en cualaquier otro caso
	 */
	public int removeEdge(T source, T target) {
		int s = getNode(source);
		int t = getNode(target);
		
		if(!existNode(source)) {
			if(!existNode(target))
				return -3;
			else
				return -1;			
		}else if(!existNode(target))
			return -2;
		else if(edges[s][t]) {
			edges[s][t] = false;
			weights[s][t]=0;
			return 0;
		}else 
			return -4;
	}
	
	/**
	 * Elimina el nodo especificado como parámetro
	 * @param node, el nodo a eliminar
	 * @return 0 si se elimina correctamente, -1 en caso contrario
	 */
	public int removeNode(T node) {
		int pos = getNode(node);
		if(pos>=0) {
			--size; //reduce el numero de nodos
			//si el nodo a eliminar es el último, no hace hacer nada más
			//si no, se machaca el nodo a elimianr con la posición del ultimo nodo
			if(pos != size+1) { 
				nodes[pos] = nodes[size];
				
				for (int i=0; i<=size; i++) {
					edges[i][pos] = edges[i][size];
					edges[pos][i] = edges[size][i];
					weights[i][pos] = weights[i][size];
					weights[pos][i] = weights[size][i];
				}
				
				edges[pos][pos] = edges[size][size];
				weights[pos][pos] = weights[size][size];
			} 
			return 0;
		}
		return -1;			
		
	}
	
	/**
	 * Añade un nodo al grafo
	 * @param node, el nodo a añadir
	 * @return
	 * 		 0 si se añade correctamente el nodo
	 * 		-1 si el nodo cabría pero ya existe en el grafo
	 * 		-2 si el nodo no cabe en el grafo
	 * 		-3 si el nodo NO cabría y además ya existe en el grafo
	 * 		-4 en cualquier otro caso
	 */
	public int addNode(T node) {
		if(node != null) {
			if(existNode(node)) {
				if(nodes.length==getSize())
					return -3;
				else
					return -1;
			}else if(nodes.length==getSize()){
				return -2;
			}else {
				nodes[size]=node; 
				for (int i=0; i<getSize(); i++) {
					edges[i][size]=false;
					edges[size][i]=false;
					weights[i][size]=0;
					weights[size][i]=0;
				}
				size++;
				return 0;
			}
		}return -4;
		
	}	
	
	/**
	 * Devuelve si existe una arista entre los nodos especificados
	 * @param source el nodo partida
	 * @param target el nodo destino
	 * @return true si existe la arista, false en caso contrario
	 */
	public boolean existEdge(T source, T target) {
		int s = getNode(source);
		int t = getNode(target);
		if(existNode(source) && existNode(target)) {
			if(s<size && t <size)
				return edges[s][t];
		}
		return false;
	}
	
	/**
	 * Devuelve el peso de la arista entre dos nodos dados
	 * @param source, el nodo origen
	 * @param target, el nodo destino
	 * @return
	 * 		el peso, en caso de existir la arista
	 * 		-1 caso de no existir el nodo origen
	 * 		-2 caso de no existir el nodo destino
	 * 		-3 caso de no existir ninguno de los dos nodos
	 * 		-4 en cualquier otro caso
	 */
	public double getEdge(T source, T target) {
		int s = getNode(source);
		int t = getNode(target);
		if(!existNode(source)) {
			if(!existNode(target))
				return -3;
			else
				return -1;			
		}else if(!existNode(target))
			return -2;
		else if(edges[s][t])
			return weights[s][t];
		else 
			return -4;
	}
	
	/**
	 * Añade una arista al grafo
	 * @param source, el nodo de partida
	 * @param target, el nodo destino
	 * @param weigth, el peso de la arista (debe ser >0)
	 * @return
	 * 		 0 si se añade la arista correctamente
	 * 		-1 caso de no existir el nodo origen
	 * 		-2 caso de no existir el nodo destino
	 * 		-3 caso de no existir ninguno de los dos nodos
	 * 		-4 caso de ya existir una arista entre esos dos nodos
	 * 		-5 en caso contrario
	 */
	public int addEdge(T source, T target, double weigth) {
		int s = getNode(source);
		int t = getNode(target);
		
		if (weigth<=0)
			return -8;
		if(s!=-1 && t != -1) {
			if(!edges[s][t]) {
				edges[s][t] = true;
				weights[s][t]=weigth;
				return 0;
			}else
				return -4;
		}else if(s==-1) {
			if(t==-1)
				return -3;
			return -1;
		}else if(t==-1)
			return -2;
		return -5;
	}

	public Object[] getweigths() {
		return weights;
	}

	public Object[] getEdges() {
		return edges;
	}

	public String toString() { 
		DecimalFormat df = new DecimalFormat("#.##"); 
		String cadena = ""; 
		cadena += "NODOS\n"; 
		for (int i = 0; i < size; i++) { 
			cadena += nodes[i].toString() + "\t"; 
		} 
		cadena += "\n\nARISTAS\n"; 
			for (int i = 0; i < size; i++) { 
				for (int j = 0; j < size; j++) { 
					if (edges[i][j]) 
						cadena += "T\t"; 
					else
						cadena += "F\t"; 
				} 
			cadena += "\n"; 
		} 
		cadena += "\nPESOS\n"; 
		for (int i = 0; i < size; i++) { 
			for (int j = 0; j < size; j++)
				cadena += (edges[i][j]?df.format(weights[i][j]):"-") + "\t"; 
			cadena += "\n"; 
		} 
		return cadena; 
	} 
	
//DIJKSTRA
	/**
	 * Devuelve un array con el recorrido más barato desde un nodo dado a los 
	 * demás nodos del grafo
	 * @param source, el nodo de partida
	 * @return el array de pesos, de tipo double[]
	 */
	@SuppressWarnings("unchecked")
	public double [] dijkstra(T source) {
		//Checkear si el nodo existe
		if(!existNode(source))
			return null;
		
		boolean S [] = inicializaDijkstraS();
		double [] D = inicializDijkstraD(source);
		T [] P = (T[]) new Object [size];
		
		int w=getPivote(D, S);
		while(w!=-1) {
			S[w] = true;
			for (int m=0; m<size; m++) {
				if(!S[m] && edges[w][m]) {
					if (D[w] + weights[w][m] < D[m]) {
						D[m] = D[w] + weights[w][m];
						P[m] = nodes[w];
					}
				}
			}
			w=getPivote(D, S); 
		}
		return D;
	}
	
	/**
	 * Inicializa el array S de dijkstra. Al empezar, todos los nodos están sin 
	 * visitar (false)
	 * @return el array, de tipo boolean[]
	 */
	private boolean[] inicializaDijkstraS() {
		boolean s[] = new boolean [size];
		for(int i=0; i<size; i++) {
			s[i] = false;
		}
		return s;
	}

	/**
	 * Inicializa el array D de dijkstra. 
	 * @return el array, de tipo boolean[]
	 */
	private double [] inicializDijkstraD(T source) {
		double [] d = new double [size];
		for(int i=0; i<size; i++) {
			if(getNode(source) == i)
				d[i] = 0; //si el nodo de partida es el primero, el coste es 0
			else if(edges[getNode(source)][i])
				d[i] = weights[getNode(source)][i]; //si existe una arista, pone su peso
			else
				d[i] = Double.POSITIVE_INFINITY; //si no existe arista, el coste es infinito
		}
		return d;
	}
	
	/**
	 * Devuelve la posición del nodo que tenga el menor coste a un nodo que NO 
	 * haya sido visitado todavía
	 * @param los pesos de ir a todos los nodos
	 * @param s el array de nodos visitados
	 * @return el pivote
	 */
	private int getPivote(double[] d, boolean[] s) {
		double lessW = Double.POSITIVE_INFINITY;
		int lessP = -1;
		for(int i=0; i<size; i++) {
			if(!s[i] && d[i] < lessW) {
				lessW = d[i];
				lessP = i;
			}
		}
		return lessP;
	}

//FLOYD
	/**
	 * Calcula el coste mínimo pra ir de todos los nodos a todos los nodos
	 * @return 0 si se realiza correctamente, -1 si no
	 */
	public int floyd() {
		if(size <=0) return -1;
		
		A = inicializaFloydA();
		P = inicializaFloydP();
		
		for (int k=0; k<size; k++) {
			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					if (A[i][k] + A[k][j] < A[i][j]) {
						A[i][j] = A[i][k] + A[k][j]; 
						P[i][j] = nodes[k];
					}
				}
			}
			System.out.println("Nodo intermedio " + k);
			System.out.println("------------------- ");
			System.out.println(floydToString());
		}
		return 0;
	}

	/**
	 * Inicializa la matriz A de floyd, que guarda los pesos de ir de cada nodo 
	 * al resto
	 * @return la matriz de pesos, de tipo double[][]
	 */
	private double[][] inicializaFloydA() {
		double [][] d = new double [size][size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(i==j)
					d[i][j] = 0;
				else if(edges[i][j])
					d[i][j] = weights[i][j];
				else
					d[i][j] = Double.POSITIVE_INFINITY;
			}
		}
		return d;
	}

	/**
	 * Inicializa la matriz P de floyd
	 * @return la matriz, de tipo T[][]
	 */
	@SuppressWarnings("unchecked")
	private T[][] inicializaFloydP() {
		T [][] p = (T [][]) new Object [size][size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
					p[i][j]=null;
			}
		}
		return p;
	}
	
	public void floydPivots(T[] pivots) {
		A = inicializaFloydA();
		P = inicializaFloydP();
				
		for (int k=0; k<size; k++) {
			if(isAPivot(pivots, nodes[k])) {
				for (int i=0; i<size; i++) {
					for (int j=0; j<size; j++) {
						if (A[i][k] + A[k][j] < A[i][j]) {
							A[i][j] = A[i][k] + A[k][j]; 
							P[i][j] = nodes[k];
						}
					}
				}
				System.out.println("Nodo intermedio " + k);
				System.out.println("------------------- ");
				System.out.println(floydToString());
			}
			
		}
	}
	
	private boolean isAPivot(T[] pivots, T t) {
		for(int i=0; i<pivots.length; i++) {
			if(t.equals(pivots[i]))
				return true;
		}
		return false;
	}
	
	
	/**
	 * Devuelve el coste mínimo para ir de un nodo dado a otro
	 * @param nodoOrigen, el nodo de partida
	 * @param nodoDestino, el nodo destino
	 * @return el coste, de tipo double
	 */
	protected double minCostPath(T nodoOrigen,T nodoDestino){
		if(A == null || P ==null) {
			floyd();
		}
		return A[getNode(nodoOrigen)][getNode(nodoDestino)];
	}
	
	public double[][] getFloydA(){
		return A;
	}
	
	public T[][] getFloydP(){
		return P;
	}
	
	/**
	 * Devuelve un String con el camino de menor coste entre dos nodos, de forma
	 * "Origen+tab+(Coste)+tab+Intermedio/s+tab+(Coste)+tab+Destino
	 * @param nodoOrigen
	 * @param nodoDestino
	 * @return la cadena, String
	 */
	public String path(T nodoOrigen, T nodoDestino) {
		int s = getNode(nodoOrigen);
		int t = getNode(nodoDestino);
		
		if(s==t)//Si nodo origen == nodo destino devuelve el origen
			return nodoOrigen.toString();
		else if(A[s][t]==Double.POSITIVE_INFINITY)
			return nodoOrigen.toString() + "\t(Infinity)\t" +  nodoDestino.toString() ;
			
		return nodoOrigen + pathIntermedio(nodoOrigen, nodoDestino) + nodoDestino;	
	}
	
	/**
	 * Método que calcula la cadena del path y los nodos intermedios.
	 * @param nodoOrigen
	 * @param nodoDestino
	 * @return la cadena, de tipo String
	 */
	private String pathIntermedio(T nodoOrigen, T nodoDestino) {
		T k = P[getNode(nodoOrigen)][getNode(nodoDestino)];
		if(k!=null)
			return pathIntermedio(nodoOrigen, k) + k.toString() + pathIntermedio(k, nodoDestino);
		return "\t(" + A[getNode(nodoOrigen)][getNode(nodoDestino)] + ")\t";
		
	}
	
	public String floydToString() {
		int numNodes=size; 
		String cadena=" "; 
		DecimalFormat df = new DecimalFormat("#.##"); 
		
		 double[][] aFloyd = getFloydA(); 
	        if (aFloyd != null) { 
	            cadena += "\nAFloyd\n"; 
	            for (int i = 0; i < numNodes; i++) { 
	                for (int j = 0; j < numNodes; j++) { 
	                    cadena += df.format(aFloyd[i][j]) + "\t"; 
	                } 
	                cadena += "\n"; 
	            } 
	        } 
	  
	        T[][] pFloyd = getFloydP(); 
	        if (pFloyd != null) { 
	                cadena += "\nPFloyd\n"; 
	            for (int i = 0; i < numNodes; i++) { 
	                for (int j = 0; j < numNodes; j++) { 
	                	if (pFloyd[i][j]==null) cadena+="-"+ "\t";
	                	
	                	else cadena += pFloyd[i][j].toString() + "\t"; 
	                } 
	                cadena += "\n"; 
	            } 
	      } 
	      return cadena;
	}
	
//RECORRIDO PROFUNDIDAD
	/**
	 * Recorre el grafo en profundidad partiendo del nodo dado como parámetro.
	 * @param nodo, el nodo de partida
	 * @return una cadena con el recorrido en formato: nodo1+tab+nodo2+...+tab+nodoN
	 */
	public String recorridoProfundidad(T nodo) {
		cadenaDFS="";
		boolean visitados[] = new boolean[size];
		if(!existNode(nodo))
			return cadenaDFS;
		cadenaDFS += nodo.toString() + "\t";
		visitados[getNode(nodo)]=true;
		recursivoProfundidad(nodo, visitados);
		return cadenaDFS;
	}

	/**
	 * Método recursivo que dado un nodo busca todos los nodos acesibles y 
	 * NO VISITADOS previamente, los añade a la cadena y se llama a si mismo 
	 * pasando dichos nodos como parámetro.
	 * @param nodo, el nodo de partida
	 * @param visitados, el array de los nodos del grafo que ya han sido visitados
	 */
	private void recursivoProfundidad(T nodo, boolean[] visitados) {
		int pos = getNode(nodo);
		for(int i=0; i<size; i++) {
			if(!visitados[i] && edges[pos][i]) {
				visitados[i] = true;
				cadenaDFS += nodes[i].toString() + "\t";
				recursivoProfundidad(nodes[i], visitados);
			}	
		}
		
	}

//PRESTADO POR DAVID Y SONIA (NO ES MÍO)
private boolean[] visited;

public String grafoConexo() {
	visited = new boolean[size];
	String result = "";
	for(int i = 0; i < nodes.length; i++) {
		result += grafoConexo2(nodes[i]);
	}
	return result;
}

public String grafoConexo2(T nodo) {
	cadenaDFS = "";
	int k = getNode(nodo);
	for(int i = 0; i < size; i++) {			
		if(!visited[i] && edges[k][i]) {
			cadenaDFS += nodes[k].toString() + "\t";
			k = i;
			cadenaDFS += nodes[k].toString();
			nodoConexo(nodes[k], visited);
		}
	}
	return cadenaDFS;
}

private String nodoConexo(T nodo, boolean[] visited) {
	int k = getNode(nodo);

	visited[k] = true;
	for(int i = 0; i < size; i++) {			
		if(!visited[i] && edges[k][i]) {
			k = i;
			cadenaDFS += "\t "+ nodes[k].toString();
			nodoConexo(nodes[k], visited);
		}
	}
	return cadenaDFS;
}

public String ciclo(T nodo) {
	visited = new boolean[size];
	cadenaDFS = "";
	int k = getNode(nodo);
	for(int i = 0; i < size; i++) {			
		if(!visited[i] && edges[k][i]) {
			cadenaDFS += nodes[k].toString() + "\t";
			k = i;
			cadenaDFS += nodes[k].toString();
			ciclo2(nodes[k], visited);
		}
	}
	return cadenaDFS;
}

private String ciclo2(T nodo, boolean[] visited) {
	int k = getNode(nodo);

	visited[k] = true;
	for(int i = 0; i < size; i++) {			
		if(!visited[i] && edges[k][i]) {
			k = i;
			cadenaDFS += "\t "+ nodes[k].toString();
			nodoConexo(nodes[k], visited);
		}
	}
	return cadenaDFS;
}

/**
 * Metodo que comprueba el tipo de nodo que es
 * Si el nodo es fuente devuelve 1
 * Si el nodo es sumidero devuelve 2
 * Si el nodo es aislado devuelve 0
 * Si el nodo no existe devuelve -1
 * @param nodo
 */
public String compruebaTipoNodo(T nodo) {
	String tipoNodo = "No existe nodo";
	if(getNode(nodo) != -1) {
		//nodo fuente
		 if(gradoSalida(nodo) > 0 && gradoEntrada(nodo) == 0) {
			tipoNodo = "Nodo Fuente";
		 }
		//nodo sumidero
		else if(gradoSalida(nodo) == 0 && gradoEntrada(nodo) > 0) {
			tipoNodo = "Nodo Sumidero";
		}		
		//nodo aislado
		else if(gradoSalida(nodo) == 0 && gradoEntrada(nodo) == 0) {
			tipoNodo = "Nodo Aislado";
		}
	}
	//si no existe nodo
	return tipoNodo;
}

/**
 * Metodo que devuelve el grado de un nodo 
 * si no existe nodo devuelve -1
 * @param nodo
 * @return
 */
public int gradoNodo(T nodo) {
	int gradoNodo = -1;
	if(getNode(nodo) != -1) {
		gradoNodo = gradoEntrada(nodo) + gradoSalida(nodo);
	}
	return gradoNodo;
}

/**
 * Metodo que calcula el grado de un grafo
 * @return
 */
public int gradoGrafo() {
	int gradoGrafo = 0;
	for(int i = 0; i < size; i++) {			
		gradoGrafo += gradoNodo(nodes[i]);
	}
	return gradoGrafo;
}

/**
 * Metodo que calcula la capacidad de un grafo
 * el numero maximo de arcos que puede tener
 * @return
 */
public int capacidadGrafoMax() {
	int total = 0;
	int n = nodes.length;
	for(int i = 0; i < size; i++) {
		if(comprobarBucle(nodes[i])) {
			total = n*n;
		}
	}
	total = n*n-n;
	return total;
}

/**
 * Metodo que devuelve el centro de un grafo
 * @return
 */
public double centroGrafo() {		
	floyd();
	double centro = excentricidad(0);
	for(int i = 0; i < size; i ++) {
		double exc = excentricidad(i); 
		if(exc < centro || centro == Double.POSITIVE_INFINITY) {
			centro = exc;
		}			
	}
	return centro;
}

/**
 * Metodo que devuelve la excentricidad de un grafo
 * Maximo de los costes de todos los caminos de coste minimos con destino n
 * @param n
 * @return
 */
public double excentricidad(int n) {
	double max = 0;
	for(int j = 0; j < size; j++) {
		if(A[j][n] == Double.POSITIVE_INFINITY) {
			max = Double.POSITIVE_INFINITY;
		}
		else if(A[j][n] > max) {
			max = A[j][n];
		}
	}
	return max;
}

/**
 * Metodo que comprueba el grado de entrada de un nodo
 * @param nodo
 * @return
 */
private int gradoEntrada(T nodo) {
	int gradoEntrada = 0;
	for (int i = 0; i < size; i++) {
		if(existEdge(nodes[i], nodo)) {
			gradoEntrada++;
		}
	}
	return gradoEntrada;
}

/**
 * Metodo que comprueba el grado de salida de un nodo
 * @param nodo
 * @return
 */
private int gradoSalida(T nodo) {
	int gradoSalida = 0;
	for (int i = 0; i < size; i++) {
		if (existEdge(nodo, nodes[i])) {
			gradoSalida++;
		}
	}
	return gradoSalida;
}

public boolean comprobarBucle(T nodo) {
	int i = getNode(nodo);
	return edges[i][i];
}

public int addEdgeNoDirigido(T source, T target, double weight) {		
	int i = getNode(source);
	int j = getNode(target);
	
	//el peso no es valido
	if(weight <= 0) {
		return (-8);
	}
	//ya existe arista
	else if(existEdge(source, target)) {
		return (-4);
	}
	//no existen ambos nodos
	else if(i == -1 && j == -1) {
		return(-3);
		}
	//no existe nodo origen
	else if(i == -1) {
		return (-1);
			}
	//no existe nodo destino
	else if(j == -1){
		return (-2);
	}
	//crea arista
	else {			
		edges[i][j] = true;
		weights[i][j] = weight;
		edges[j][i] = true;
		weights[j][i] = weight;
		return 0;
	}
}

public int addEdgeSinEtiqueta(T source, T target, double weight) {		
	int i = getNode(source);
	int j = getNode(target);
	
	//el peso no es valido
	if(weight <= 0) {
		return (-8);
	}
	//ya existe arista
	else if(existEdge(source, target)) {
		return (-4);
	}
	//no existen ambos nodos
	else if(i == -1 && j == -1) {
		return(-3);
		}
	//no existe nodo origen
	else if(i == -1) {
		return (-1);
			}
	//no existe nodo destino
	else if(j == -1){
		return (-2);
	}
	//crea arista
	else {			
		edges[i][j] = true;
		return 0;
	}
}
	
}

