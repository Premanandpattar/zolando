package Programs;

public class FindPrimeNum {
	
	public static void main(String[] args) {
		
		int nu = 100;
		
		
		for (int i = 1; i <=100; i++) {
			boolean flage = true;
			
			for (int j = 2; j < i; j++) {
				
				if (i%j==0) {
					flage=false;
					break;
				}
			}
			
			if (flage) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println(2/2);
	}

}
