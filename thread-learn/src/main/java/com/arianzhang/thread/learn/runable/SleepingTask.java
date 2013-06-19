/**
 * 
 */
package com.arianzhang.thread.learn.runable;

import java.util.concurrent.TimeUnit;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class SleepingTask extends LiftOff {
	/* (non-Javadoc)
	 * @see com.arianzhang.thread.learn.runable.LiftOff#run()
	 */
	@Override
	public void run() {
		try{
			while(countDown-- > 0){
				System.out.print(status());
				TimeUnit.MILLISECONDS.sleep(100);
			}
		}catch(InterruptedException e){
			System.out.println(e);
		}
	}
}
