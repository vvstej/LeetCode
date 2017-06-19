package easy;

public class Binary {

	public static void main(String[] arg){
		int [] nums = new int[]{15,17,15,15,17};
		int len = nums.length, result = 0;
	    for (int i = 0; i < 32; i++) {
	        int sum = 0;
	        for (int j = 0; j < len; j++) {
	            sum += (nums[j] >> i) & 1;
	        }
	        result |= (sum % 3) << i;
	    }
	 System.out.println(result);   
	}
}
