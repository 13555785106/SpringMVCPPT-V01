package com.sample;

public class SimpleTask implements Runnable {
	private int sn;
	private int timeout;

	public SimpleTask(int num, int timeout) {
		this.sn = num;
		this.timeout = timeout;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("No." + sn + " " + Thread.currentThread().getName());
	}
}
