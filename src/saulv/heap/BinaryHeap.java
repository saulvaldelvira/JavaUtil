package saulv.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a priority queue, implemented using a binary heap of mins. <br>
 * See: 
 * 	* <a href="https://en.wikipedia.org/wiki/Binary_heap">Binary Heap</a>
 * 
 * @author Saúl Valdelvira Iglesias (UO283685)
 *
 * @param <T> the type of the info stored in the queue
 */
public class BinaryHeap<T extends Comparable<T>> {
	private List<T> heap;
	
	public BinaryHeap() {
		heap = new ArrayList<T>();
	}
	
	public BinaryHeap(T[] elements) {
		heap = new ArrayList<T>();
		for(int i=0; i<elements.length; i++)
			heap.add(elements[i]);
		
		for(int i=heap.size()-1; i>0; i-=2)
			filterDown((i-1) / 2);
	}
	
	/**
	 * Adds an element to the heap
	 * @param element to add to the queue
	 */
	public void add(T element) {
		if(element == null)
			throw new NullPointerException("The given element is null");
		heap.add(element);
		filterUp(heap.size()-1);
	}
	
	/**
	 * Returns the min element of the queue (the first element of the heap)
	 * @return T , the min element
	 */
	public T getMin() {
		if(isEmpty())
			throw new IllegalStateException("The heap is empty");
		T result = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		filterDown(0);
		return result;
	}
	
	//FILTERING///////////////////////////////////////////////
	
	/**
	 * Performs a filter up starting in the given position
	 * @param pos index to start the filtering in
	 */
	private void filterUp(int pos) {
		//ends at the start of the heap or if the father element already is <= than it's son
		if(pos<=0 || heap.get(pos).compareTo( heap.get((pos-1) / 2)) >= 0)
			return;
		Collections.swap(heap, pos, (pos-1) / 2);
		filterUp((pos-1) / 2);
	}
	
	/**
	 * Performs a filter down starting in the given position
	 * @param pos index to start the filtering in
	 */
	private void filterDown(int pos) {
		int lowestChild;
		if(pos>=heap.size() || ( lowestChild = getLowestChild(pos) )  == -1)
			return;
		Collections.swap(heap, pos, lowestChild);
		filterDown(lowestChild);
	}
	
	/**
	 * Returns the index of the lowest child, or -1 in case there's not any.
	 * @param pos , the element wich child's we want to search.
	 * @return the index of the lowest child
	 */
	private int getLowestChild(int pos) {
		int lChild = pos*2 + 1,
			rChild = pos*2 + 2,
			lowest;
		if(lChild >= heap.size())
			if(rChild >= heap.size())
				return -1; //if both child index go out of bounds, returns -1
			else 
				lowest = rChild; //if there's a right child but no left, the lowest if the right one.
		else if(rChild >= heap.size())
			lowest = lChild; //the same as before but with the left child
		else 
			lowest = heap.get(lChild).compareTo( heap.get(rChild)) < 0 ? lChild : rChild; //if both childs exist, take the lower one
		return heap.get(lowest).compareTo(heap.get(pos)) < 0 ? lowest : -1; //if the lowest child is lower than its father, return it. Else return -1
		
	}
	/////////////////////////////////////////
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	@Override
	public String toString() {
		return heap.toString();
	}
	
}
