package Programs;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RemoveDuplicatInArrayChar {

	public static void main(String[] args) {
		
		char [] arr= {'A','a','A','a','B','B','b','b','2','2'};
		
		//using set
		Set<Character> c =new LinkedHashSet<>();
		
		for (int i = 0; i < arr.length; i++) {
			c.add(arr[i]);
		}
		
		for (Character character : c) {
			System.out.print(character+" ");
		}
		
		//using collection
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			int count=0;
			for (int j = 0; j < arr.length; j++) {
				
				if (arr[i]==arr[j] && i>j)  {
					break;
				}
				
				if(arr[i]==arr[j]) {
					count++;
				}
			}
			
			if (count>1) {
				System.out.print(arr[i]+" ");
			}
		}
		
		//using map
		System.out.println();
		Map< Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				Integer count = map.get(arr[i]);
				map.put(arr[i], count);
			}
			
		}
		
		for (Entry<Character, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey()+" ");
		}
		
		System.out.println();
		String s = "I love Bengalure I love India";
        
		String[] arr1 = s.split(" ");
		
		for (int i = 0; i < arr1.length; i++) {
			int count =0;
			for (int j = 0; j < arr1.length; j++) {
				if(arr1[i].equals(arr[i]) && i>j){
                    break;
                }
                if(arr1[i].equals(arr1[i])){
                    count++;
                }
			}
			if(count>1){
                System.out.println(arr1[i]+" ==> "+count);
            }
		}
	}
	
	
			
	
}
