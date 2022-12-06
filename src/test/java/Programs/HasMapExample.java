package Programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HasMapExample {

	public static void main(String[] args) {
		
	String name = "Premanad";
	long number = 99725061;
	double d = 51.05;
	
	Map<String, Object> m = new HashMap<>();
	
	m.put("String value", name);
	m.put("long value", number);
	m.put("double value", d);
	
	for (Entry<String, Object> e : m.entrySet()) {
		System.out.println(e.getKey()+" ==> " +e.getValue());
	}
		
	}
}
