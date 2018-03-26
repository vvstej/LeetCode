package hard;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequenceUnionFind {

	public int longestConsecutive(int[] nums) {
		if (nums.length == 0)
			return 0;
		Map<Integer, Result> map = new HashMap<Integer, Result>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], new Result());
		}

		int longest = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!map.get(nums[i]).visited) {
				int len = find(nums[i], map, 1);
				longest = Math.max(longest, len);
				map.get(nums[i]).visited = true;
			}
		}
		return longest;
	}

	private static int find(int key, Map<Integer, Result> map, int currCount) {
		int initKey = key;
		Result next = map.get(++key);
		while (next != null) {
			if (next.visited) {
				currCount += next.length;
				break;
			} else {
				next.visited = true;
				next.length = ++currCount;
			}
			next = map.get(++key);
		}
		map.get(initKey).visited = true;
		map.get(initKey).length = currCount;
		return currCount;
	}

	static class Result {
		boolean visited;
		Integer root;
		int length;

		public Result() {
			this.root = null;
			this.length = 0;
		}

		Result(boolean visited, Integer root, int length) {
			this.visited = visited;
			this.root = root;
			this.length = length;
		}

	}
	
	public static void main(String[] arg){
		System.out.println(new LongestConsecutiveSequenceUnionFind().longestConsecutive(new int[]{1,0,-1}));
	}
}
