package Programs;

public class Fibonicci {
	
	static int fib(int n)
	{
	if(n==0)
	return 0;
	if(n==1)
	return 1;
	return fib(n-1)+fib(n-2);
	}
	public static void main(String[] args) 
	{
	java.util.Scanner sc=new java.util.Scanner(System.in);
	System.out.println("Enter the number");
	int m=sc.nextInt();
	int f=fib(m);
	System.out.println(f);
	
	int num =m;
	int fib1=0;
	int fib2=1;
	for (int i = 0; i < num; i++) {
//		fib1=fib;
		
	}
	}

}
