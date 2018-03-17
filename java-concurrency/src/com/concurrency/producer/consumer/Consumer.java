package com.concurrency.producer.consumer;

public class Consumer implements Runnable {

	private SharedCounter counter;

	public Consumer(SharedCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		perform();
	}

	private void perform() {
		for (int i = 1; i <= 10; i++) {
			try {
				counter.decrement();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
