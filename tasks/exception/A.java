package exception;

public class A extends OneInstanceException {
    
    public A() {
        System.out.println("in a");
    }

    public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		A a1 = new A();
		
	}
    
}