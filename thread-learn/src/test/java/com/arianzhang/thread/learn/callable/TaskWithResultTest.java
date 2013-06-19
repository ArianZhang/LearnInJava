package com.arianzhang.thread.learn.callable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.testng.annotations.Test;

public class TaskWithResultTest {

	@Test
	public void call() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			results.add(executorService.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs : results){
			try{
				// get() blocks until completion
				System.out.println(fs.get());
			}finally{
				executorService.shutdown();
			}
		}
	}
}
