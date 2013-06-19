/**
 * 
 */
package com.arianzhang.thread.learn.critical;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class ExplicitCriticalSection {

	public static void main(String[] args) {
		PairManager pm1 = new ExplicitPairManager1(), pm2= new ExplicitPairManager2();
		CriticalSection.testApproaches(pm1, pm2);
	}
}
class ExplicitPairManager1 extends PairManager{

	private Lock lock = new ReentrantLock();
	
	/* (non-Javadoc)
	 * @see com.arianzhang.thread.learn.critical.PairManager#increment()
	 */
	@Override
	public synchronized void increment() {
		lock.lock();
		try{
			super.increment();
		}finally{
			lock.unlock();
		}
	}
	
	
}

//Use a critical section
class ExplicitPairManager2 extends PairManager{

	private Lock lock = new ReentrantLock();
	/* (non-Javadoc)
	 * @see com.arianzhang.thread.learn.critical.PairManager#increment()
	 */
	@Override
	public void increment() {
		lock.lock();
		try{
			super.increment();
		}finally{
			lock.unlock();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.arianzhang.thread.learn.critical.PairManager#getPair()
	 */
	@Override
	public Pair getPair() {
		lock.lock();
		try{
			return super.getPair();
		}finally{
			lock.unlock();
		}
	}
}