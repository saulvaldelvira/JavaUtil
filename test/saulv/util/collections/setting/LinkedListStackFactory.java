package saulv.util.collections.setting;

import saulv.util.collections.stack.AbstractStack;
import saulv.util.collections.stack.LinkedListStack;

public class LinkedListStackFactory<T> implements StackFactory<T> {

	@Override
	public AbstractStack<T> newStack() {
		return new LinkedListStack<T>();
	}

}
