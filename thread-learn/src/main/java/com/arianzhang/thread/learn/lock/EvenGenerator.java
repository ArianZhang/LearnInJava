/**
 * 
 */
package com.arianzhang.thread.learn.lock;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class EvenGenerator extends IntGenerator {

	private int currentEvenInt = 0;
//	boolean out = true;
	/* (non-Javadoc)
	 * @see com.arianzhang.thread.learn.lock.IntGenerator#next()
	 */
	@Override
	public synchronized int next() {
//		while(out){
			++currentEvenInt;
			++currentEvenInt;
//		}
		return currentEvenInt;
	}
	
	public synchronized int next2(){
		// next1 and next2 has the same lockerb.
		++currentEvenInt;
		++currentEvenInt;
		System.out.println("entering next2()");
		return currentEvenInt;
	}

}
