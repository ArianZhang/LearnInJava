/**
 * 
 */
package com.arianzhang.thread.learn.runable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class MyFutureTask extends FutureTask<String> {

	/**
	 * @param callable
	 */
	public MyFutureTask(Callable<String> callable) {
		super(callable);
	}

}
