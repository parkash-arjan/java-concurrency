package com.concurrency.producer.consumer.v2;

import java.util.concurrent.Callable;

public class Consumer implements Callable<String> {
	private Resource resource;

	public Consumer(Resource resource) {
		this.resource = resource;
	}

	@Override
	public String call() throws Exception {
		resource.getReentrantLock().lock();
		Integer value = Integer.valueOf(0);
		while (++value <= 50) {
			while (resource.isBufferEmpty()) {
				resource.getEmptyCondition().await();
			}
			resource.remove(value);
			resource.getFullCondition().signal();
		}
		--value;
		resource.getReentrantLock().unlock();
		return String.format("Tried to consumed :: %s values", value.toString());
	}
}
