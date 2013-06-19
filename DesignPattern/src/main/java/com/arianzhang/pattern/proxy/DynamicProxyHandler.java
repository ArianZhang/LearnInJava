/**
 * 
 */
package com.arianzhang.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class DynamicProxyHandler implements InvocationHandler {

	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("**** proxy : " + proxy.getClass() + ", method : " + method.getName()
				+ ", args : " + args);
		if(args != null){
			System.out.println("args lists : ");
			for(Object arg : args){
				System.out.println(" " + arg);
			}
		}
		return method.invoke(proxied, args);
	}
}
