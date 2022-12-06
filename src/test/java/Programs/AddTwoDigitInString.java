package Programs;

public class AddTwoDigitInString {

	public static void main(String[] args) {
		
		String s="111b21c3";
		int sum=0; //0
		int tsum=0; //0 1 11
		int len = s.length();
		for (int i = 0; i < len; i++)
		{
			char ch = s.charAt(i);
		if(ch>='0' && ch<='9') //o/p=35
		{
		int n=ch-48; //n=49-48=1
		tsum=tsum*10+n; //tsum=0*10+1=1: 1*10+1=11
		}else{
		sum=sum+tsum; //sum=0+11=11: 11+21=32: 32+3=35
		tsum=0;
		}
		}
		sum=sum+tsum; //sum=32+3=35
		System.out.println(sum);
	}
	
}
