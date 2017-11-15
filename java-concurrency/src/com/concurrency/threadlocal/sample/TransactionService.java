package com.concurrency.threadlocal.sample;

public class TransactionService {

	public void perform() {

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.get();
		System.out.println(transaction.getId());
	}
}
