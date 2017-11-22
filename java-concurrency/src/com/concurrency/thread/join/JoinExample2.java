package com.concurrency.thread.join;

import java.util.concurrent.TimeUnit;

public class JoinExample2 {

	public static void main(String[] args) {
		System.out.println("Main::Started.");

		try {
			Thread wsThrd = callWebservice();
			wsThrd.start();

			Thread dbThrd = callDatabase();
			dbThrd.start();

			wsThrd.join();
			dbThrd.join();
		} catch (InterruptedException e) {
			System.err.println(" main thread interrupted " + e.getMessage());
		}
		System.out.println("Main::Ended.");
	}

	public static Thread callWebservice() {
		Thread thread = new Thread(() -> {
			System.out.println("Calling Web service...");
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				System.err.println(" thread interrupted " + e.getMessage());
			}
			System.out.println("Web service call completed..");
		});

		return thread;

	}

	public static Thread callDatabase() {
		Thread thread = new Thread(() -> {
			System.out.println("Performing database operation...");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				System.err.println(" thread interrupted " + e.getMessage());
			}
			System.out.println("database operation completed..");
		});

		return thread;

	}

}
