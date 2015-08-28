package easy;

public class ValidPalindrome {

	public boolean isPalindrome(String s){
		if(s.equals("")){
			return true;
		}		
		StringBuilder builder = new StringBuilder();
		String strippedString = s.replaceAll("\\W", "");
		builder.append(strippedString);
		return builder.toString().equalsIgnoreCase(builder.reverse().toString());
	}
	
	public static void main(String[] arg){
		System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
	}
}
