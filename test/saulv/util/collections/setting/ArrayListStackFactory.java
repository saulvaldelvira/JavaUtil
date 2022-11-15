package saulv.util.collections.setting;

import saulv.util.collections.stack.AbstractStack;
import saulv.util.collections.stack.ArrayListStack;

public class ArrayListStackFactory<T> implements StackFactory<T> {

	@Override
	public AbstractStack<T> newStack() {
		return new ArrayListStack<T>();
	}

}
