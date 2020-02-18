## CountDownLatch 类
CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，
直到其他线程执行完后再执行。

**常用方法：**
- await()
- countDown()

> 具体代码看 juc.CountDownLatchDemo.java

## final 和 内部类（静态，非静态）
**关于final:**

1. final 修饰的类不可以被继承，如果一个类被final 修饰，那么这个类的成员方法默认会被final 隐式修饰
2. 抽象类和接口是为了扩展功能被用来继承和实现的，所有不能用final 修饰
3. final 修饰的方法不能够被重写
4. final修饰成员属性的时候必须要直接赋值，例如`final String name = ""；`
      final修饰局部变量的时候可以先定义final变量在进行赋值，例如`final Animal a; a = new Animal();`
> 具体代码看 base.FinalTest.java

**非静态内部类：**

 1. 非静态内部类中不能包含静态的成员属性和成员方法
 2. 非静态内部类通过 外部类名称.this.属性（方法）来访问外部类的非静态的成员属性（成员方法）
 3. 非静态内部类通过 外部类名称.属性（方法）来访问外部类静态的成员属性（成员方法）
 4. 创建内部类实例时需要先创建外部类实例，例如：
     `Outer outer = new Outer();  Outer.Inner inner = outer.new Inner();`

 
 **静态内部类：**
 
 1. 静态内部类中不可以访问外部类中的非静态的成员变量和成员方法
 2. 静态内部类通过 外部类名称.属性（方法） 来访问外部类静态的成员属性（成员方法）
 3. 静态内部类可以直接创建实例，不需要先创建外部类的实例，例如：
     `_Outer._Inner inner1 = new _Outer._Inner();`
     
      
 > 具体代码看 base.InnerClassDemo.java