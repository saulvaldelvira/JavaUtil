/**
 * 
 */
package saulv.util.collections.setting;

import saulv.util.collections.queue.AbstractQueue;

/**
 * @author Saúl
 * @param <T>
 *
 */
public interface QueueFactory<T> {

	AbstractQueue<T> newQueue();
	
}
