
public class CallByValue {
	public static void swap(int a, int b) {
		System.out.println("Before: a["+a+"] b["+b+"]");
		
		int temp = a;
		a = b;
		b = temp;
		
		System.out.println("After: a["+a+"] b["+b+"]");
	}
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		swap(a, b);
		
		System.out.println("a["+a+"] b["+b+"]");
	}
}
