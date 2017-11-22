package com.concurrency.basic.interruption;

import java.util.concurrent.TimeUnit;

public class InfiniteRunnable2 implements Runnable {

	@Override
	public void run() {

		System.out.println("run()::start");

		/*
		 * for (int i = 0; i < Integer.MAX_VALUE; i++) { 
		 * logic inside does not have impact of thread interruption
		 * }
		 * 
		 */

		System.out.println("run()::loop end");
		boolean isInterrupted1 = Thread.currentThread().isInterrupted();
		if (isInterrupted1)
			System.out.println("isInterrupted1  = " + isInterrupted1);

		boolean interrupted1 = Thread.interrupted();
		if (interrupted1)
			System.out.println("interrupted1  = " + interrupted1);

		System.out.println("run()::end");
	}

	public static void main(String[] args) throws Exception {
		Thread thrd = new Thread(new InfiniteRunnable2());
		thrd.start();
		TimeUnit.SECONDS.sleep(3);
		thrd.interrupt();

		// System.out.printf("Main: Status of the Thread: %s\n",
		// thrd.getState());
		// System.out.printf("Main: isInterrupted: %s\n", thrd.isInterrupted());
		// System.out.printf("Main: isAlive: %s\n", thrd.isAlive());

	}
}
