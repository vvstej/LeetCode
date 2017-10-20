package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedListWeight {
	public int depthSum(List<NestedInteger> nestedList) {
		if (nestedList.size() == 0) {
			return 0;
		}
		Map<Integer, Integer> depthToSum = new HashMap<Integer, Integer>();
		for (NestedInteger nestedInteger : nestedList) {
			flattenList(nestedInteger, depthToSum, 1);
		}
		int sum = 0;
		for (Integer depth : depthToSum.keySet()) {
			sum += depthToSum.get(depth) * depth;
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

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
