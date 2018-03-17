package com.concurrency.read.write.lock.cache;

import java.util.Random;
import java.util.concurrent.Callable;

public class Producer implements Callable<String> {
	private Cache cache;

	public Producer(Cache cache) {
		this.cache = cache;
	}

	@Override
	public String call() throws Exception {
		Random random = new Random();
		while (true) {
			long key = random.nextInt(100);
			cache.write(key, String.format("Value :: %s", Long.toString(key)));
			if (cache.read(key) == null) {
				System.out.println(String.format("Unable to write %s", key));
			}
		}
		// interestingly no return value due to while true loop;
	}
}
