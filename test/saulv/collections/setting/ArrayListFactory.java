package saulv.collections.setting;

import saulv.collections.ArrayList;
import saulv.collections.List;

public class ArrayListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new ArrayList<T>();
	}

}
