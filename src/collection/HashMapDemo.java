package collection;

import java.util.HashMap;

// HashMap源码分析
public class HashMapDemo {
	public static void main(String[] args){
		HashMap<String, Object> stringObjectHashMap = new HashMap<>(15);
		// 1100110111101010111000
		// 右移 16为与自身异或运算：
		//  00 0000 0000 0000 0011 0011 高位参与运算
		//  11 0011 0111 1010 1011 1000
		//  00 1100 1000 0101 0111 0100
		// 上面得到的hash值后 ， （n-1）& hash ，得到的结果为这个元素所在的下标
		//                        1111      高位参与运算的好处， 降低hash冲突，数组元素均匀分布
		// 00 1100 1000 0101 0111 0100
		stringObjectHashMap.put("name", "张三");
		stringObjectHashMap.put("age", 20);
		
		// 默认容量为16 阈值为0.75 * 16 = 12，0.75 是加载因子，当需要扩容的时候，新的容量会是原来的2倍，阈值也是原来的二倍
		// 即 32 ---》1100 ---》0001 1000---》 24
		// 当设置初始容量的时候，hashmap会根据用户设置的初始容量，将其转换成大于它的2的次方数，
		// 目的是为了（n-1）& hash，运算，
		stringObjectHashMap.put("sex", "男");
		
		System.out.println(stringObjectHashMap.get("name"));
	}
}
