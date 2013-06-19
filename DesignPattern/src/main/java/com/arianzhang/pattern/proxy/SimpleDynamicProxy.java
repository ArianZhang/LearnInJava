/**
 * 
 */
package com.arianzhang.pattern.proxy;

import java.lang.reflect.Proxy;

import com.arianzhang.pattern.proxy.Interface.RealObject;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class SimpleDynamicProxy {

	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}

	public static void main(String[] args) {
		RealObject realObject = new RealObject();
		consumer(realObject);
		// insert a proxy and call again:
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
				new Class[] { Interface.class }, new DynamicProxyHandler(
						realObject));
		consumer(proxy);
		
	}
}
