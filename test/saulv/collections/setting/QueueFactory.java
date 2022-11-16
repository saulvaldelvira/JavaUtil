/**
 * 
 */
package saulv.collections.setting;

import saulv.collections.queue.AbstractQueue;

/**
 * @author Sa�l
 * @param <T>
 *
 */
public interface QueueFactory<T> {

	AbstractQueue<T> newQueue();
	
}
