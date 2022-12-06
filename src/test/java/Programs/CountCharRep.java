package Programs;

import java.util.Set;
import java.util.TreeSet;

public class CountCharRep {

	public static void main(String[] args) {
		
		String s = "testeer himmmmaksjsk lcokc akjdniu ueJSJDNJSDNSNNWNUDNWUNUCWNCUCNXWNCNCnie  	u  je3j j";
		Set<Character> c = new TreeSet<>();
		for (int i = 0; i < s.length(); i++) {
			c.add(s.charAt(i));
		}
		
		for (Character character : c) {
			int count =0;
			for (int i = 0; i < s.length(); i++) {
				if (character==s.charAt(i)) {
					count++;
				}
			}
			if (character=='a'|| character=='e' ||character=='i'||character=='o'
					||character=='u') {
			System.out.println(character+" ==> "+count);
			}
		}
	}
}
