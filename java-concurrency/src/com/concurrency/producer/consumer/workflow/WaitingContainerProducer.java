package com.concurrency.producer.consumer.workflow;

import java.util.concurrent.TimeUnit;

public class WaitingContainerProducer {
	private JobContainer jobContainer;

	public WaitingContainerProducer(JobContainer jobContainer) {
		this.jobContainer = jobContainer;
	}

	public void putInWaitingContainer() throws InterruptedException {
		for (int i = 0; i < IConstants.MAX_JOBS; i++) {
			Job job = new Job(i);
			jobContainer.putInWaitingContainer(job);
			TimeUnit.SECONDS.sleep(5);
		}
	}
}
