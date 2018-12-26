package com.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewCachedThreadPoolTest {
	//创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < 20; i++) {
			executorService.execute(new SimpleTask(i,1000));
		}
		try {   
			executorService.shutdown();   
	        if(!executorService.awaitTermination(30, TimeUnit.SECONDS)){  
	        	executorService.shutdownNow();  
	        }  
	    } catch (InterruptedException e) {  
	        e.printStackTrace();
	        executorService.shutdownNow();  
	    }  
		System.out.println("结束");

	}

}
