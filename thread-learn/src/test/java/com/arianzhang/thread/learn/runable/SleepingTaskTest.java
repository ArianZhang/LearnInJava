package com.arianzhang.thread.learn.runable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.testng.annotations.Test;

public class SleepingTaskTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new SleepingTask());
		}
		executorService.shutdown();
	}
	
	@Test
	public void run(){
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new SleepingTask());
		}
		executorService.shutdown();
	}

}
