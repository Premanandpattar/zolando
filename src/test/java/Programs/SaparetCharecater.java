package Programs;

public class SaparetCharecater {
	public static void main(String[] args) {
	
		String s ="1246ASDFGHJLLassdjdfkfkf@#$@%@^&@@&@^&@";
		
		String lowerCase = "";
		String uperCase = "";
		String number = "";
		String splChar = "";
		int countLC=0 , countUC = 0, countNum =0, countSplCh = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch>='a' && ch<='z') {
				lowerCase=lowerCase+ch;
				countLC++;
				
			} else if (ch>='A' && ch<='Z') {
				uperCase=uperCase+ch;
				countUC++;
			}else if (ch>='0' && ch<='9') {
				number=number+ch;
				countNum++;
			}else {
				splChar=splChar+ch;
				countSplCh++;
			}
		}
		
		System.out.println(uperCase+" :the count is "+countUC);
		System.out.println(lowerCase+" :the count is "+countLC);
		System.out.println(number+" :the count is "+countNum);
		System.out.println(splChar+" :the count is "+countSplCh);
	}

}
