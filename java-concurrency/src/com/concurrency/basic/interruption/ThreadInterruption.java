package com.concurrency.basic.interruption;

public class ThreadInterruption implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			System.out.println("[" + Thread.currentThread().getName() + "] Interrupted by exception!");
			System.out.println(" State of the thread " + Thread.currentThread().getState());
		}
		System.out.println(" Thread.interrupted()-1 " + Thread.currentThread().interrupted());
		System.out.println(" Thread.interrupted()-1 " + Thread.currentThread().isInterrupted());

		while (!Thread.interrupted()) {
			// System.out.println(".");
		}
		System.out.println(" Thread.interrupted()-2 " + Thread.currentThread().interrupted());
		System.out.println(" Thread.interrupted()-2 " + Thread.currentThread().isInterrupted());
		System.out.println("[" + Thread.currentThread().getName() + "] Interrupted for the second time.");
	}

	public static void main(String[] args) throws InterruptedException {
		Thread myThread = new Thread(new ThreadInterruption(), "myThread");
		myThread.start();
		System.out.println("[" + Thread.currentThread().getName() + "] Sleeping in main thread for 5s...");
		Thread.sleep(5000);
		System.out.println("[" + Thread.currentThread().getName() + "]  Interrupting myThread");
		myThread.interrupt();
		// System.out.println("[" + Thread.currentThread().getName() + "]
		// Sleeping in main thread for 5s...");
		// Thread.sleep(5000);
		// System.out.println("[" + Thread.currentThread().getName() + "]
		// Interrupting myThread");
		// myThread.interrupt();
		// Thread.sleep(5000);
		System.out.println("Finished :: main()");
	}
}
