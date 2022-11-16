package saulv.collections.setting;

import saulv.collections.list.ArrayList;
import saulv.collections.list.List;

public class ArrayListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new ArrayList<T>();
	}

}
