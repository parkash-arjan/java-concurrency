package com.threadlocal.sample;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new TransactionThread();
		t1.start();

		Thread t2 = new TransactionThread();
		t2.start();

		t1.join();
		t2.join();
	}
}
