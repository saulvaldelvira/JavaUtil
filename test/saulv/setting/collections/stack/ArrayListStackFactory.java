package saulv.setting.collections.stack;

import saulv.collections.stack.AbstractStack;
import saulv.collections.stack.ArrayListStack;

public class ArrayListStackFactory<T> implements StackFactory<T> {

	@Override
	public AbstractStack<T> newStack() {
		return new ArrayListStack<T>();
	}

}
