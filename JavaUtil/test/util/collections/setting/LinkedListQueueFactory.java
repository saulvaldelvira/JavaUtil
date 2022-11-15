package util.collections.setting;

import util.collections.queue.AbstractQueue;
import util.collections.queue.LinkedListQueue;

public class LinkedListQueueFactory<T> implements QueueFactory<T> {

	@Override
	public AbstractQueue<T> newQueue() {
		return new LinkedListQueue<T>();
	}

}
