package com.concurrency.read.write.lock.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private Lock readLock = lock.readLock();
	private Lock writeLock = lock.writeLock();
	private Map<Long, String> cache = new HashMap<>();

	public String read(Long key) {
		readLock.lock();
		try {
			return cache.get(key);
		} finally {
			readLock.unlock();
		}
	}

	public String write(Long key, String value) {
		writeLock.lock();
		try {
			return cache.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}
}
