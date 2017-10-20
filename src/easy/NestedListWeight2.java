package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedListWeight2 {
	public int depthSumInverse(List<NestedInteger> nestedList) {
		if (nestedList.size() == 0) {
			return 0;
		}
		Map<Integer, Integer> depthToSum = new HashMap<Integer, Integer>();
		for (NestedInteger nestedInteger : nestedList) {
			flattenList(nestedInteger, depthToSum, 1);
		}
		int sum = 0;
		int maxDepth = 0;
		for (Integer depth : depthToSum.keySet()) {
			if (depth > maxDepth) {
				maxDepth = depth;
			}
		}
		for (Integer depth : depthToSum.keySet()) {
			sum += depthToSum.get(depth) * (maxDepth + 1 - depth);
		}
		return sum;
	}

	public void flattenList(NestedInteger nestedInteger, Map<Integer, Integer> depthToSum, int currDepth) {
		if (nestedInteger.isInteger()) {
			int newSum = nestedInteger.getInteger();
			if (depthToSum.containsKey(currDepth)) {
				newSum = depthToSum.get(currDepth) + nestedInteger.getInteger();
			}
			depthToSum.put(currDepth, newSum);
			return;
		}
		for (NestedInteger innerNestedInteger : nestedInteger.getList()) {
			flattenList(innerNestedInteger, depthToSum, currDepth + 1);
		}
	}
}
