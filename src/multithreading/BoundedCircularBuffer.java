package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Kind of similar to array blocking queue. Can be used in producer consumer
 * problem.
 * 
 * @author venkata.vepa
 *
 */
public class BoundedCircularBuffer {

	final int[] buffer;
	int putPtr, getPtr;
	private int count = 0;
	private final int MAX_CAPACITY;
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	public BoundedCircularBuffer(final int capacity) {
		this.buffer = new int[capacity];
		MAX_CAPACITY = capacity;
	}

	public void put(int item) throws InterruptedException {
		lock.lock();
		try {
			while (count == MAX_CAPACITY)
				notFull.await();
			buffer[putPtr++] = item;
			if (putPtr == buffer.length)
				putPtr = 0;
			++count;
			notEmpty.await();
		} finally {
			lock.unlock();
		}
	}

	public int get() throws InterruptedException {
		lock.lock();
		while (count == 0)
			notEmpty.await();
		int item = buffer[getPtr++];
		if (getPtr == buffer.length)
			getPtr = 0;
		--count;
		notFull.await();
		lock.unlock();
		return item;
	}

}
