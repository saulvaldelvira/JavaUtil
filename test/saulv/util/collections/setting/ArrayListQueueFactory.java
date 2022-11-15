package saulv.util.collections.setting;


import saulv.util.collections.queue.AbstractQueue;
import saulv.util.collections.queue.ArrayListQueue;

public class ArrayListQueueFactory<T> implements QueueFactory<T> {

	@Override
	public AbstractQueue<T> newQueue() {
		return new ArrayListQueue<T>();
	}

}
