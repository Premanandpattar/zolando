package Programs;

public class StrongNumber {
	
	public static void main(String[] args) {
		
		final int num = 145;
		int n = num;
		int sum = 0;
		
		while (n!=0) {
			int reminder = n%10;
			int fact = 1;
			for (int i = reminder; i >=1; i--) {
				fact=fact*i;
			}
			n=n/10;
			sum=sum+fact;
		}
		
		if (num==sum) {
			System.out.println("the given number is strong number");
		} else {
			System.out.println("the given number is not strong number");
		}
		
		//range
		
		for (int i = 1; i <=100; i++) {
			final int num1 = i;
			int n1 = num;
			int sum1 = 0;
			
			while (n!=0) {
				int reminder = n%10;
				int fact = 1;
				for (int j = reminder; j >=1; j--) {
					fact=fact*j;
				}
				n=n/10;
				sum1=sum1+fact;
			}
			
			if (num1==sum1) {
				System.out.print(num1+" ");
			} 	
		}
	}

}
