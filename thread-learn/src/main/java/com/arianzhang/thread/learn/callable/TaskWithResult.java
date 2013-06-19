/**
 * 
 */
package com.arianzhang.thread.learn.callable;

import java.util.concurrent.Callable;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class TaskWithResult implements Callable<String> {
	
	private int id;
	public TaskWithResult(){
	}
	public TaskWithResult(int id){
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	public String call() throws Exception {
		return "result of TaskWithResult " + id;
	}

}
