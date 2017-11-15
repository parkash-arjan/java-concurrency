package com.concurrency.threads;

import java.util.concurrent.TimeUnit;

public class ThreadLocalV2 {

	public static void main(String[] args) throws InterruptedException {

		TestThreadV2 testThreadV2 = new TestThreadV2(Integer.valueOf(2379));

		Thread t1 = new Thread(testThreadV2);
		Thread t2 = new Thread(testThreadV2);

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

}

class TestThreadV2 implements Runnable {

	private ThreadLocal<Integer> threadLocalData = new ThreadLocal<>();

	public TestThreadV2(Integer data) {
		
		threadLocalData.set(data + 1);
		//System.out.println(" Constructor  " + Thread.currentThread().getName()); // should output main thread.
	}

	@Override

	public void run() {
		// threadLocalData.set(threadLocalData.get() + 1);

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :: Data from ThreadLocal store = " + threadLocalData.get()); //should output null
	}
}