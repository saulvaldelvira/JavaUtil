package saulv.util.collections.setting;

import saulv.util.collections.queue.AbstractQueue;
import saulv.util.collections.queue.LinkedListQueue;

public class LinkedListQueueFactory<T> implements QueueFactory<T> {

	@Override
	public AbstractQueue<T> newQueue() {
		return new LinkedListQueue<T>();
	}

}
