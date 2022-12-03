package saulv.setting.collections.stack;

import saulv.collections.stack.AbstractStack;

public interface StackFactory<T> {

	AbstractStack<T> newStack();
}
