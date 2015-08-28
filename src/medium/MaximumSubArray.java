package medium;

import com.sun.javafx.image.impl.IntArgb;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        int prevMax = nums[0];
        int globalMax = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]+prevMax > nums[i]){
                prevMax = nums[i]+prevMax;
            }else{
                prevMax = nums[i];
            }
            if(globalMax <= prevMax){
                globalMax = prevMax;
            }
        }
        return globalMax;
    }
    
    public static void main(String[] arg){
    	MaximumSubArray subArray = new MaximumSubArray();
    	System.out.println(subArray.maxSubArray(new int[]{1,2,3,-300,4}));
    	System.out.println(subArray.maxSubArray(new int[]{-200,300}));
    	System.out.println(subArray.maxSubArray(new int[]{400,-300}));
    	System.out.println(subArray.maxSubArray(new int[]{-400,-300}));
    	System.out.println(subArray.maxSubArray(new int[]{44,300,0,-44,-290,345}));
    	System.out.println(subArray.maxSubArray(new int[]{8,-19,5,-4,20}));
    	
    }
}
