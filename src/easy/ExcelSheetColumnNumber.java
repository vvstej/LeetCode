package easy;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber {
	public String convertToTitle(int n) {
		int remainder = n%26;
		int quotient = n/26;
		StringBuilder excelColumnBuilder = new StringBuilder();
		while(quotient >=1){
			char c = 0;
			if(quotient==1){
				c = (char) (remainder+64);
			}else{
				c = (char) (remainder+65);
			}
			excelColumnBuilder.append(c);
			quotient = quotient / 26;
			remainder = quotient % 26;
		}
		
		char c = (char) (remainder+65);
		excelColumnBuilder.append(c);
		return excelColumnBuilder.reverse().toString();
	}
	
	public static void main(String [] arg){
		System.out.println(new ExcelSheetColumnNumber().convertToTitle(52));
	}
}
