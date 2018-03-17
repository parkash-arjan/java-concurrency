package com.concurrency.producer.consumer.v2;

import java.util.concurrent.Callable;

public class Producer implements Callable<String> {
	private Resource resource;

	public Producer(Resource resource) {
		this.resource = resource;
	}

	@Override
	public String call() throws Exception {
		resource.getReentrantLock().lock();
		Integer value = Integer.valueOf(0);
		while (++value <= 50) {
			while (resource.isBufferFull()) {
				resource.getFullCondition().await();
			}
			resource.add(value);
			resource.getEmptyCondition().signal();
		}
		--value;
		resource.getReentrantLock().unlock();
		return String.format("Tried to produced :: %s values", value.toString());
	}
}
