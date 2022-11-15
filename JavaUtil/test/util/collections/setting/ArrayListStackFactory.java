package util.collections.setting;

import util.collections.stack.AbstractStack;
import util.collections.stack.ArrayListStack;

public class ArrayListStackFactory<T> implements StackFactory<T> {

	@Override
	public AbstractStack<T> newStack() {
		return new ArrayListStack<T>();
	}

}
