/**
 * 
 */
package util.collections.setting;

import util.collections.queue.AbstractQueue;

/**
 * @author Sa�l
 * @param <T>
 *
 */
public interface QueueFactory<T> {

	AbstractQueue<T> newQueue();
	
}
