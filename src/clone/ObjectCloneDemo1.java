package clone;

class A {

}

class B  implements Cloneable{
	
	int a=10;
	A classA;
	
	public B(A classA) {
		this.classA = classA;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

public class ObjectCloneDemo1 {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		B b = new B(new A());
		System.out.println(b.classA.hashCode());
		System.out.println("B:"+b.hashCode());
		B bClone = (B) b.clone();
		System.out.println(bClone.classA.hashCode());
		System.out.println("B:"+bClone.hashCode());
	}
}
