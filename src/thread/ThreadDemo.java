package thread;

import java.util.concurrent.TimeUnit;

public class ThreadDemo extends Thread{
	@Override
	public void run() {
		
		for(int i = 0; !Thread.currentThread().isInterrupted(); i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo threadDemo = new ThreadDemo();
		threadDemo.start();
		TimeUnit.SECONDS.sleep(3);
		threadDemo.interrupt();
	}
}
