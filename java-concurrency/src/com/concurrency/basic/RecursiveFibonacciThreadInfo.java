package com.concurrency.basic;

public class RecursiveFibonacciThreadInfo implements Runnable {

	private long input = 0;

	public RecursiveFibonacciThreadInfo(long input) {
		this.input = input;
	}

	@Override
	public void run() {
		System.out.printf("run() Name = '%s': State = %s Priority = %d\n", Thread.currentThread().getName(), Thread.currentThread().getState(), Thread.currentThread().getPriority());
		System.out.printf("run() Name - '%s': finshed. %dth fibonacci is : %d\n", Thread.currentThread().getName(), input, fibonacci(input));
	}

	/* 0,1,1,2,3,5,8 */
	private long fibonacci(long ithFibonacci) {

		if (ithFibonacci <= 1) {
			return ithFibonacci;
		} else {
			return fibonacci(ithFibonacci - 1) + fibonacci(ithFibonacci - 2);
		}

	}

}
