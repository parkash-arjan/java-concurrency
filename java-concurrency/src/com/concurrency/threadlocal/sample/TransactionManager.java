package com.concurrency.threadlocal.sample;

import java.util.concurrent.atomic.AtomicInteger;

public class TransactionManager {

	private static TransactionManager manager;

	private static AtomicInteger count = new AtomicInteger(0);

	private TransactionManager() {

	}

	public static TransactionManager getInstance() {

		if (count.get() == 0) {
			manager = new TransactionManager();
			count.incrementAndGet();
		}

		return manager;
	}

	private ThreadLocal<Transaction> threadLocal = new ThreadLocal<>();

	public void set(Transaction transaction) {
		threadLocal.set(transaction);
	}

	public Transaction get() {
		return threadLocal.get();
	}
}
