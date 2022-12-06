package Programs;

public class ArmStrongNumber {
	
	
	public static void main(String[] args) {
		final int num =153;
		int n =num;
		int sum=0;
		
		while (n!=0) {
			
			int reminder =n%10;
			sum=sum+(reminder*reminder*reminder);
			n=n/10;
		}
		
		if (num==sum) {
			System.out.println("armStrong");
		} else {
			System.out.println("not armStrong");
		}
	}
	

	

}
