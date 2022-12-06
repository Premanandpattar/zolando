package Programs;

public class RemoveDistinctChar {
	
	public static void main(String[] args) {
	
		String s ="Geerk hii hello";
		String concat = "";
		for (int i = 0; i < s.length(); i++) {
			
			int count=0;
			
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(i)==s.charAt(j) && i>j) {
					break;
				}
				
				if (s.charAt(i)==s.charAt(j)) {
					count++;
				}
				
			}
			if(count==1) {
			concat=	concat+s.charAt(i);
				
			}
			
		}
		
		System.out.println(concat);
		
		
	}

}
