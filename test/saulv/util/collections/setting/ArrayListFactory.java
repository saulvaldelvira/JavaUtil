package saulv.util.collections.setting;

import saulv.util.collections.ArrayList;
import saulv.util.collections.List;

public class ArrayListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new ArrayList<T>();
	}

}
