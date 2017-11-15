package com.concurrency.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleDeadLockV1 {

	public static void main(String[] args) throws InterruptedException {

		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
		Thread t1 = new Thread(new ThreadA(lock1, lock2));
		Thread t2 = new Thread(new ThreadB(lock1, lock2));

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}
}
