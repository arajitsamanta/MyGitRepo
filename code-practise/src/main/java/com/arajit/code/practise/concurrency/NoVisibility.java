/**
 * 
 */
package com.arajit.code.practise.concurrency;

/**
 * @author as47775
 *
 */
public class NoVisibility {

	private static boolean ready;

	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready)
				Thread.yield();
			System.out.println("Thread:"+Thread.currentThread()+number);
		}
	}

	public static void main(String[] args) {
		new ReaderThread().start();
		
		try {
			Thread.sleep(10000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		number = 42;
		ready = true;
	}
}
