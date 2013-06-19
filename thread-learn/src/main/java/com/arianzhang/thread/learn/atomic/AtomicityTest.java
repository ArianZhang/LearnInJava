/**
 * 
 */
package com.arianzhang.thread.learn.atomic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class AtomicityTest implements Runnable {

	private volatile int i =0;
//	private AtomicInteger i = new AtomicInteger(0);
	public int getValue(){
		return i;
//		return i.get();
	}
	private void evenIncrement(){
		for(;;){
			i++;i++;
			return;
		}
//		i.addAndGet(2);
	}
//	private synchronized void singleIncrement(){
//		i++;
//	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true){
			evenIncrement();
//			singleIncrement();
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest atomicityTest = new AtomicityTest();
		exec.execute(atomicityTest);
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.err.println("Aborting");
				System.exit(0);
			}
		}, 5000);
		while(true){
			int val = atomicityTest.getValue();
			if(val % 2 != 0){
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
