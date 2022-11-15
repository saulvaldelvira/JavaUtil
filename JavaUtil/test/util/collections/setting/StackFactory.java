package util.collections.setting;

import util.collections.stack.AbstractStack;

public interface StackFactory<T> {

	AbstractStack<T> newStack();
}
