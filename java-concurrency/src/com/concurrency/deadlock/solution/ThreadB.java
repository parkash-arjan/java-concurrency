package com.concurrency.deadlock.solution;

import java.util.concurrent.locks.Lock;

public class ThreadB implements Runnable {

	private Lock lock1;
	private Lock lock2;

	public ThreadB(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run() {
		System.out.println("Start -> run()::ThreadB");

		lock1.lock();
		System.out.println("lock2.lock() -> run()::ThreadB");

		lock2.lock();
		System.out.println("lock1.lock() -> run()::ThreadB");

		lock2.unlock();
		System.out.println("lock1.unlock() -> run()::ThreadB");

		lock1.unlock();
		System.out.println("lock2.unlock() -> run()::ThreadB");

		System.out.println("End -> run()::ThreadB");
	}
}
