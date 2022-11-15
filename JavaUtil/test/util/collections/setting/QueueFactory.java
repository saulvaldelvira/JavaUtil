/**
 * 
 */
package util.collections.setting;

import util.collections.queue.AbstractQueue;

/**
 * @author Saúl
 * @param <T>
 *
 */
public interface QueueFactory<T> {

	AbstractQueue<T> newQueue();
	
}
