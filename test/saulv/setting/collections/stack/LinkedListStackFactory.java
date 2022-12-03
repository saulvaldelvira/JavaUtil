package saulv.setting.collections.stack;

import saulv.collections.stack.AbstractStack;
import saulv.collections.stack.LinkedListStack;

public class LinkedListStackFactory<T> implements StackFactory<T> {

	@Override
	public AbstractStack<T> newStack() {
		return new LinkedListStack<T>();
	}

}
