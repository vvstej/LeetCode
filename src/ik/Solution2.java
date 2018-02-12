package ik;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
	public static String[] sumZero(int[] intArr) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<String> response = new ArrayList<String>();
		int sum = 0;
		for (int i = 0; i < intArr.length; i++) {
			sum += intArr[i];
			List<Integer> indicies = map.get(sum);
			if (sum == 0) {
				StringBuilder str = new StringBuilder();
				for (int j = 0; j <= i; j++) {
					str.append(intArr[j]).append(",");
				}
				response.add(str.substring(0, str.length() - 1));
			}
			if (indicies == null) {
				indicies = new ArrayList<Integer>();
			}
			for (int index : indicies) {
				StringBuilder str = new StringBuilder();
				for (int j = index + 1; j <= i; j++) {
					str.append(intArr[j]).append(",");
				}
				response.add(str.substring(0, str.length() - 1));
			}
			indicies.add(i);
			map.put(sum, indicies);

		}
		return response.toArray(new String[] { "" });
	}

	public static void main(String[] arg) {
		String[] res = sumZero(new int[] { 0, 1, 2, 3, 4, -10 });
		for (String s : res) {
			System.out.println(s);
		}
	}
	
	
}

class Pair<T> {
	T x;
	T y;
	public Pair(T x, T y) {
		this.x = x;
		this.y = y;
	}
}
class PairComparator implements Comparator<Pair<Integer>> {

	@Override
	public int compare(Pair<Integer> o1, Pair<Integer> o2) {
		// TODO Auto-generated method stub
		return new Integer(o1.x).compareTo(new Integer(o2.x));
	}
	
}
