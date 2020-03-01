import java.util.concurrent.TimeUnit;

public class Test {
	
	public static void main(String[] args){
	    // m1();
		m4();
	}
	private static void m4(){
		Thread thread = new Thread(() -> {
			while (true) {
				System.out.println("====");
			}
		});
		thread.setDaemon(true);
		thread.start();
		
		new Thread(() -> {
			while (true){
				System.out.println("+++++++++");
			}
		}).start();
	}
	
	private static void m3(){
		try {
			System.out.println("return");
			return;
		} finally {
			System.out.println("finally");
		}
		
	}
	
	private static void m1(){
		int i = 0;
		while (true) {
			try {
				System.out.println("=======");
				if(i==5){
					throw new RuntimeException("异常出现");
				}
				TimeUnit.SECONDS.sleep(1);
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	private static void m2(){
		int i = 0;
		while (true) {
			try {
				System.out.println("=======");
				if(i==5){
					throw new RuntimeException("异常出现");
				}
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}
