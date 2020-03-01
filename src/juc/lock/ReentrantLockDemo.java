package juc.lock;

/**
 * 1、公平锁能保证：老的线程排队使用锁，新线程仍然排队使用锁。
 * 2、非公平锁保证：老的线程排队使用锁；但是无法保证新线程抢占已经在排队的线程的锁。
 */
public class ReentrantLockDemo {
	
	public static void main(String[] args){
		ReentrantLock reentrantLock = new ReentrantLock();
		reentrantLock.lock();   // 加锁
		try {
			// todo
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reentrantLock.unlock();     // 释放锁
		}
	}
	
}
