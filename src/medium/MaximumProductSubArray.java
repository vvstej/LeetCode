package medium;

public class MaximumProductSubArray {

	 public int maxProduct(int[] nums) {
	        if(nums.length==0){
	            return 0;
	        }else if(nums.length==1){
	            return nums[0];
	        }
	        int prevMax = nums[0];
	        int prevMin = nums[0];
	        int globalMax = nums[0];
	        for(int i=1;i<nums.length;i++){
	            int maxProduct = prevMax * nums[i];
	            int minProduct = prevMin * nums[i];
	            
	            int currMax = maxProduct > minProduct ? maxProduct : minProduct;
	            int currMin = minProduct < maxProduct ? minProduct : maxProduct;
	            if(nums[i] > currMax){
	                prevMax = nums[i];
	            }else{
	                prevMax = currMax;
	            }
	            if(nums[i] < currMin){
	                prevMin = nums[i];
	            }else{
	                prevMin = currMin;
	            }
	            if(globalMax < prevMax) {
	                globalMax = prevMax;
	            }
	        }
	        return globalMax;
	    }
	 
	 public static void main(String[] arg){
		 MaximumProductSubArray mps = new MaximumProductSubArray();
		 //System.out.println(mps.maxProduct(new int[]{2,3,-2,4}));
		// System.out.println(mps.maxProduct(new int[]{0,1,-1,0}));
		 System.out.println(mps.maxProduct(new int[]{-2,3,-2,4,-5}));
	 }
}
