package easy;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {

	public boolean isHappy(int n) {
		Map<Long, Long> valueMap = new HashMap<Long, Long>();
		Map<Long, Boolean> presenceMap = new HashMap<Long, Boolean>();

		long temp = n;
		return calculateIsHappy(temp, presenceMap);
	}

	private boolean calculateIsHappy(long temp, Map<Long, Boolean> presenceMap) {
		long sum = 0;
		long reminder = temp % 10;
		long quotient = temp / 10;
		sum += Math.pow(reminder, 2);
		while (quotient >= 10) {
			reminder = quotient %10;
			quotient /= 10;
			sum += Math.pow(reminder, 2);
		}
		sum += Math.pow(quotient, 2);
		if (sum == 1) {
			return true;
		}
		if (presenceMap.containsKey(Long.valueOf(sum))) {
			return false;
		}
		presenceMap.put(Long.valueOf(sum), true);
		return calculateIsHappy(sum, presenceMap);
	}
	
	public static void main(String[] arg){
		System.out.println(new HappyNumber().isHappy(86000));
	}
}
