package com.concurrency.locks;

public class IncrementThread implements Runnable {

	private SharedCounter counter;

	public IncrementThread(SharedCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			counter.increment();
		}
	}
}
