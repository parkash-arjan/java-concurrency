package com.concurrency.producer.consumer.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
	private List<Integer> buffer = new ArrayList<>();
	private Lock reentrantLock = new ReentrantLock();
	private Condition fullCondition = reentrantLock.newCondition();
	private Condition emptyCondition = reentrantLock.newCondition();

	public void add(Integer value) {
		buffer.add(value);
	}

	public Integer remove(Integer value) {
		return buffer.remove(value) == true ? value : -1;
	}

	public Lock getReentrantLock() {
		return reentrantLock;
	}

	public void setReentrantLock(Lock reentrantLock) {
		this.reentrantLock = reentrantLock;
	}

	public Condition getFullCondition() {
		return fullCondition;
	}

	public Condition getEmptyCondition() {
		return emptyCondition;
	}

	public List<Integer> getBuffer() {
		return buffer;
	}

	public boolean isBufferEmpty() {
		return buffer.size() == 0;
	}
	
	
	public boolean isBufferFull() {
		return buffer.size() == 50;
	}	
	
}
