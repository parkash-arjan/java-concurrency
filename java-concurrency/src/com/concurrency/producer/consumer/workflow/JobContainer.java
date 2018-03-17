/**
 * 
 */
package com.concurrency.producer.consumer.workflow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author parjan
 *
 */
public class JobContainer {
	private List<Job> waitingJobs = new ArrayList<>();
	private List<Job> readyJobs = new ArrayList<>();

	public List<Job> getWaitingJobs() {
		return waitingJobs;
	}

	public JobContainer() {
	}

	public void putInWaitingContainer(Job job) {
		waitingJobs.add(job);
	}

	public void putInReadyContainer(Job job) {
		readyJobs.add(job);
	}
}
