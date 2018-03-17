package com.concurrency.producer.consumer.workflow;

public class Job {
	private int id;

	public Job(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
