package com.sample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPoolTest {
	//创建一个定长线程池，支持定时及周期性任务执行
	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

		for (int i = 0; i < 20; i++) {
			executorService.schedule(new SimpleTask(i, 1000), 1, TimeUnit.SECONDS);
		}
		try {
			executorService.shutdown();
			if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			executorService.shutdownNow();
		}
		System.out.println("结束");

	}

}
