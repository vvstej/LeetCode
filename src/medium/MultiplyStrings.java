package medium;

public class MultiplyStrings {

	public String multiplyStrings(String num1, String num2){
		if(num1==null || num1.length()==0 || num2==null || num2.length()==0){
			return "";
		}
		long num1Long = Long.parseUnsignedLong(num1);
		long num2Long = Long.parseUnsignedLong(num2);
		return Long.toString(num1Long*num2Long);
	}
}
