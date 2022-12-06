package Programs;

import java.util.LinkedHashSet;

public class PrintDuplicates {
	
	public static void main(String[] args) {
		
		int num [] = {10,10,20,1,12,1,2,13,12,14,1,4,4,5,5,};
		
		LinkedHashSet<Integer> n = new LinkedHashSet<>();
		
		for (int i = 0; i < num.length; i++) {
			n.add(num[i]);
		}
		
		for (Integer integer : n) {
			int count = 0; 
			for (int i = 0; i < num.length; i++) {
				if (num[i]==integer) {
					count++;
					
				}
			}
			if (count>=2) {
				System.out.println(integer +" repeting "+count+" times");
			}
		}
		
		
	}

}
