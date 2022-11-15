package util.collections.setting;


import util.collections.queue.AbstractQueue;
import util.collections.queue.ArrayListQueue;

public class ArrayListQueueFactory<T> implements QueueFactory<T> {

	@Override
	public AbstractQueue<T> newQueue() {
		return new ArrayListQueue<T>();
	}

}
