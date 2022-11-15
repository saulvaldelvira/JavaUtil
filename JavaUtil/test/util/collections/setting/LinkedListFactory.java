package util.collections.setting;


import util.collections.LinkedList;
import util.collections.List;

public class LinkedListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new LinkedList<T>();
	}

}
