package Programs;

public class FindMinLengthInStringArray {
	
	public static void main(String[] args) {
		
		String[] arr = {"asddff","ssd","sdwdecdcdcddfdfd","dasddcdcdc"};
		
		String minLengthWord = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i].length()>minLengthWord.length()) {
				minLengthWord=arr[i];
			}
			
		}
		
		System.out.println(minLengthWord);
	}

}
