package Programs;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.formula.functions.Count;

public class RemoveDuplicatInArrayNum {
	
	public static void main(String[] args) {
		//with out using collection
		int[] arr= {10,10,20,20,30,30,40,50,60,70,70,80};
		for (int i = 0; i < arr.length; i++) {
			int count=0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i]==arr[j] && i>j) {
					break;
				}
				if (arr[i]==arr[j]) {
					count++;
				}
			}
			if (count>=1) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		
		//with using collection
		
		Set<Integer> list = new LinkedHashSet<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		
		System.out.println();
		
		//using map
		
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				Integer count = map.get(arr[i]);
				count++;
				map.put(arr[i], count);
			}	
		}
		
		for (Entry<Integer, Integer> no : map.entrySet()) {
				System.out.print(no.getKey()+" ");

		}
		
		
	}

}
