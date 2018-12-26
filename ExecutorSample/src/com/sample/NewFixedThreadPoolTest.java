package com.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewFixedThreadPoolTest {
	
	//创建固定数目线程的线程池。
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

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
