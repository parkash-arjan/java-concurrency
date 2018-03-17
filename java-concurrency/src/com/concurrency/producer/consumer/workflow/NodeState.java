package com.concurrency.producer.consumer.workflow;

import java.util.concurrent.atomic.AtomicInteger;

public class NodeState {
	AtomicInteger concurrentWorkers = new AtomicInteger(0);

	private NodeState() {
	}

	public AtomicInteger getConcurrentWorkers() {
		return concurrentWorkers;
	}

	public void setConcurrentWorkers(AtomicInteger concurrentWorkers) {
		this.concurrentWorkers = concurrentWorkers;
	}
}
