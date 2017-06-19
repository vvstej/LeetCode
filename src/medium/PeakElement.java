package medium;

public class PeakElement {

	public int findPeakElement(int[] nums) {
        if(nums== null || nums.length==0){
            return -1;
        }
        int result = findPeak(nums,0,nums.length-1);
        return result;
    }
    
    private int findPeak(int[] nums, int start, int end){
        int midPoint = (start+end)/2;
        if(midPoint==0){
            if(nums[midPoint] > nums[midPoint+1]){
                return 0;
            }else{
                return -1;
            }
        }
        if(midPoint==nums.length-1){
           if(nums[midPoint] > nums[midPoint-1]){
                return nums.length-1;
            }else{
                return -1;
            } 
        }
        if(nums[midPoint] > nums[midPoint-1] && nums[midPoint] > nums[midPoint+1]){
            return midPoint;
        }
        if(nums[midPoint] > nums[midPoint+1] ){
            return findPeak(nums,start,midPoint);
        }else{
            return findPeak(nums,midPoint+1,end);
        }
    }
    
    public static void main(String[] arg){
    	System.out.println(new PeakElement().findPeakElement(new int[]{5,5,4,1,2,3}));
    }
}
