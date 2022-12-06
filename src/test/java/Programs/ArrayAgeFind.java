package Programs;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ArrayAgeFind {
	
	public static void main(String[] args) {
		
		final int [] list= {10,11,12,15,14,18,16,17,19,20,21,13};
		List<Integer> l = new LinkedList<>();
		
		for (int i = 0; i < list.length; i++) {
			l.add(list[i]);
		}
		Collections.sort(l);
		Set<Integer> dump = 
				new TreeSet<>();
		
		for (int i = 0; i < list.length; i++) {
			Integer nu = l.get(i);
			if (list[i]!= nu) {
				dump.add(list[i]);
				dump.add(nu);
			}
		}
		
		for (Integer integer : dump) {
			System.out.print(integer +" ");
		}
	
	}

}
