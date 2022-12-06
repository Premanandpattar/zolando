package Programs;

public class Table {
	
	public static void main(String[] args) 
	{
	java.util.Scanner sc=new java.util.Scanner(System.in);
	System.out.println("enter value of n");
	int n=sc.nextInt();
	for(int i=1;i<=n ;i++)
	{
	for (int j=1;j<=10 ;j++ )
	{
	System.out.print(i+"*"+j+"="+j*i+"\t");
	
	}
	System.out.println();
	}
	
	}

}
