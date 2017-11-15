package com.concurrency.threads;

import java.util.concurrent.TimeUnit;

public class ThreadLocalV1 {

	public static void main(String[] args) throws InterruptedException {

		TestThreadV1 testThreadV1 = new TestThreadV1(Integer.valueOf(2379));

		Thread t1 = new Thread(testThreadV1);
		Thread t2 = new Thread(testThreadV1);

		t1.start();
		// TimeUnit.SECONDS.sleep(1); //will cause thread to sleep and we might get out
		// like 2380 followed by 2381
		t2.start();

		t1.join();
		t2.join();
	}

}

class TestThreadV1 implements Runnable {
	private Integer data;

	public TestThreadV1(Integer data) {
		this.data = data;
	}

	@Override

	public void run() {
		data = data + 1;
		// try {
		// TimeUnit.SECONDS.sleep(1);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		System.out.println(Thread.currentThread().getName() + " :: Data = " + data); // may output 2380 or 2381 or mix
	}
}