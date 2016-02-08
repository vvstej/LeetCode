package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersFromString {
	public static void main(String[] arg) {
		String str = "dFD$#23+++12@#T99999999999999;/.,10";
		int result = (int)result(str);
		System.out.println(result);
	}
	public static long result(String input){
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(input);
		long sum=0;
		List<Long> vals = new ArrayList<Long>();
		while(m.find()){
			vals.add(Long.parseLong(m.group(0)));
		}
		for(long val : vals){
			sum+=val;
		}
		return sum;
	}
}
