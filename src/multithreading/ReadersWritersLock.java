package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Really simple Readers biased ReaderWriterLock implentation. Readers and
 * Writers are mutually excluded from each other, however readers are not
 * amongst themselves. This causes multiple reader threads to behave as if they
 * have access to shared resource but if a writer holds the lock none of readers
 * or any other writer can grab it
 * 
 * This is Readers biased. Ex: Bunch of Readers followed by a Writer followed by
 * a bunch of Readers. In this scenario all readers are serviced before writer
 * gets a chance.
 * 
 * @author Tej Vepa
 *
 */
public class ReadersWritersLock {

	Lock resourceLock = new ReentrantLock();
	Lock readersLock = new ReentrantLock();
	int readersCount = 0;

	public void readLock() {
		readersLock.lock();
		if (readersCount == 0) {
			resourceLock.lock();
		}
		readersCount++;
		readersLock.unlock();
	}

	public void readUnlock() {
		readersLock.lock();
		--readersCount;
		if (readersCount == 0) {
			resourceLock.unlock();
		}
		readersLock.unlock();
	}

	public void writeLock() {
		resourceLock.lock();
	}

	public void writeUnlock() {
		resourceLock.unlock();
	}
}
