/**
 * 
 */
package saulv.collections.setting;

import saulv.collections.queue.AbstractQueue;

/**
 * @author Saúl
 * @param <T>
 *
 */
public interface QueueFactory<T> {

	AbstractQueue<T> newQueue();
	
}
