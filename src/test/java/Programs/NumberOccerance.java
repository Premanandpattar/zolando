package Programs;

import java.util.LinkedHashSet;

public class NumberOccerance {
	
	public static void main(String[] args) {
//		int [] num = {2,5,6,8,6,2,0,1,1,1,3,4};
//		
//		Map<Integer, Integer> m = new LinkedHashMap<>();
//		for (int i = 0; i < num.length; i++) {
//			int count = 1;
//			
//			if(!m.containsKey(num[i])) {
//				m.put(num[i], count);
//			} else {
//				Integer c = m.get(num[i]);
//				c++;
//				m.put(num[i], c);
//			}
//		}
//		
//		for ( Entry<Integer, Integer> k : m.entrySet()) {
//			System.out.println(k.getKey()+"==>"+k.getValue());
//		}
		
		int[] a = { 4, 3, 2, 3, 1 };
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		for (Integer in : set) {
			int count = 0;
			for (int i = 0; i < a.length; i++) {
				if (in == a[i]) {
					count++;
				}
			}
			System.out.println(in+" is repeting "+ count +" times");
		}
	}

}
