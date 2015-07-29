package easy;

public class Atoi {
	final String MAX_INT = "2147483647";
	final String MIN_INT = "2147483648";

	public int myAtoi(String str) {
		boolean isPositiveNumber = true;
		str = str.trim();
		if(str==null || str.length()==0){
			return 0;
		}
		if (str.charAt(0) == '-') {
			isPositiveNumber = false;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			isPositiveNumber = true;
			str = str.substring(1);
		}
		StringBuilder integerBuilder = new StringBuilder();
		int length = str.length();
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			int cInInt = (int) c;
			if (cInInt >= 48 && cInInt <= 57) {
				integerBuilder.append(c);
			} else {
				if(integerBuilder.length()==0){
					return 0;
				}else{
					break;
				}
			}

		}
		length = integerBuilder.length();
		if(length==0){
			return 0;
		}
		if (isPositiveNumber) {
			if (length >= MAX_INT.length()) {
				if(length==MAX_INT.length()){
					if(integerBuilder.toString().compareTo(MAX_INT) > 0)
						return Integer.MAX_VALUE;
				}else{
					return Integer.MAX_VALUE;
				}
				
			}
		} else {
			if (length >= MIN_INT.length()) {
				if(length==MIN_INT.length()){
					if(integerBuilder.toString().compareTo(MIN_INT) > 0)
						return Integer.MIN_VALUE;
				}else{
					return Integer.MIN_VALUE;
				}
				
			}
		}
		int result = 0;
		str = integerBuilder.toString();
		for (int i = 0; i < length; i++) {
			int ithVal = (int) str.charAt(length - 1-i)-48;
			result += ithVal * (int) (Math.pow(10, i));
		}
		if(!isPositiveNumber){
			result*=-1;
		}
		return result;

	}
	
	public static void main(String []arg){
		System.out.println(new Atoi().myAtoi("      -67890"));
	}
}
