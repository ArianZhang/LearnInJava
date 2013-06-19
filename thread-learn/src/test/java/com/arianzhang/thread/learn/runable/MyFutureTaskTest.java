package com.arianzhang.thread.learn.runable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.testng.annotations.Test;

public class MyFutureTaskTest {
	@Test
	public void f() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<FutureTask<String>> results = new ArrayList<FutureTask<String>>();
		for(int i=0;i<10;i++){
			results.add(new FutureTask<String>(new LiftOff(),"completed task" + i));
			executorService.execute(results.get(i));
		}
		for(FutureTask<String> futureTask : results){
			System.out.println(futureTask.get());
		}
	}
}
