/**
 * 
 */
package com.arianzhang.thread.learn.runable;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class LiftOff implements Runnable {

	protected int countDown = 10; // default

	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {

	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	/**
	 * 
	 */
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liffoff!")
				+ "). ";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
//			Thread.yield();
		}
	}

}
