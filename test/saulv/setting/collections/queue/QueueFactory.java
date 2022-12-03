/**
 * 
 */
package saulv.setting.collections.queue;

import saulv.collections.queue.AbstractQueue;

/**
 * @author Saúl
 * @param <T>
 *
 */
public interface QueueFactory<T> {

	AbstractQueue<T> newQueue();
	
}
