package com.threadlocal.sample;

public class TransactionThread extends Thread {

	TransactionManager transactionManager = TransactionManager.getInstance();

	@Override
	public void run() {

		Transaction transaction = new Transaction();
		transaction.setId(Thread.currentThread().getName());

		transactionManager.set(transaction);

		TransactionService transactionService = new TransactionService();
		transactionService.perform();

	}

}
