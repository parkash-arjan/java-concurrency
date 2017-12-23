package com.concurrency.locks;

public class DecrementThread implements Runnable {

	private SharedCounter counter;

	public DecrementThread(SharedCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			counter.decrement();
		}
	}
}
