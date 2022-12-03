package saulv.setting.collections.queue;


import saulv.collections.queue.AbstractQueue;
import saulv.collections.queue.ArrayListQueue;

public class ArrayListQueueFactory<T> implements QueueFactory<T> {

	@Override
	public AbstractQueue<T> newQueue() {
		return new ArrayListQueue<T>();
	}

}
