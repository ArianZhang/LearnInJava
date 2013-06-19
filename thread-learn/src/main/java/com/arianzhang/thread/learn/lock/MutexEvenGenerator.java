/**
 * 
 */
package com.arianzhang.thread.learn.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class MutexEvenGenerator extends IntGenerator{

	private int currentEvenInt = 0;
	private Lock lock = new ReentrantLock();
	private ReentrantReadWriteLock lock2 = new  ReentrantReadWriteLock();
	/* (non-Javadoc)
	 * @see com.arianzhang.thread.learn.lock.IntGenerator#next()
	 */
	@Override
	public int next() {
		lock.lock();
		try{
			++currentEvenInt;
//			Thread.currentThread().yield();
			++currentEvenInt;
			return currentEvenInt;
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}
}
