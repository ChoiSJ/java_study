
public class CallByReference {
	public static void swap(Numbers n) {
		System.out.println("Before : a["+n.a+"] b["+n.b+"]");
		
		int temp = n.a;
		n.a = n.b;
		n.b = temp;
		
		System.out.println("After : a["+n.a+"] b["+n.b+"]");
	}
	
	public static void main(String[] args) {
		Numbers n = new Numbers();
		n.a = 10;
		n.b = 20;
		
		swap(n);
		System.out.println("a["+n.a+"] b["+n.b+"]");
	}
	
	static class Numbers {
		int a;
		int b;	
	}
}
