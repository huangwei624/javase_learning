package jvm;

import java.util.ArrayList;

public class JVMDemo2 {
	public static void main(String[] args){ // eden : s0 : s1= 4:1:1  young: 6 eden 4m
		// -Xmx20m -Xms5m
		for (int i = 0; i < 10; i++) {
			byte[] bytes = new byte[1024 * 1024];
		}
		// 虚拟机空闲内存
	    System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
	    // 虚拟机最大可申请的内存
	    System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
	    // 虚拟机当前最大内存，初始化内存
	    System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
	}
	
}
