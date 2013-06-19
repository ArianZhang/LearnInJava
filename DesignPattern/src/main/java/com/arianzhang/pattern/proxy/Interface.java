/**
 * 
 */
package com.arianzhang.pattern.proxy;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public interface Interface {
	void doSomething();
	void somethingElse(String arg);
	
	class RealObject implements Interface{

		/* (non-Javadoc)
		 * @see com.arianzhang.pattern.proxy.Interface#doSomething()
		 */
		public void doSomething() {
			System.out.println("doSomething()");
		}

		/* (non-Javadoc)
		 * @see com.arianzhang.pattern.proxy.Interface#somethingElse(java.lang.String)
		 */
		public void somethingElse(String arg) {
			System.out.println("somethingElse " + arg);
		}
		
	}
}
