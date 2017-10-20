package medium;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquaresDP {
	final Map<Integer, Integer> memoMap = new HashMap<Integer, Integer>();

	public int numSquares(int n) {
		memoMap.put(1, 1);
		memoMap.put(2, 2);
		memoMap.put(3, 1);
		memoMap.put(4, 1);
		return squares(n);
	}

	private int squares(final int n) {
		if (memoMap.containsKey(n))
			return memoMap.get(n);
		int lowest = 0;
		for (int i = n - 1; i >= n / 2; i--) {
			int sum1 = 0;
			int sum2 = 0;
			if (memoMap.containsKey(i)) {
				sum1 = memoMap.get(i);
			} else {
				if (isPerfectSquare(i)) {
					sum1 = 1;
				} else {
					sum1 = squares(i);
					
				}
				memoMap.put(i, sum1);
			}
			if (memoMap.containsKey(n - i)) {
				sum2 = memoMap.get(n - i);
			} else {
				if (isPerfectSquare(n - i)) {
					sum2 = 1;
				} else {
					sum2 = squares(n - i);
				}
				memoMap.put(i, sum2);
			}
			if (sum1 + sum2 < lowest) {
				lowest = sum1 + sum2;
			}
		}
		return lowest;
	}

	private boolean isPerfectSquare(int i) {
		if(i==0 || i==1) return true;
		if(i==2 || i==3) return false;
		recursiveFind(i/2,i);
		return false;
	}

	private void recursiveFind(int i, int target) {
		
		
	}
}
