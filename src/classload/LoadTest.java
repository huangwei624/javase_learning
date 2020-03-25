package classload;

public class LoadTest {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader classLoader = LoadTest.class.getClassLoader();
		System.out.println(classLoader);
		//使用ClassLoader.loadClass()来加载类，不会执行初始化块
		classLoader.loadClass("classload.Test");
		//使用Class.forName()来加载类，默认会执行初始化块
		Class.forName("classload.Test");
		//使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
		Class.forName("classload.Test", false, classLoader);
	}
}
