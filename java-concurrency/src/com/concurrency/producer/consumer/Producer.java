package com.concurrency.producer.consumer;

public class Producer implements Runnable {

	private SharedCounter counter;

	public Producer(SharedCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		perform();
	}

	private void perform() {
		for (int i = 1; i <= 10; i++) {
			try {
				counter.increment();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
