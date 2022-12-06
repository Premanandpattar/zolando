package Programs;

import java.util.LinkedHashSet;

public class PrintNoOfVovelesWithoutDuplicates {

	public static void main(String[] args) {
		String s = "india";
		int count = 0;
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}
		
		for (Character character : set) {
			if (character=='a'||character=='e'||character=='i'||character=='o'||character=='u') {
				count++;
				System.out.println(character);
			}
		}
		
		System.out.println("vowels count is "+count);
		
	}
}
