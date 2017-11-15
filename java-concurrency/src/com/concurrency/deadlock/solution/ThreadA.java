package com.concurrency.deadlock.solution;

import java.util.concurrent.locks.Lock;

public class ThreadA implements Runnable {
	private Lock lock1;
	private Lock lock2;

	public ThreadA(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run() {
		System.out.println("Start -> run()::ThreadA");

		lock1.lock();
		System.out.println("lock1.lock() -> run()::ThreadA");

		lock2.lock();
		System.out.println("lock2.lock() -> run()::ThreadA");

		lock2.unlock();
		System.out.println("lock2.unlock() -> run()::ThreadA");

		lock1.unlock();
		System.out.println("lock1.unlock() -> run()::ThreadA");

		System.out.println("End -> run()::ThreadA");
	}

}
