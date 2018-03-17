package com.concurrency.producer.consumer.v2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		Resource resource = new Resource();
		Consumer consumer = new Consumer(resource);
		Producer producer = new Producer(resource);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		try {
			Future<String> futureProducer = executor.submit(producer);
			Future<String> futureConsumer = executor.submit(consumer);
			try {
				System.out.println(String.format(" Results , %s %s :: final size of buffer :: %s  ", futureProducer.get(), futureConsumer.get(), resource.getBuffer().size()));
				System.out.println(resource.getBuffer());
			} catch (InterruptedException | ExecutionException exception) {
				System.out.println(exception);
			}
		} finally {
			executor.shutdown();
		}
	}
}
