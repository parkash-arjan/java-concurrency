package com.concurrency.producer.consumer;

public class MainProducerConsumerDemo {

	public static void main(String[] args) throws InterruptedException {

		SharedCounter counter = new SharedCounter();
		Thread incrementThread = new Thread((new Producer(counter)));
		Thread decrementThread = new Thread((new Consumer(counter)));

		incrementThread.start();
		decrementThread.start();

		incrementThread.join();
		decrementThread.join();
		System.out.println(counter.getValue());

	}
}
