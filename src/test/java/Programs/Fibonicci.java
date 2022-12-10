package Programs;

public class Fibonicci {

	public static void main(String[] args) {
		
		int fib1=0;
		int fib2=1;
		System.out.print(fib1+" "+fib2+" ");
		for (int i = 0; i <= 10; i++) {
			int fib3 = fib1+fib2;
			System.out.print(fib3+" ");
			fib1=fib2;
			fib2=fib3;
		}

	}
}
