/**
 * 
 */
package com.arianzhang.thread.learn.lock;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public abstract class IntGenerator {

	private volatile boolean canceled = false;
	public abstract int next();
//	public abstract int next2();
	
	public void cancel(){
		canceled = true;
	}
	
	public boolean isCanceled(){
		return canceled;
	}
}
