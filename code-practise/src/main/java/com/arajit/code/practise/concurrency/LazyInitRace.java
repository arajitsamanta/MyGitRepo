/**
 * 
 */
package com.arajit.code.practise.concurrency;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * @author as47775
 *
 */
@NotThreadSafe
public class LazyInitRace {
	
	private ExpensiveObject instance = null;
	
	public ExpensiveObject getInstance() {
		if (instance == null)
			instance = new ExpensiveObject();
		return instance;
	}
	
}

class ExpensiveObject{}

