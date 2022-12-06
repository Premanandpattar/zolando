package Programs;

public class SoftwareEngg {
	
	public static void main(String[] args) {
		String s = "software engineer";
		String[] arr = s.split(" ");
//		String woard1="";
//		String woard2="";
		
		for (int i = 0; i < arr.length; i++) {
			String w = arr[i];
			String word = "";
			for (int j = w.length()-1; j >=0; j--) {
				if (!(w.charAt(j)=='e')) {
					word = word+w.charAt(j);
					arr[i]=word;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		
	}

}
