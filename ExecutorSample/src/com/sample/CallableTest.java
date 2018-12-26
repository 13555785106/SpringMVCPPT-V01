package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		List<Future<String>> resultList = new ArrayList<Future<String>>();

		for (int i = 0; i < 100; i++) {
			Future<String> future = executorService.submit(new SimpleCallable(i, 1000));
			resultList.add(future);
		}

		// 遍历任务的结果
		for (Future<String> fs : resultList) {
			try {
				while (!fs.isDone())
					;// Future返回如果没有完成，则一直循环等待，直到Future返回完成
				System.out.println(fs.get()); // 打印各个线程（任务）执行的结果
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				// 启动一次顺序关闭，执行以前提交的任务，但不接受新任务
				executorService.shutdown();
			}
		}

	}
}
