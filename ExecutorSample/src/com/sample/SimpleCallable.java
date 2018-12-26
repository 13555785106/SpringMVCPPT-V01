package com.sample;

import java.util.concurrent.Callable;

public class SimpleCallable implements Callable<String> {
	private int sn;
	private int timeout;

	public SimpleCallable(int num, int timeout) {
		this.sn = num;
		this.timeout = timeout;
	}

	public String call() throws Exception {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "No." + sn + " " + Thread.currentThread().getName();
	}
}
