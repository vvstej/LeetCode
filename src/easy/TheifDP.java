package easy;

public class TheifDP {

	  public int rob(int[] nums) {
	        int length = nums.length;
	        int [] max = new int[length];
	        for(int i=0;i<length;i++){
	        	max[i] = nums[i];
	        }
	        if(length>1){
	        	max[1] = (max[0] > max[1]) ? max[0] : max[1];
	        }
	        if(length>2){
	        	int sum1 = max[0] + nums[2];
	        	max[2] = (sum1 > max[1]) ? sum1 : max[1];
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
		int[] nums = new int[]{20,10,35,15};
		System.out.println(new TheifDP().rob(nums));
	}
}
