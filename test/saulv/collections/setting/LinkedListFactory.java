package saulv.collections.setting;


import saulv.collections.LinkedList;
import saulv.collections.List;

public class LinkedListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new LinkedList<T>();
	}

}
