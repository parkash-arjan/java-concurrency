package com.concurrency.basic;

import java.lang.Thread.State;

public class MainRecursiveFibonacciThreadInfo {

	// fibonacci less than 46 will return in reasonable time
	private static final int FIBONACCI = 36;

	public static void main(String[] args) {

		System.out.println("Main thread started");

		printThreadPriority();
		Thread[] threadArr = new Thread[10];

		for (int i = 0; i < 10; i++) {

			RecursiveFibonacciThreadInfo recursiveFibonacciThreadInfo = new RecursiveFibonacciThreadInfo(i + FIBONACCI);
			threadArr[i] = new Thread(recursiveFibonacciThreadInfo, "Exponential/Recursive Fibonacci Thread-" + i);
			threadArr[i].setPriority(i + 1);

		}

		for (int i = 0; i < threadArr.length; i++) {
			System.out.println("Loop#1 " + threadArr[i].getName() + " State = " + threadArr[i].getState());// NEW

		}

		for (int i = 0; i < threadArr.length; i++) {
			threadArr[i].start();
			System.out.println("Loop#2 " + threadArr[i].getName() + " State = " + threadArr[i].getState());// RUNNABLE
		}

		boolean areAllThreadsTerminated = true;
		do {

			areAllThreadsTerminated = true;
			for (int i = 0; i < threadArr.length; i++) {
				areAllThreadsTerminated = areAllThreadsTerminated && (threadArr[i].getState() == State.TERMINATED);
			}

		} while (!areAllThreadsTerminated);

		for (int i = 0; i < threadArr.length; i++) {
			System.out.println("Loop#3" + threadArr[i].getName() + " State = " + threadArr[i].getState());// TERMINATED
		}
		System.out.println("Main thread finished");
	}

	public static void printThreadPriority() {
		System.out.println("Minimum Priority = " + Thread.MIN_PRIORITY);
		System.out.println("Normal/Middle Priority = " + Thread.NORM_PRIORITY);
		System.out.println("Maximum Priority = " + Thread.MAX_PRIORITY);
	}
}
