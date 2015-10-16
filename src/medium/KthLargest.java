package medium;

import java.util.PriorityQueue;

public class KthLargest {
	public int findKthLargest(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 0; i < k; i++) {
			queue.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > queue.peek()) {
				queue.remove();
				queue.add(nums[i]);
			}
		}
		return queue.remove();
	}

	public static void main(String[] arg) {
		System.out.println(new KthLargest().findKthLargest(new int[] { 25,-6,8,100,22 }, 3));
	}
}

