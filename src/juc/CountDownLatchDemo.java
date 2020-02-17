package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程执行完后再执行。
 * 例如，应用程序的主线程希望在负责启动框架服务的线程已经启动所有框架服务之后执行。
 *
 * 例子：
 * 模拟一个应用程序启动类，开始就启动N个线程，去检查N个外部服务是否正常并通知闭锁；
 * 启动类一直在闭锁上等待，一旦验证和检查了所有外部服务，就恢复启动类执行。
 * 创建 3个外部服务类：
 * NetworkHealthChecker     ** 网络服务检查
 * DatabaseHealthChecker    ** 数据服务检查
 * CacheHealthChecker       ** 缓存服务健康检查
 */

// 服务检查基类
abstract class BaseHealthChecker implements Runnable{
	
	protected CountDownLatch countDownLatch;
	protected String serviceName;
	protected Boolean startUp = false;
	
	public BaseHealthChecker(String serviceName, CountDownLatch countDownLatch) {
		this.serviceName = serviceName;
		this.countDownLatch =countDownLatch;
	}
	
	@Override
	public void run() {
		try {
			verifyService();
			startUp = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (countDownLatch != null){
				countDownLatch.countDown();
			}
		}
	}
	
	// 开启服务
	public abstract void verifyService();
}

// 数据服务检查
class DatabaseHealthChecker extends BaseHealthChecker{
	
	public DatabaseHealthChecker(CountDownLatch countDownLatch) {
		super("database service", countDownLatch);
	}
	
	@Override
	public void verifyService() {
		System.out.println("Checking " + this.serviceName);
		try{
			Thread.sleep(7000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(this.serviceName + " is UP");
	}
}

// 缓存服务检查
class CacheHealthChecker extends BaseHealthChecker{
	
	public CacheHealthChecker(CountDownLatch countDownLatch) {
		super("cache service", countDownLatch);
	}
	
	@Override
	public void verifyService() {
		System.out.println("Checking " + this.serviceName);
		try{
			Thread.sleep(7000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(this.serviceName + " is UP");
	}
}

// 网络服务检查
class NetworkHealthChecker extends BaseHealthChecker{
	
	public NetworkHealthChecker(CountDownLatch countDownLatch) {
		super("network service", countDownLatch);
	}
	
	@Override
	public void verifyService() {
		System.out.println("Checking " + this.serviceName);
		try{
			Thread.sleep(7000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(this.serviceName + " is UP");
	}
}

class ApplicationStartupUtil{
	private static ApplicationStartupUtil app = new ApplicationStartupUtil();
	
	private List<BaseHealthChecker> baseHealthCheckers;
	private CountDownLatch countDownLatch;
	
	public static ApplicationStartupUtil newInstance (){
		return app;
	}
	
	public boolean checkExternalServices(){
		countDownLatch = new CountDownLatch(3);
		baseHealthCheckers = new ArrayList<>();
		baseHealthCheckers.add(new NetworkHealthChecker(countDownLatch));
		baseHealthCheckers.add(new CacheHealthChecker(countDownLatch));
		baseHealthCheckers.add(new DatabaseHealthChecker(countDownLatch));
		ExecutorService executorService = Executors.newFixedThreadPool(baseHealthCheckers.size());
		for (BaseHealthChecker b : baseHealthCheckers) {
			executorService.execute(b);
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (BaseHealthChecker b: baseHealthCheckers) {
			if(!b.startUp){
				return false;
			}
		}
		return true;
	}
}

public class CountDownLatchDemo {
	public static void main(String[] args){
		boolean result = false;
		try {
			result = ApplicationStartupUtil.newInstance().checkExternalServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("External services validation completed !! Result was :: "+ result);
	}
}
