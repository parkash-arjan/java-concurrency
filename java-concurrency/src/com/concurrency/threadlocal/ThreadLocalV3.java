package com.concurrency.threadlocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocalV3 {

	public static void main(String[] args) throws InterruptedException {
		TestThreadV3 testThreadV3 = new TestThreadV3(Integer.valueOf(2379));

		Thread t1 = new Thread(testThreadV3);
		Thread t2 = new Thread(testThreadV3);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}

class TestThreadV3 implements Runnable {

	private ThreadLocal<Integer> threadLocalData = new ThreadLocal<>();
	private Integer data;

	public TestThreadV3(Integer data) {
		this.data = data;
	}

	@Override

	public void run() {

		threadLocalData.set(this.data + 1); //race condition
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :: Data from ThreadLocal store = " + threadLocalData.get());// might output 2380 or 2381 or mix
	}
}