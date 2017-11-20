package com.concurrency.basic;

import java.lang.Thread.State;

public class MainThreadInfo {

	public static void main(String[] args) {
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		State state = Thread.currentThread().getState();
		String threadGroupName = Thread.currentThread().getThreadGroup().getName();
		System.out.println("Main thread id=" + id);
		System.out.println("Main thread name=" + name);
		System.out.println("Main thread  priority=" + priority);
		System.out.println("Main thread state=" + state);
		System.out.println("Main thread thread groupname=" + threadGroupName);
	}
}
