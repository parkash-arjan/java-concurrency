package com.concurrency.producer.consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter {

	private Lock lock = new ReentrantLock();
	// private Condition condition = lock.newCondition();
	private Condition incrementCondition = lock.newCondition();
	private Condition decrementCondition = lock.newCondition();
	private int count = 0;

	public void increment() throws InterruptedException {
		try {
			lock.lock();
			count++;
			System.out.println(" Produced " + count);
			if (count == 10 /* || count == 20 || count == 30 */) {
				System.out.println("Producer()::waiting");
				decrementCondition.signal();
				incrementCondition.await();
			}

		} finally {
			// decrementCondition.signal();
			System.out.println("Producer()::unlocked");
			lock.unlock();

		}

	}

	public void decrement() throws InterruptedException {
		try {
			lock.lock();

			if (count <= 0) {
				System.out.println("Consumer()::waiting");
				incrementCondition.signal();
				decrementCondition.await();
			} else {
				System.out.println(" Consumed " + count);
				count--;
			}
		} finally {
			// incrementCondition.signal();
			System.out.println("Consumer()::unlocked");
			lock.unlock();

		}
	}

	public int getValue() {
		return this.count;
	}

}
