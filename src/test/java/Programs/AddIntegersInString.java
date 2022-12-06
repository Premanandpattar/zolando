package Programs;

public class AddIntegersInString {
	
	public static void main(String[] args) {
		
		String s = "123ssdsdsd122sd3323sds789";
		
		int sum = 0;
		
//		for (int i = 0; i < s.length(); i++) {
//			char ch = s.charAt(i);
//			String su =""+ ch;
//			if (ch>='0' && ch<='9') {
//				sum=sum+Integer.parseInt(su);
//			}
//		}
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch>='0' && ch<='9') {
				sum=sum+(ch-48);
			}
		}
		
		System.out.println(sum);
	}

}
