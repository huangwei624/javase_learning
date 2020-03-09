package jvm;

public class JVMDemo5 {
	public static void main(String[] args){
		// -Xmx20m -Xms5m
		for (int i = 0; i < 10; i++) {
			byte[] bytes = new byte[1024 * 1024];
		}
		/**
		 * 1.maxMemory()这个方法返回的是java虚拟机（这个进程）能构从操纵系统那里挖到的最大的内存
		 *
		 * 2.totalMemory：程序运行的过程中，内存总是慢慢的从操纵系统那里挖的，基本上是用多少挖多少，
		 * 直 挖到maxMemory()为止，所以totalMemory()是慢慢增大的
		 *
		 * 3.freeMemory：挖过来而又没有用上的内存，实际上就是 freeMemory()，
		 * 所以freeMemory()的值一般情况下都是很小的（totalMemory一般比需要用得多一点，剩下的一点就是freeMemory）
		 */
		// 虚拟机空闲内存
	    System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
	    // 虚拟机最大可申请的内存
	    System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
	    // 虚拟机当前最大内存
	    System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
	}
	
}
