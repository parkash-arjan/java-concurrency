package com.concurrency.thread.join;

import java.util.concurrent.TimeUnit;

public class JoinExample {

	public static void main(String[] args) {
		System.out.println("Main::Started.");
		Thread thread = new Thread(() -> {
			System.out.println("Doing task in thread");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				System.err.println(" thread interrupted " + e.getMessage());
			}
			System.out.println("task completed in thread");
		});

		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.err.println(" main thread interrupted " + e.getMessage());
		}
		System.out.println("Main::Ended.");
	}

}
