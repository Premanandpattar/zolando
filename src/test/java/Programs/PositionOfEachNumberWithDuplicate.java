package Programs;

public class PositionOfEachNumberWithDuplicate {
	
	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 3, 1 };
		int length = a.length;

		for (int j = 0; j < length; j++) {
			System.out.println(a[j]+" "+"Position is " +(j+1));
		}
	}

}
