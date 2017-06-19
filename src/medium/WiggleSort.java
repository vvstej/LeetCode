package medium;

import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i=i+2){
            int temp  = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
    }
    
    public static void main(String[] arg){
    	int[] nums = new int[]{3, 5, 2, 1, 6, 4};
    	new WiggleSort().wiggleSort(nums);
    	for(int i : nums){
    		System.out.print(i+" ");
    	}
    }
}
