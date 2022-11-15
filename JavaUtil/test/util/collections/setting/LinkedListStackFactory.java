package util.collections.setting;

import util.collections.stack.AbstractStack;
import util.collections.stack.LinkedListStack;

public class LinkedListStackFactory<T> implements StackFactory<T> {

	@Override
	public AbstractStack<T> newStack() {
		return new LinkedListStack<T>();
	}

}
