package base;

// 演示非静态内部类
class Outer{
	private final int a = 1;
	private static final int b=7;
	
	private void m1(){ System.out.println("outer m1"); }
	private static void m2(){ System.out.println("outer m2");}
	
	class Inner {
		int a;
		// static int b;    // 非静态内部类中不能包含静态成员变量和静态成员方法
		public void m1(){
			System.out.println(Outer.this.a);   // 访问外部类的非静态成员变量
			System.out.println(Outer.b);   // 访问外部类的静态成员变量
			Outer.this.m1();    // 访问外部类的非静态成员方法
			Outer.m2();    // 访问外部类的静态成员方法
		}
	}
}

// 演示静态内部类
class _Outer{
	final int a = 1;
	private static final int b=7;
	
	private void m1(){ System.out.println("outer m1"); }
	private static void m2(){ System.out.println("outer m2");}
	
	static class _Inner {
		int a;
		static int b;
		public void m1(){
			// System.out.println(_Outer.this.a);   // 静态内部类不可以访问外部类的非静态成员变量和非静态成员方法
			System.out.println(_Outer.b);   // 访问外部类的静态成员变量
			// _Outer.this.m1();    // 静态内部类不可以访问外部类的非静态成员变量和非静态成员方法
			_Outer.m2();    // 访问外部类的静态成员方法
		}
	}
}

/**
 * 总结：
 *
 * 非静态内部类：
	 1.非静态内部类中不能包含静态的成员属性和成员方法
	 2.非静态内部类通过 外部类名称.this.属性（方法）来访问外部类的非静态的成员属性（成员方法）
	 3.非静态内部类通过 外部类名称.属性（方法）来访问外部类静态的成员属性（成员方法）
	 4.创建内部类实例时需要先创建外部类实例，例如：
		 Outer outer = new Outer();  Outer.Inner inner = outer.new Inner();
 
    静态内部类：
    1.静态内部类中不可以访问外部类中的非静态的成员变量和成员方法
    2.静态内部类通过 外部类名称.属性（方法） 来访问外部类静态的成员属性（成员方法）
    3.静态内部类可以直接创建实例，不需要先创建外部类的实例，例如：
		 _Outer._Inner inner1 = new _Outer._Inner();
 */


public class InnerClassDemo {
	public static void main(String[] args){
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.m1();
		
		_Outer._Inner inner1 = new _Outer._Inner();
		inner1.m1();
	}
}
