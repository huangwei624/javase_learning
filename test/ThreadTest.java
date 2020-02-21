import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 *
 */
class Foo {
	private CountDownLatch c2;
	private CountDownLatch c3;
	public Foo() {
		c2 = new CountDownLatch(1);
		c3 = new CountDownLatch(1);
	}
	
	public void first(Runnable printFirst) throws InterruptedException {
		
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		c2.countDown();
	}
	
	public void second(Runnable printSecond) throws InterruptedException {
		c2.await();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		c3.countDown();
	}
	
	public void third(Runnable printThird) throws InterruptedException {
		c3.await();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}


public class ThreadTest {
	
	public static void main(String[] args){
	
	}
	
}
