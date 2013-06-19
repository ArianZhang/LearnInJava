/**
 * 
 */
package com.arianzhang.thread.learn.local;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class ThreadLocalVariableHolder {

	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
		
		private Random rand = new Random(47);
		
		protected Integer initialValue() {
			return rand.nextInt(10000);
		};
	};
	
	public static void increment(){
		value.set(value.get() + 1);
	}
	
	public static Integer get(){
		return value.get();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
		});
		for(int i=0;i<5;i++){
			exec.execute(new Accessor(i));
		}
		TimeUnit.MILLISECONDS.sleep(100);
		exec.shutdown();
	}
}

class Accessor implements Runnable{

	private final int id;
	
	public Accessor(int idn){
		id = idn;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	
	public String toString(){
		return "#" + id + ": " + ThreadLocalVariableHolder.get();
	}
	
}
