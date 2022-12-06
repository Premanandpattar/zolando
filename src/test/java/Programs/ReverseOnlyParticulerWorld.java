package Programs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseOnlyParticulerWorld {
	
	public static void main(String[] args) {
		
		String s = "java and selenium";
		String[] arr = s.split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			String st = arr[i];
			if(st.equals("java") || st.equals("selenium")) {
				
				String value = "";
				for (int j = st.length()-1; j >=0; j--) {
					value=value+st.charAt(j);
				}
				arr[i]=value;
			}
		}
		
		List<String> list = new LinkedList<String>();
		
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		
		Collections.reverse(list);
		
		for (int i = 0; i < list.size(); i++) {
			
			System.out.print(list.get(i)+" ");
		}
	}

}
