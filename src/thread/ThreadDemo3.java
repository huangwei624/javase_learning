package thread;

import java.util.concurrent.TimeUnit;

public class ThreadDemo3 extends Thread {
	@Override
	public void run() {
		synchronized (this) {
			while (true){
				try {
					System.out.println("sub");
					// Thread.sleep(5000);
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo3 threadDemo2 = new ThreadDemo3();
		threadDemo2.start();
		Thread.sleep(100);
		synchronized (threadDemo2) {
			while (true){
				System.out.println("main");
				Thread.sleep(1000);
				// threadDemo2.notify();
				break;
			}
		}
	}
}
