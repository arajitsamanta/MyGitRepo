package com.arajit.code.practise.concurrency;

/**
 * Re-entrancy
 * 
 * Code that would deadlock if intrinsic locks were not reentrant.
 * @author as47775
 *
 */
public class Widget {
	
	public synchronized void doSomething() {
	}
}

class LoggingWidget extends Widget{
	
	public synchronized void doSomething() {
		System.out.println(toString() + ": calling doSomething");
		super.doSomething();
	}
	
}