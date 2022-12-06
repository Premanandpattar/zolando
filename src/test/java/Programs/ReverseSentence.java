package Programs;

import java.util.List;

public class ReverseSentence {
	public static void main(String[] args) {
		
		String s = "I love India";
		String[] arr = s.split(" ");
		
		for (int i = arr.length-1; i >=0; i--) {
			System.out.print(arr[i]+" ");
		}
	}

}
