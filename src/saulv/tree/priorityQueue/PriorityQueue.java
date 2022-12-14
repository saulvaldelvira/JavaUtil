package saulv.tree.priorityQueue;

public interface PriorityQueue <T extends Comparable<T>>{
	public int add(T elemento);
	public T sacar();
	public int remove(T elemento);
	public boolean isEmpty();
	public void clear();
	public int cambiarPrioridad(int pos, T elemento);
	public String toString();
}
