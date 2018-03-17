package com.concurrency.producer.consumer.workflow;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitingContainerConsumer {
}

class Consumer implements Runnable {
	private JobContainer jobContainer;
	private NodeState nodeState;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public Consumer(JobContainer jobContainer, NodeState nodeState) {
		this.jobContainer = jobContainer;
		this.nodeState = nodeState;
	}

	@Override
	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
		} finally {
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			if (nodeState.concurrentWorkers.get() < IConstants.MAX_JOBS) {
				Job jobToBeConsumed = jobContainer.getWaitingJobs().remove(0);
				jobContainer.putInReadyContainer(jobToBeConsumed);
			} else {
				lock.lock();
				condition.await();
				try {
				} finally {
					lock.unlock();
				}
			}
		}
	}
}