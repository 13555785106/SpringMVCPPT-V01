package com.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewSingleThreadExecutorTest {
	
	//创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

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
