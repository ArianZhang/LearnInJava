/**
 * 
 */
package com.arianzhang.thread.learn.threadfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import com.arianzhang.thread.learn.runable.SimpleDaemons;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class DaemonFactory implements ThreadFactory {

	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}

	public static void main(String[] args) throws InterruptedException {
		DaemonFactory threadFactory = new DaemonFactory();
		ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);
		for(int i=0;i<10;i++){
			executorService.execute(new SimpleDaemons());
		}
		executorService.shutdown();
		TimeUnit.MILLISECONDS.sleep(1000);
	}
}
