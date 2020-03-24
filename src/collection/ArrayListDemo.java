package collection;


import java.util.ArrayList;

// ArrayList 源码分析
public class ArrayListDemo {
	
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<>(3);
		list.add(1);
		list.add(2);
		list.add(3);
		// 扩容 int newCapacity = oldCapacity + (oldCapacity >> 1); 扩大原来的二分之一向下取整
		list.add(4);
		System.out.println(list.get(1));
	}
	
}
