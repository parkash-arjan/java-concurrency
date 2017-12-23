package com.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter {

	private Lock lock = new ReentrantLock();
	private int count = 0;

	public void increment() {
		try {
			lock.lock();
			count++;
		} finally {
			lock.unlock();
		}

	}

	public void decrement() {
		try {
			lock.lock();
			count--;
		} finally {
			lock.unlock();
		}
	}

	public int getValue() {
		return this.count;
	}

}
