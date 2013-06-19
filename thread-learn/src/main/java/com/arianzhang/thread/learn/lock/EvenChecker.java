/**
 * 
 */
package com.arianzhang.thread.learn.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class EvenChecker implements Runnable {

	private IntGenerator generator;
	private final int id;

	public EvenChecker(IntGenerator g, int ident) {
		this.generator = g;
		this.id = ident;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " is not even!");
				generator.cancel();
			}
		}
	}

	public static void test(IntGenerator gp, int count) {
		System.out.println("Press Control-C to exit!");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
//			exec.execute(new EvenChecker2(gp, i));
			exec.execute(new EvenChecker(gp, i));
		}
		exec.shutdown();
		System.out.println("executing!");
	}

	public static void test(IntGenerator gp) {
		test(gp, 10);
	}

	public static void main(String[] args) {
		EvenGenerator generator = new EvenGenerator();
		test(generator,1);
	}
}

//class EvenChecker2 implements Runnable {
//	private IntGenerator generator;
//	private final int id;
//
//	public EvenChecker2(IntGenerator g, int ident) {
//		this.generator = g;
//		this.id = ident;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see java.lang.Runnable#run()
//	 */
//	@Override
//	public void run() {
//		while (!generator.isCanceled()) {
//			int val = generator.next2();
//			if (val % 2 != 0) {
//				System.out.println(val + " is not even!");
//				generator.cancel();
//			}
//		}
//	}
//
//}
