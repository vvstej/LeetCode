package easy;

public class RotateArray1 {

	public static void rotate(int[] nums, int k) {
        int count =0, from=0;
        int temp = nums[from];
        int start = 0;
        while(count < nums.length) {
            int to = (from+k)%nums.length;
            int nextTemp = nums[to];
            nums[to] = temp;
            if(start == to) {
            	//reset
            	start++;
            	from = start;
            	temp = nums[from];
            }else{
            	temp = nextTemp;
                from = to;        
            }
            count++;
            
        }
    }
	
	public static void main(String [] arg) {
		int[] arr = new int[]{1,2,3,4,5,6};
		rotate(arr,2);
		for(int val: arr){
			System.out.print(val+" ");
		}
	}
}
