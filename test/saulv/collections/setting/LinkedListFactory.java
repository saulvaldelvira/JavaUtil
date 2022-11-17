package saulv.collections.setting;


import java.util.List;

import saulv.collections.list.LinkedList;

public class LinkedListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new LinkedList<T>();
	}

}
