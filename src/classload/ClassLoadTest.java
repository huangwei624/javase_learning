package classload;

public class ClassLoadTest {
	public static void main(String[] args){
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(contextClassLoader);
		System.out.println(contextClassLoader.getParent());
		System.out.println(contextClassLoader.getParent().getParent());
	}
}
