package com.concurrency.threadlocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocalV4 {

	public static void main(String[] args) throws InterruptedException {
		TestThreadV4 testThread = new TestThreadV4();

		Thread t1 = new Thread(testThread);
		Thread t2 = new Thread(testThread);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}

class TestThreadV4 implements Runnable {

	private ThreadLocal<String> threadLocalData = new ThreadLocal<>();

	@Override

	public void run() {

		threadLocalData.set(Thread.currentThread().getName()); 
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :: Data from ThreadLocal store = " + threadLocalData.get());// out thread name
	}
}