/**
 * 
 */
package com.arianzhang.thread.learn.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class SerialNumberGenerator {

	private static AtomicInteger serialNumber = new AtomicInteger(0);
	
	public static int nextSerialNumber(){
		return serialNumber.incrementAndGet();
	}
}
