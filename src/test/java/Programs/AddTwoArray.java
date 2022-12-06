package Programs;

public class AddTwoArray {
	
	public static void main(String[] args) {
		
		int[] a= {10,20,30,40,50,60};
		int [] b= {10,20,30,40};
		
		int size=0;
		if(a.length>b.length) {
			size=a.length;
		}else {
			size=a.length;
		}
		
		for (int i = 0; i < size; i++) {
			try {
				System.out.print(a[i]+b[i]+" ");
			} catch (Exception e) {
				if (a.length>b.length) {
					System.out.print(a[i]+" ");
				} else {
					System.out.print(b[i]+" ");
				}
			}
			
		}
		
	}

}
