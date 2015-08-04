package medium;

public class ThiefDP2 {
	 public int rob(int[] nums) {
		 if(nums.length==0){
			 return 0;
		 }else if(nums.length==1){
			 return nums[0];
		 }
		 int[] firstPass = new int[nums.length-1];
		 int[] secondPass = new int[nums.length-1];
		 for(int i=0;i<nums.length-1;i++){
			 firstPass[i] = nums[i];
			 secondPass[i] = nums[i+1];
		 }
		    int max1 = robDPSolution(firstPass);
		    int max2 = robDPSolution(secondPass);
			return max1 > max2 ? max1 : max2;
	        
	  }

	private int robDPSolution(int[] nums) {
		int length = nums.length;
        int [] max = new int[length];
        for(int i=0;i<length;i++){
        	max[i] = nums[i];
        }
        if(length>1){
        	max[1] = (max[0] > max[1]) ? max[0] : max[1];
        }
        if(length>2){
        	int sum = max[0] + max[2];
        	max[2] = (sum > max[1]) ? sum : max[1];
        }
        // start dp solution
        for(int i=3;i<length;i++){
        	for(int j = i-3; j<=i-2;j++){
        		int sum = nums[i] + max[j];
        		if(sum > max[i]){
        			max[i] = sum;
        		}
        	}
        }
        if(length ==1 || length ==2){
        	return max[length-1];
        }
        if(length > 2)
        	return (max[length-1] > max[length-2]) ? max[length-1] : max[length-2];
        return 0;
	}
	
	public static void main(String[] arg){
		int [] nums = new int[]{23,81,78};
		System.out.println(new ThiefDP2().rob(nums));
	}
}
