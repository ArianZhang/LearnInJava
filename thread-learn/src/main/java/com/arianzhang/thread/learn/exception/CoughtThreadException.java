/**
 * 
 */
package com.arianzhang.thread.learn.exception;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class CoughtThreadException {

	public static void main(String[] args) {
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Entering default thread exception catcher!");
			}
		});
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				throw new RuntimeException();
			}
		});
//		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
//			@Override
//			public void uncaughtException(Thread t, Throwable e) {
//				System.out.println(t + " cause exception by :" + e);
//			}
//		});
		t.start();
	}
}
