package medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidNumber {

	public boolean isNumber(String s){
		 final String DECIMAL_PATTERN = "[\\d]+";
		 final String FLOATING_PATTERN = "[\\d]*.{1}[\\d]+";
		 final String SCIENTIFIC_PATTERN = "[\\d]+e[\\d]+";
		 final String HEX_PATTERN = "\\[0X][0-9a-f]+";
		 Pattern p = Pattern.compile(DECIMAL_PATTERN);
		 Pattern p1 = Pattern.compile(FLOATING_PATTERN);
		 Pattern p2 = Pattern.compile(SCIENTIFIC_PATTERN);
		 Pattern p3 = Pattern.compile(HEX_PATTERN);
		 Matcher m = p.matcher(s.trim());
		 Matcher m1 = p1.matcher(s.trim());
		 Matcher m2 = p2.matcher(s.trim());
		 Matcher m3 = p3.matcher(s.trim());
		 if(m.matches() || m1.matches() || m2.matches() || m3.matches()){
			 return true;
		 }
		return false;
		
	}
	
	public static void main(String[] arg){
		System.out.println(new ValidNumber().isNumber("e9"));
	}
}
