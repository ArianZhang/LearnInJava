package com.arianzhang.thread.learn.runable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.testng.annotations.Test;

public class SimplePrioritiesTest {

  @Test
  public void run() {
	  ExecutorService executorService = Executors.newCachedThreadPool();
	  for(int i =0;i<5;i++){
		  executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
	  }
	  executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
	  executorService.shutdown();
  }
}
