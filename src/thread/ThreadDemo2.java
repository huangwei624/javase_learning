package thread;

import com.sun.javaws.Main;

import java.util.concurrent.TimeUnit;

public class ThreadDemo2 extends Thread {
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()){
			System.out.println("子线程正在执行");
//			TimeUnit.SECONDS.sleep();
		}
		System.out.println("子线程已经终止");
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo2 threadDemo2 = new ThreadDemo2();
		threadDemo2.start();
		TimeUnit.MILLISECONDS.sleep(100);
		// threadDemo2.interrupt();
	}
}
