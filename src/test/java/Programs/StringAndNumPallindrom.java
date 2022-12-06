package Programs;

public class StringAndNumPallindrom {

	public static void main(String[] args) {
		
		String s ="wow";
		String copy = "";
		
		for (int i = s.length()-1; i >=0; i--) {
			copy=copy+s.charAt(i);
		}
//		System.out.println(copy);
//		if (s.equals(copy)) {
//			System.out.println("the given word is string pllindro");
//		} else {
//			System.out.println("the given word is string not pllindro");
//		}
		
		 int nu =121;
		 final int copy1=nu;
		int c =0;
		
		while (nu!=0) {
			int reminder = nu%10;
			nu=nu/10;
			c=(c*10)+reminder;	
		}
		
		System.out.println(c);
		if (copy1==c) {
			System.out.println("the given number pllindro");
		} else {
			System.out.println("the given number not pllindro");
		}
		
		
	}
}
