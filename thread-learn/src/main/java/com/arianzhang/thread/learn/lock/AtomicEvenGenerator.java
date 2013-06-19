/**
 * 
 */
package com.arianzhang.thread.learn.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class AtomicEvenGenerator extends IntGenerator {
	
	private AtomicInteger i = new AtomicInteger(0);

	/* (non-Javadoc)
	 * @see com.arianzhang.thread.learn.lock.IntGenerator#next()
	 */
	@Override
	public int next() {
		return i.addAndGet(2);
	}

	public static void main(String[] args) {
		EvenChecker.test(new AtomicEvenGenerator());
	}
}
