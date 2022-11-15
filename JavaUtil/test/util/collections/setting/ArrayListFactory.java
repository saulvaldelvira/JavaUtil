package util.collections.setting;

import util.collections.ArrayList;
import util.collections.List;

public class ArrayListFactory<T> implements ListFactory<T> {

	@Override
	public List<T> newList() {
		return new ArrayList<T>();
	}

}
