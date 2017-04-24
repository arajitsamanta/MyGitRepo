package com.arajit.codesample.thread;

public class MyDaemonThreadDemo {

	private static class MyDaemonThread extends Thread {
		public MyDaemonThread() {
			setDaemon(true);
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		Thread thread = new MyDaemonThread();
        thread.start();
        System.out.println(thread.isAlive());

	}

}
