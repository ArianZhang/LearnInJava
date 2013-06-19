/**
 * 
 */
package com.arianzhang.thread.learn.runable;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class SimplePriorities implements Runnable {

	private int countDown = 5;
	private volatile double d; // No optimization
	private int priority;

	public SimplePriorities(int priority) {
		this.priority = priority;
	}

	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			// An expensive, interruptable operation
			for (int i = 1; i < 10000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0) {
					Thread.yield();
				}
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}
}
