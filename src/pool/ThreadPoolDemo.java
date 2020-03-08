package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo implements Runnable{
	
	public static void main(String[] args){
		ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);      // 创建固定数量线程的线程池
		for (int i=0; i<10;i++) {
			fixedThreadPool.execute(threadPoolDemo);
		}
		
		ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();     // 创建只有单个线程的线程池
		
//		for (int i=0; i<10;i++) {
//			singleThreadPool.execute(threadPoolDemo);
//		}
		
		// 创建具有固定线程数并且线程有延迟和定时功能的线程池
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
		// for (int i=0; i<10;i++) {
			// 线程执行后延迟5秒后执行
			// scheduledThreadPool.schedule(threadPoolDemo, 5, TimeUnit.SECONDS);
			// 线程每隔5秒执行一次任务
			// scheduledThreadPool.scheduleWithFixedDelay(threadPoolDemo, 5, 5, TimeUnit.SECONDS);
			
			// scheduledThreadPool.scheduleAtFixedRate(threadPoolDemo, 5, 5, TimeUnit.SECONDS);
		// }
		
		// 根据任务的需要会不断创建线程，一旦之前创建的线程有空闲就会重新使用
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//		 for (int i=0; i<10;i++) {
//			 cachedThreadPool.execute(threadPoolDemo);
//		 }
		
		fixedThreadPool.shutdown();
		singleThreadPool.shutdown();
		scheduledThreadPool.shutdown();
		cachedThreadPool.shutdown();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(Thread.currentThread().getName()+", "+i);
			try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
