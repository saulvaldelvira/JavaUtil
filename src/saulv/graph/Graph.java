package saulv.graph;

import java.text.DecimalFormat;

import saulv.exception.*;

public class Graph<T> {

	public static final int INDEX_NOT_FOUND = -1;
	public static final double INFINITE = 1.0/0.0;
	public static final int EMPTY = -1;
	
	private T[] nodes; // Node array

	private boolean[][] edges; // Adjacency matrix

	private double[][] weights; // Weight matrix

	private int numNodes; // The current size of the graph

	private double aFloyd[][]; // A Floyd Matrix

	private int pFloyd[][]; // P Floyd Matrix


	protected double[][] getAFloyd() {
		return aFloyd;
	}

	protected int[][] getPFloyd() {
		return pFloyd;
	}
	
	/**
	 * 
	 * @param maxSize Maximum number of nodes that can be stored in the graph
	 */
	@SuppressWarnings("unchecked")
	public Graph(int maxSize) {
		nodes = (T[]) new Object[maxSize];
		numNodes = 0;
		edges = new boolean[maxSize][maxSize];
		weights= new double[maxSize][maxSize];
		aFloyd = new double[maxSize][maxSize];
		pFloyd = new int[maxSize][maxSize];
		for(int i=0; i<maxSize; i++)
			for(int j=0; j<maxSize; j++)
				edges[i][j] = false;
	}

	
	public boolean addNode(T node) {
		if(node==null)
			throw new NullPointerException("Element to (" + node +") is null.");
		if(getSize()==nodes.length)
			throw new FullStructureException(node);
		if(getNode(node)!=INDEX_NOT_FOUND)
			return false;
		nodes[getSize()] = node;
		for(int i=0; i<getSize(); i++) {
			edges[getSize()][i]=false;
			edges[i][getSize()]=false;
		}
		numNodes++;
		return true;
	}


	public boolean removeNode(T node) {
		if(node==null)
			throw new NullPointerException("Element to remove (" + node + ") is null.");
		int pos = getNode(node);
		if(pos==INDEX_NOT_FOUND)	return false;
		numNodes--;
		nodes[pos] = nodes[numNodes];
		for(int j=0; j<getSize(); j++) {
			edges[j][pos]=edges[j][numNodes];
			edges[pos][j]=edges[numNodes][j];
			weights[j][pos]=weights[j][numNodes];
			weights[pos][j]=weights[numNodes][j];
		}
		edges[pos][pos] = edges[numNodes][numNodes];
		weights[pos][pos] = weights[numNodes][numNodes];
		return true;
	}

	public int getNode(T node) {
		if(node==null)
			throw new NullPointerException("The specified node (" + node +") is null");
		for(int i=0; i<numNodes; i++)
			if(node.equals(nodes[i]))	return i;
		return INDEX_NOT_FOUND;
	}
	
	public int getSize() {
		return numNodes;
	}

	public boolean existsEdge(T source, T target) {
		if(source==null)	
			throw new NullPointerException("The specified source parameter (" + source + ") is null");
		else if(target==null)	
			throw new NullPointerException("The specified target parameter (" + target + ") is null");
		if(getNode(source)==INDEX_NOT_FOUND || getNode(target)==INDEX_NOT_FOUND)
			return false;
		int i = getNode(source),
			j = getNode(target);
		return edges[i][j];
	}

	public boolean addEdge(T source, T target, double edgeWeight) {
		if(getNode(source)==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(
					"Edge could not be loaded: source element " + source + " is not part of the graph.");
		if(getNode(target)==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(
					"Edge could not be loaded: target element " + target + " is not part of the graph.");
		if(edgeWeight<=0)
			throw new IllegalArgumentException(
					"Weight edge could not be less or equals to 0");
		if(existsEdge(source, target))	return false;
		int i = getNode(source),
			j = getNode(target);
		weights[i][j] = edgeWeight;
		edges[i][j] = true;
		return true;
	}

	public boolean removeEdge(T source, T target) {
		if(getNode(source)==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(
					"Edge could not be loaded: source element " + source + " is not part of the graph.");
		if(getNode(target)==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(
					"Edge could not be loaded: target element " + target + " is not part of the graph.");
		if(!existsEdge(source, target))	return false;
		int i = getNode(source),
			j = getNode(target);
			weights[i][j] = 0.0;
			edges[i][j] = false;
		return true;
	}


	public double getEdge(T source, T target) {
		if(getNode(source)==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(
			"Edge weight could not be obtained: " + source + " is not present in the current graph.");
		if(getNode(target)==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(
			"Edge weight could not be obtained: " + target + " is not present in the current graph.");
		if(!existsEdge(source, target))	return INDEX_NOT_FOUND;
		int i = getNode(source),
			j = getNode(target);
		return weights[i][j];
	}

	public boolean isSourceNode(T node) {
		if(node==null)
			throw new NullPointerException("El nodo especificado como parámetro ("+ node + ") es nulo");
		int pos = getNode(node);
		if(pos==INDEX_NOT_FOUND)
			throw new ElementNotPresentException("The given node (" + node + " is not present in the current graph.");
		for(int i=0; i<getSize(); i++)
			if(edges[i][pos]!=false)
				return false;
		return true;
	}
	
	public boolean isDrainNode(T node) {
		if(node==null)
			throw new NullPointerException("El nodo especificado como parámetro ("+ node + ") es nulo");
		int pos = getNode(node);
		if(pos==INDEX_NOT_FOUND)
			throw new ElementNotPresentException("The given node (" + node + " is not present in the current graph.");
		for(int i=0; i<getSize(); i++)
			if(edges[pos][i]!=false)
				return false;
		return true;
	}
	
	public double eccentricity(T node) {
		if(node==null)
			throw new NullPointerException("The given node is null");
		int index = getNode(node);
		if(index==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(node);
		floyd(getSize());
		double max = -1.0;
		for(int i=0; i<getSize(); i++)
			if(aFloyd[i][index]>max) //aFloyd[i][index] es la distancia (camino de coste minimo) entre el nodo i y nuestro nodo
				max = aFloyd[i][index];
		
		return max;
	}

	public boolean floyd(int iterations) {
		initsFloyd();
		if(getSize()<=1)	return false; //Si no hay al menos 2 nodos no se ejecuta el algoritmo
		for(int pivot = 0; pivot<iterations; pivot++) { //Se comprueban solo los pivotes pasados como parámetro
			for(int i=0; i<getSize(); i++)
				for(int j=0; j<getSize(); j++)
					//Si el coste de i -> pivote -> j es menor que i -> j se sustituye en las matrices A y P el nuevo camino
					if(aFloyd[i][j] > aFloyd[i][pivot] + aFloyd[pivot][j]) {
						aFloyd[i][j] = aFloyd[i][pivot] + aFloyd[pivot][j];
						pFloyd[i][j] = pivot;
					}
		}
		return true;
	}

	private void initsFloyd() {
		for(int i=0; i<getSize(); i++) {
			for(int j=0; j<getSize(); j++) {
				aFloyd[i][j] = edges[i][j] ? weights[i][j]: INFINITE; //Si hay arco directo, pone el peso. Si no infinito
				pFloyd[i][j] = EMPTY; //rellena la matriz P con EMPTY (-1)
			}
			aFloyd[i][i] = 0; //La diagonal de la matriz A siempre tiene ceros
		}
	}
	
	/**
	 * Devuelve el recorrido de coste minimo entre source y target
	 * VER TEST
	 * @param source
	 * @param target
	 * @return
	 */
	public String printFloydPath(T source, T target) {
		int s = getNode(source),
			t = getNode(target);
		if(s==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(source);
		else if(t==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(target);
		
		//if P[s][t] is -1 it could mean there's no path to target OR the path is direct (exists edge betweem s and t)
		//So we check and if there's no direct edge betweet s and t, it means there is no floyd path and return the string
		if(pFloyd[s][t]==EMPTY && !edges[s][t]) return "_NO_PATH_FOUND_TO_"; 
		else return printFloydPathR(source, target);
		
	}
	
	private String printFloydPathR(T source, T target) {
		int s = getNode(source),
			t = getNode(target);
		int aux = pFloyd[s][t];
		if(aux!=EMPTY)
			return printFloydPathR(source, nodes[aux]) + nodes[aux] + printFloydPathR(nodes[aux], target);
		else	return "";
	}
	
	public String traverseGraphDF(T element) {
		int index = getNode(element);
		if(index == INDEX_NOT_FOUND)	return null;
		boolean[] visited = new boolean[getSize()];
		return DFPrint(index, visited);
	}
	
	private String DFPrint(int index, boolean[] visited) {
		visited[index] = true;
		String result =  nodes[index].toString() + "-";
		for(int i=0; i<getSize(); i++)
			if(edges[index][i] && !visited[i])
				result += DFPrint(i, visited);
		return result + "";
	}

	public String recorridoProfundidad(T nodo) {
		return "";
	}

	public String path(T origen, T destino) {
		return "";
	}


	public DijkstraDataClass dijkstra(T nodoOrigen) {
		int index = getNode(nodoOrigen);
		if(index == INDEX_NOT_FOUND)
			return null;
		double[] d = new double[getSize()];
		int[] p = new int[getSize()];
		initsDijkstra(index, d, p);
		boolean[] s = new boolean[getSize()];
		s[index] = true;
		int pivote = getPivot(s, d);
		
		while(pivote != EMPTY) {
			for(int i=0; i<getSize(); i++) {
				double peso = d[pivote] + weights[pivote][i];
				if(d[i] > peso && edges[pivote][i]) {
					d[i] = peso;
					p[i] = pivote;
				}
			}
			s[pivote] = true;
			pivote = getPivot(s, d);
		}		
		return new DijkstraDataClass(getSize(), index, d, p);
	}

	private int getPivot(boolean[] s, double[] d) {
		int pivot = EMPTY;
		double min = INFINITE;
		for(int i=0; i<d.length; i++)
			if(d[i]<min && !s[i]) {
				min = d[i];
				pivot = i;
			}
		return pivot;
	}


	private void initsDijkstra(int elementindex, double[] D, int[] P){
		for(int i=0; i<getSize(); i++) {
			D[i] = edges[elementindex][i] ? weights[elementindex][i]: INFINITE;
			P[i] = edges[elementindex][i] ? elementindex: EMPTY;
		}
		D[elementindex] = 0.0;
		P[elementindex] = elementindex;
	}
	
	public boolean containsCycles() {
		floyd(getSize());
		for(int i=0; i<getSize(); i++) {
			for(int j=0; j<getSize(); j++) {
				if(j!=i && aFloyd[j][i]!=INFINITE && aFloyd[i][j]!=INFINITE)
					return true;
			}
		}
		for(int i=0; i<getSize(); i++) {
			if(edges[i][i])	return true;
		}
		return false;
	}

	/**
	 * TODO: NO Recursivo. Primero hermanos y luego hijos
	 * @param element
	 * @return
	 */
	public String BFPrint(T element) {
		int index = getNode(element);
		if(index == INDEX_NOT_FOUND)	return null;
		String result = element.toString();
		for(int i=0; i<getSize(); i++) {
			
		}
		return result;
	}
	
	/**
	 * TODO: Dijstra pero en vez de caminos coste minimo caminos mas cortos
	 * @param source
	 * @param target
	 * @return
	 */
	public int shortestPathLength(T source, T target) {
		int s = getNode(source), 
			t = getNode(target);
		if(s==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(source);
		if(t==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(target);

		floydPathLength(getSize());
		return (int) aFloyd[s][t];
	}
	
	public boolean floydPathLength(int iterations) {
		initsFloydPathLength();
		if(getSize()<=1)	return false; //Si no hay al menos 2 nodos no se ejecuta el algoritmo
		for(int pivot = 0; pivot<iterations; pivot++) { //Se comprueban solo los pivotes pasados como parámetro
			for(int i=0; i<getSize(); i++)
				for(int j=0; j<getSize(); j++)
					//Si el coste de i -> pivote -> j es menor que i -> j se sustituye en las matrices A y P el nuevo camino
					if(aFloyd[i][j] > aFloyd[i][pivot] + aFloyd[pivot][j]) {
						aFloyd[i][j] = aFloyd[i][pivot] + aFloyd[pivot][j];
						pFloyd[i][j] = pivot;
					}
		}
		return true;
	}

	private void initsFloydPathLength() {
		for(int i=0; i<getSize(); i++) {
			for(int j=0; j<getSize(); j++) {
				aFloyd[i][j] = edges[i][j] ? 1: INFINITE; //Si hay arco directo, pone 1. Si no infinito
				pFloyd[i][j] = EMPTY; //rellena la matriz P con EMPTY (-1)
			}
			aFloyd[i][i] = 0; //La diagonal de la matriz A siempre tiene ceros
		}
	}
	
	public boolean esAccesible(T node) {
		int index = getNode(node);
		if(index==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(node);
		floyd(getSize());
		for(int i=0; i<getSize(); i++)
			if(aFloyd[i][index]==INFINITE)
				return false;
		return true;
	}
	
	public boolean isStronglyConected() {
		floyd(getSize());
		for(int i=0; i<getSize(); i++)
			for(int j=0; j<getSize(); j++)
				if(aFloyd[i][j] == INFINITE)
					return false;
		return true;
	}
	
	/**
	 * Para cada par de nodos puedes acceder de u -> v o de v -> u
	 * @return
	 */
	public boolean isSemiConected() {
		floyd(getSize());
		for(int i=0; i<getSize(); i++)
			for(int j=0; j<getSize(); j++)
				if(aFloyd[i][j] != INFINITE || aFloyd[j][i] != INFINITE)
					continue;
				else	return false;
		return true;
	}
	
	/**
	 * La version no dirigida es strongly conected
	 * @return
	 */
	public boolean isWeaklyConnected() {
		floydNotDirected(getSize());
		for(int i=0; i<getSize(); i++)
			for(int j=0; j<getSize(); j++)
				if(aFloyd[i][j] == INFINITE)
					return false;
		return true;
		
	}
	
	public boolean floydNotDirected(int iterations) {
		initsFloydNotDirected();
		if(getSize()<=1)	return false; //Si no hay al menos 2 nodos no se ejecuta el algoritmo
		for(int pivot = 0; pivot<iterations; pivot++) { //Se comprueban solo los pivotes pasados como parámetro
			for(int i=0; i<getSize(); i++)
				for(int j=0; j<getSize(); j++)
					//Si el coste de i -> pivote -> j es menor que i -> j se sustituye en las matrices A y P el nuevo camino
					if(aFloyd[i][j] > aFloyd[i][pivot] + aFloyd[pivot][j]) {
						aFloyd[i][j] = aFloyd[i][pivot] + aFloyd[pivot][j];
						pFloyd[i][j] = pivot;
					}
		}
		return true;
	}

	private void initsFloydNotDirected() {
		boolean[][] edgesND = new boolean[getSize()][getSize()];
		for(int i=0; i<getSize(); i++)
			for(int j=0; j<getSize(); j++)
				edgesND[i][j] = edges[i][j] || edges[j][i];
		for(int i=0; i<getSize(); i++) {
			for(int j=0; j<getSize(); j++) {
				aFloyd[i][j] = edgesND[i][j] ? 1: INFINITE; //Si hay arco directo, pone 1. Si no infinito
				pFloyd[i][j] = EMPTY; //rellena la matriz P con EMPTY (-1)
			}
			aFloyd[i][i] = 0; //La diagonal de la matriz A siempre tiene ceros
		}
	}
	
	/**
	 * 
	 * un arco es reciprocos si existe su contrario 
	 * 
	 * @param origen
	 * @param destino
	 * @return
	 */
	public double getReciprocity() {
		double arcs=0, reciproc=0;
		for(int i=0; i<getSize(); i++)
			for(int j=0; j<getSize(); j++)
				if(edges[i][j]) {
					arcs++;
					if(edges[j][i])
						reciproc++;
				}
		if(arcs==0)	return 0;
		return reciproc/arcs;
	}
	
	public double minCostPath(T origen, T destino) {
		int s = getNode(origen),
			t = getNode(destino);
		if(s==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(origen);
		if(t==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(destino);
		
		DijkstraDataClass d = dijkstra(origen);
		return d.getdDijkstra()[t];
	}


	public boolean[][] getEdges() {
		return edges;
	}


	public double[][] getWeight() {
		return weights;
	}


	public double[][] getA() {
		return aFloyd;
	}

	public int[][] getP() {
		return pFloyd;
	}
	
	////EXTRA (HECHOS POR MI)
	public int grado(T node) {
		return gradoEntrada(node) + gradoSalida(node);
	}
	
	public int gradoEntrada(T node) {
		int index = getNode(node);
		if(index==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(node);
		int result = 0;
		for(int i=0; i<getSize(); i++)
			if(edges[i][index]);
				result++;
		return result;
	}
	
	public int gradoSalida(T node) {
		int index = getNode(node);
		if(index==INDEX_NOT_FOUND)
			throw new ElementNotPresentException(node);
		int result = 0;
		for(int i=0; i<getSize(); i++)
			if(edges[index][i]);
				result++;
		return result;
	}
	
	public double getDensity() {
		int m = getSize(),
			n = numEdges();
		return (2.0*m) / (n*(n-1));
	}
	
	public int numEdges() {
		int result = 0;
		for(int i=0; i<getSize(); i++)
			for(int j=0; j<getSize(); j++)
				if(edges[i][j])	result++;
		return result;
	}
	
	/**
	 * @return Returns a String with all the information of the current graph
	 *         (including Floyd matrices)
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		String cadena = "";

		cadena += "NODES\n";
		for (int i = 0; i < numNodes; i++) {
			cadena += nodes[i].toString() + "\t";
		}
		cadena += "\n\nEDGES\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {
				if (edges[i][j])
					cadena += "T\t";
				else
					cadena += "F\t";
			}
			cadena += "\n";
		}
		cadena += "\nWEIGHTS\n";
		for (int i = 0; i < numNodes; i++) {
			for (int j = 0; j < numNodes; j++) {

				cadena += (edges[i][j] ? df.format(weights[i][j]) : "-") + "\t";
			}
			cadena += "\n";
		}

		double[][] aFloyd = getAFloyd();
		if (aFloyd != null) {
			cadena += "\nAFloyd\n";
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {
					cadena += df.format(aFloyd[i][j]) + "\t";
				}
				cadena += "\n";
			}
		}

		int[][] pFloyd = getPFloyd();
		if (pFloyd != null) {
			cadena += "\nPFloyd\n";
			for (int i = 0; i < numNodes; i++) {
				for (int j = 0; j < numNodes; j++) {
					cadena += (pFloyd[i][j] >= 0 ? df.format(pFloyd[i][j]) : "-") + "\t";
				}
				cadena += "\n";
			}
		}

		return cadena;
	}
}
