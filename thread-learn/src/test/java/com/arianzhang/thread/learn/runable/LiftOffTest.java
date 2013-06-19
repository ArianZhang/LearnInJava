/**
 * 
 */
package com.arianzhang.thread.learn.runable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.testng.annotations.Test;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
@Test
public class LiftOffTest {

	public void testRun() {
		LiftOff liftOff = new LiftOff();
		liftOff.run();
	}

	public void testStart() {
		Thread thread = new Thread(new LiftOff());
		thread.start();
		System.out.println("Waiting for LiftOff");
	}

	public void test5Starts() {
		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for LiftOff");
	}
	
	public void testCachedThreadPoolExecute(){
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++){
			executorService.execute(new LiftOff());
		}
		executorService.shutdown();
	}
	
	public void testMixedThreadPoolExecute(){
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			executorService.execute(new LiftOff());
		}
		executorService.shutdown();
	}
	
	public void testSingleThreadPoolExecute(){
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			executorService.execute(new LiftOff());
		}
		executorService.shutdown();
	}
}
