package medium;

public class SortColors2 {

	public void sortColors(int[] nums) {
		if(nums==null || nums.length==0) return;
		reArrange(nums,2);
		reArrange(nums, 1);
    }
	private void reArrange(int[] nums, int targetVal){
		int forwardPtr = 0;
		int backwardPtr = nums.length-1;
		  while(forwardPtr<backwardPtr){
	            if(nums[forwardPtr]==targetVal){
	                if(nums[backwardPtr] < targetVal){
	                    int temp = nums[forwardPtr];
	                    nums[forwardPtr] = nums[backwardPtr];
	                    nums[backwardPtr] = temp;
	                    backwardPtr--;
	                    forwardPtr++;
	                }else{
	                	backwardPtr--;
	                }
	            }else{
	            	forwardPtr++;
	            }
	            
	        }
	}
	public static void main(String[] arg){
		int [] nums = new int[]{2,0,1,1,2,0,1,2,1};
		new SortColors2().sortColors(nums);
		for(int i: nums)
			System.out.print(i+" ");
	}
}
