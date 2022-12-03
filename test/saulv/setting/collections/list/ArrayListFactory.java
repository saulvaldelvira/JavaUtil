package saulv.setting.collections.list;

import java.util.List;

import saulv.collections.list.ArrayList;

public class ArrayListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new ArrayList<T>();
	}

}
