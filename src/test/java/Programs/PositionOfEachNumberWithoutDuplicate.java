package Programs;

import java.util.LinkedHashSet;

public class PositionOfEachNumberWithoutDuplicate {

	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 3, 1 };
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		
		for (Integer integer : set) {
			
			for (int i = 0; i < a.length; i++) {
				if (a[i]==integer) {
					System.out.println(a[i]+"==>"+(i+1));
					break;
				}
			}
		}
	}
}
