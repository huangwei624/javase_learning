package base;

/**
 * 1. final 修饰的类不可以被继承，如果一个类被final 修饰，那么这个类的成员方法默认会被final 隐式修饰
 * 2. 抽象类和接口是为了扩展功能被用来继承和实现的，所有不能用final 修饰
 * 3. final 修饰的方法不能够被重写
 * 4. final修饰成员属性的时候必须要直接赋值，例如final String name = ""；
 *      final修饰局部变量的时候可以先定义final变量在进行赋值，例如final Animal a; a = new Animal();
 */

class Animal{
	final String name = "";
}
abstract class Student{}

public class FinalTest {
	public static void main(String[] args){
		final Animal a;
		a = new Animal();
		System.out.println(a);
	}
}
