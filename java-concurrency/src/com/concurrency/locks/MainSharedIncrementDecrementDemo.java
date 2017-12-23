package com.concurrency.locks;

public class MainSharedIncrementDecrementDemo {

	public static void main(String[] args) throws InterruptedException{

		SharedCounter counter = new SharedCounter();
		Thread incrementThread = new Thread((new IncrementThread(counter)));
		Thread decrementThread = new Thread((new DecrementThread(counter)));
		
		incrementThread.start();
		decrementThread.start();

		
		incrementThread.join();
		decrementThread.join();
		System.out.println( counter.getValue() );
		
	}
}
