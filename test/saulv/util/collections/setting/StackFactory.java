package saulv.util.collections.setting;

import saulv.util.collections.stack.AbstractStack;

public interface StackFactory<T> {

	AbstractStack<T> newStack();
}
