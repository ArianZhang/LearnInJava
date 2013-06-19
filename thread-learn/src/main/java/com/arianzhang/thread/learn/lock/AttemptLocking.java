/**
 * 
 */
package com.arianzhang.thread.learn.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class AttemptLocking {

	private ReentrantLock lock = new ReentrantLock();

	public void untimed() {
		boolean captured = lock.tryLock();
		try {
			System.out.println("tryLock() : " + captured);
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
	}

	public void timed() {
		boolean captured = false;
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		try {
			System.out.println("tryLock(2,TimeUnit.SECONDS) : " + captured);
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final AttemptLocking al = new AttemptLocking();
		al.untimed(); //TRUE -- lock is available
		al.timed();// TRUE -- lock is available
		// New create a separate task to grab the lock;
		new Thread(){
			{
				setDaemon(false);
			}
			public void run() {
				al.lock.lock();
				System.out.println("acquired!");
			};
		}.start();
		Thread.sleep(1000);
		al.untimed();
		al.timed();
	}

}
