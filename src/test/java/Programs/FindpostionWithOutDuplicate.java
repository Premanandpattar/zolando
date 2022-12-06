package Programs;

import java.util.LinkedHashSet;
import java.util.Set;

public class FindpostionWithOutDuplicate {
	
	public static void main(String[] args) {
		int [] a= {12,12,13,15,12,16,14,18,19};
		
	Set<Integer> list = new LinkedHashSet<>();
	
	for (int i = 0; i < a.length; i++) {
		list.add(a[i]);
	}
	
	for (Integer no : list) {
		for (int i = 0; i < a.length; i++) {
			if (no==a[i]) {
				System.out.println(a[i]+" postion is --> "+(i+1));
				break;
			}
		}
	}
	
	}
}
