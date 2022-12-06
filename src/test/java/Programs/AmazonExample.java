package Programs;

import java.util.Scanner;

public class AmazonExample {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner (System.in);
		System.out.println ("enter the size");
		int length= sc.nextInt ();
		int arr [ ] =new int [length];
		System.out.println ("enter the "+length+" elements");
		for (int i = 0; i < arr.length; i++) 
		{
		arr[i] =sc.nextInt ();
		}
		for (int i = 0; i < arr.length; i++) 
		{
		System.out.println ("arr ["+i+"] ---->"+arr[i]);
		}
		
		
		
	}

}
