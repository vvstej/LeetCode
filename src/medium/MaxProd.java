package medium;

public class MaxProd {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0 ) return 0;
        int globalMax = nums[0];
        int totalProduct = nums[0];
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            totalProduct  *= nums[i];
            if(max[i-1]*nums[i] > nums[i]){
                max[i] = (totalProduct > nums[i]*max[i-1]) ? totalProduct : nums[i]*max[i-1];
            }else{
            	//max[i] = nums[i];
            	max[i] = (totalProduct > nums[i]) ? totalProduct : nums[i];
            }
           
            if(globalMax < max[i]){
                globalMax = max[i];
            }
        
        }
        return globalMax;
    }
    public static void main(String[] arg){
    	System.out.println(new MaxProd().maxProduct(new int[]{2,-5,-2,-4,3}));
    }
}
