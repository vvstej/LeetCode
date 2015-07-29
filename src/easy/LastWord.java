package easy;

public class LastWord {

	public int lengthOfLastWord(String s){		
		if (s.matches("\\s+")){
		 	return 0;
		}
		int j = s.length()-1;
		
		while(j >=0 && s.charAt(j)==' '){
			j--;
		}
		int i = j;
		while(i >=0 && s.charAt(i)!=' '){
			i--;
		}
		int spaces = s.length()-j;
		return s.length()-spaces-i;
//			String[] strings = s.split("\\s+");
//			return strings[strings.length-1].length();		
	}
	
	public static void main(String[] arg){
		System.out.println(new LastWord().lengthOfLastWord(" a bc n   mug12dDSDAd                              "));
	}
}
