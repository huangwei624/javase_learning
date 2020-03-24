package juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 模拟场景：
 * 同学聚会，总共有5个人，人数没有全部到齐不开饭，
 */
public class CyclicBarrierDemo {
	
	static class PersonTask implements Runnable{
		
		private CyclicBarrier cyclicBarrier;
		
		public PersonTask(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}
		
		@Override
		public void run() {
			// 与CountDownLatch 不同， CyclicBarrier 可以循环使用，
			for (int i = 0; i < 3; i++) {
				try {
					task();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		private void task() throws BrokenBarrierException, InterruptedException {
			System.out.println(Thread.currentThread().getName()+" 到达饭店");
			cyclicBarrier.await();
		}
	}
	
	public static void main(String[] args){
		int parties = 5;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, () -> System.out.println("同学到齐，可以开饭了。"));
		for (int i = 0; i < parties; i++) {
			new Thread(new PersonTask(cyclicBarrier), "同学"+(i+1)).start();
		}
	}
	
}
