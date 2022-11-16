package saulv.collections.setting;

import saulv.collections.stack.AbstractStack;

public interface StackFactory<T> {

	AbstractStack<T> newStack();
}
