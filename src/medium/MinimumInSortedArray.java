package medium;

public class MinimumInSortedArray {

	public int findMin(int[] nums) {
		if (nums.length == 0) {
			return -1;
		} else if (nums.length == 1) {
			return nums[0];
		}
		return doBinarySearchAndFindMin(nums, 0, nums.length - 1);
	}

	private int doBinarySearchAndFindMin(int[] nums, int lowerEnd, int upperEnd) {
		if (upperEnd - lowerEnd <= 2) {
			if (upperEnd - lowerEnd == 2) {
				int middle = (lowerEnd + upperEnd) / 2;
				boolean leftImbalance = nums[middle] < nums[lowerEnd];
				boolean rightImbalance = nums[middle] > nums[upperEnd];
				if (leftImbalance) {
					return nums[middle];
				}
				if (rightImbalance) {
					return nums[upperEnd];
				}
			} else if (upperEnd - lowerEnd == 1) {
				return (nums[lowerEnd] > nums[upperEnd]) ? nums[upperEnd]
						: nums[lowerEnd];
			}
		} else {
			int middle = (lowerEnd + upperEnd) / 2;
			boolean leftImbalance = nums[middle] < nums[lowerEnd];
			boolean rightImbalance = nums[middle] > nums[upperEnd];
			if (leftImbalance) {
				return doBinarySearchAndFindMin(nums, lowerEnd, middle);
			} else if (rightImbalance) {
				return doBinarySearchAndFindMin(nums, middle, upperEnd);
			}
		}

		return nums[lowerEnd];

	}

	public static void main(String[] arg) {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(new MinimumInSortedArray().findMin(nums));
	}
}
