package saulv.util.collections.setting;


import saulv.util.collections.LinkedList;
import saulv.util.collections.List;

public class LinkedListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new LinkedList<T>();
	}

}
