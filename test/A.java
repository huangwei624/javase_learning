import java.util.concurrent.TimeUnit;

public class A {
	
	//static A a = new A();
	
	static {
		System.out.println("static A");
	}
	
	{
		System.out.println("non-static A");
	}
	
	public static void main(String[] args){
	    new A();
	}

}
