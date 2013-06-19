/**
 * 
 */
package com.arianzhang.thread.learn.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class SerialNumberChecker {

	private static final int SIZE = 100;
	
	private static CircularSet serials = new CircularSet(1000);
	private static ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactory() {
		
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	});
	
	static class SerialChecker implements Runnable{

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			while(true){
				int serial = SerialNumberGenerator.nextSerialNumber();
				if(serials.contains(serial)){
					System.out.println("Duplicate : " + serial);
					Thread.yield();
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, InterruptedException {
		for(int i=0;i<SIZE;i++){
			exec.execute(new SerialChecker());
		}
		exec.shutdown();
		TimeUnit.SECONDS.sleep(60);
		System.out.println("No duplicates detected");
		System.exit(0);
	}
}
