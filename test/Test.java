import java.util.concurrent.TimeUnit;

public class Test {
	
	public static void main(String[] args) {
		// m1();
		m5();
		// 0011---->1100 ------->1101
		System.out.println(Integer.toBinaryString(536870911));
	}
	
	private static void m5() {
		// 0011 ----> 1100 ---->12
		int a = 3 << 2;
		// 0000 0111 ----------> 0011 1000 ---------32+16+8=56
		int b = 7 << 3;
		// 0011 ----->1100 ------->1101 ------->1111---->-1
		int c = -3 >> 2;
		// 0000 0111------>1111 1001----->1111 1111---->-1
		int d = -7 >> 3;
		// 0011 ---> 0000--->0
		int e = 3 >> 2;
		// 0111 ---->0000 ---->0
		int f = 7 >> 3;
		// 0000 0111------>1111 1001----->1111 1111---->-1
		int g = -7 >> 3;
		// 0111 ---->0000
		int h = 7 >>> 3;
		// 0111 ----> 1000----->1001---->11111....1111 1111
		int i = -7 >>> 3;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
		System.out.println("e=" + e);
		System.out.println("f=" + f);
		System.out.println("g=" + g);
		System.out.println("h=" + h);
		System.out.println("i=" + i);
	}
	
	private static void m4() {
		Thread thread = new Thread(() -> {
			while (true) {
				System.out.println("====");
			}
		});
		thread.setDaemon(true);
		thread.start();
		
		new Thread(() -> {
			while (true) {
				System.out.println("+++++++++");
			}
		}).start();
	}
	
	private static void m3() {
		try {
			System.out.println("return");
			return;
		} finally {
			System.out.println("finally");
		}
		
	}
	
	private static void m1() {
		int i = 0;
		while (true) {
			try {
				System.out.println("=======");
				if (i == 5) {
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

	private static void m2() {
		int i = 0;
		while (true) {
			try {
				System.out.println("=======");
				if (i == 5) {
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
