package saulv.collections.setting;


import saulv.collections.list.LinkedList;
import saulv.collections.list.List;

public class LinkedListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new LinkedList<T>();
	}

}
