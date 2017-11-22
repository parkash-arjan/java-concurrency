package com.concurrency.basic.interruption;

import java.util.concurrent.TimeUnit;

public class InfiniteRunnable implements Runnable {

	@Override
	public void run() {

		while (true) {

			boolean isInterrupted1 = Thread.currentThread().isInterrupted();
			if (isInterrupted1)
				System.out.println("isInterrupted1  = " + isInterrupted1);

			boolean interrupted1 = Thread.interrupted();
			if (interrupted1)
				System.out.println("interrupted1  = " + interrupted1);

		}
	}

	public static void main(String[] args) throws Exception {
		Thread thrd = new Thread(new InfiniteRunnable());
		thrd.start();
		TimeUnit.SECONDS.sleep(3);
		thrd.interrupt();

		// System.out.printf("Main: Status of the Thread: %s\n",
		// thrd.getState());
		// System.out.printf("Main: isInterrupted: %s\n", thrd.isInterrupted());
		// System.out.printf("Main: isAlive: %s\n", thrd.isAlive());

	}
}
