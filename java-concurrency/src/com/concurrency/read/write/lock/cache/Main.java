package com.concurrency.read.write.lock.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		// runs infinitely/until outofmemory error, adds values to the cache;
		Cache cache = new Cache();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		System.out.println("Here we go!!!");
		try {
			for (int i = 0; i < 10; i++) {
				executor.submit(new Producer(cache));
			}
		} finally {
			executor.shutdown();
		}
	}
}
