package medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    public int findKthLargest(final int[] nums, final int k) {
        if (nums.length == 0) {
            return 0;
        }
        final Queue<Integer> queue = new PriorityQueue<Integer>();
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

    public static void main(final String[] arg) {
        System.out.println(new KthLargest().findKthLargest(new int[] {25, -6, 8, 100, 22}, 3));
    }
}

