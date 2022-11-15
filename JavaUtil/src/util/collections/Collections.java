/**
 * 
 */
package util.collections;

import java.util.Comparator;



/**
 * @author Saúl Valdelvira Iglesias (UO283685)
 * @version 20/04/2021
 */
public class Collections {

	public static<T> void sort(List<T> list, Comparator<T> comparator) {
		List<T> sorted = new ArrayList<>();
		for (T element : list) {
			int index = findPositionInSorted(element, sorted, comparator);
			sorted.add(index, element);
		}
		makeCopy(sorted,list);
	}
	
	private static<T> int findPositionInSorted(T element, List<T> sorted, Comparator<T> comparator) {
		int index = 0;
		for(T elementInSorted: sorted) {
			if(comparator.compare(elementInSorted, element) > 0)
				return index;
			index++;
		}
		return sorted.size();
	}
	
	public static<T> void sort(List<T> list) {
		List<T> sorted = new ArrayList<>();
		for (T element : list) {
			int index = findPositionInSorted(element, sorted);
			sorted.add(index, element);
		}
		makeCopy(sorted,list);
	}

	@SuppressWarnings("unchecked")
	private static<T> int findPositionInSorted(T element, List<T> sorted) {
		int index = 0;
		for(T elementInSorted: sorted) {
			if(((Comparable<T>) elementInSorted).compareTo(element) > 0)
				return index;
			index++;
		}
		return sorted.size();
	}
	
	private static<T> void makeCopy(List<T> origin, List<T> destination) {
		destination.clear();
		for(T element: origin) 
			destination.add(element);
	}
}
