package saulv.setting.collections.queue;

import saulv.collections.queue.AbstractQueue;
import saulv.collections.queue.LinkedListQueue;

public class LinkedListQueueFactory<T> implements QueueFactory<T> {

	@Override
	public AbstractQueue<T> newQueue() {
		return new LinkedListQueue<T>();
	}

}
