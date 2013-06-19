/**
 * 
 */
package com.arianzhang.thread.learn.runable;

import java.util.concurrent.TimeUnit;
/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class SimpleDaemons implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		}catch(InterruptedException e){
			System.out.println("sleep() interrupted!");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++){
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All daemons started!");
		TimeUnit.MILLISECONDS.sleep(1750);
	}
}
