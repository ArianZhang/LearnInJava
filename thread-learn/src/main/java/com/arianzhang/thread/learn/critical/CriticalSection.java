package com.arianzhang.thread.learn.critical;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
	// Test the two different approaches;

	static void testApproaches(PairManager pman1, PairManager pman2) {
//		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
//			@Override
//			public void uncaughtException(Thread t, Throwable e) {
//				System.out.println(t + "cause by :");
//				e.printStackTrace();
//				System.exit(0);
//			}
//		});
		ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r){
				};
				return t;
			}
		});
		PairManipulater pm1 = new PairManipulater(pman1), pm2 = new PairManipulater(
				pman2);
		PairChecker pcheck1 = new PairChecker(pman1), pcheck2 = new PairChecker(
				pman2);
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pcheck1);
		exec.execute(pcheck2);
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("sleep interupted!");
		}
		System.out.println("pm1 : " + pm1 + "\npm2 : " + pm2);
		System.exit(0);
	}

	public static void main(String[] args) {
		PairManager pman1 = new PairManager1(), pman2 = new PairManager2();
		testApproaches(pman1, pman2);
	}
}