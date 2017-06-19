package medium;

public class SearchRange {

	public int[] searchRange(int[] nums, int target) {
		
		if(nums==null || nums.length==0){
			return new int[]{-1,-1};
		}
		int[] result = search(nums,target,0,nums.length-1);
		return result;
	}

	private int[] search(int[] nums, int target, int left, int right) {
		if((left==right || right<0) && nums[left]!=target){
			return new int[]{-1,-1};
		}
		int midPoint = (left+right)/2;
		if(nums[midPoint]==target){
			int lEndPoint = -1;
			int rEndPoint = -1;			
			if(midPoint==0 || nums[midPoint-1]!=target){
				lEndPoint = midPoint;
				
			}else{
				lEndPoint = lSearch(nums,target,left,midPoint-1);
			}
			if(midPoint==nums.length-1 || nums[midPoint+1]!=target){
				rEndPoint = midPoint;
			}else{
				rEndPoint = rSearch(nums,target,midPoint+1,right);
			}
			return new int[]{lEndPoint,rEndPoint};
		}else if(nums[midPoint] < target){
			return search(nums,target,midPoint+1,right);
		}else{
			return search(nums,target,left,midPoint-1);
		}
	}
	
	private int rSearch(int[] nums, int target, int left, int right) {
		int midPoint = (left+right)/2;
		if(nums[midPoint]==target){
			if(midPoint==nums.length-1 || nums[midPoint+1]!=target){
				return midPoint;
			}else{
				return rSearch(nums,target,midPoint+1,right);
			}
		}else if(nums[midPoint] < target){
			return rSearch(nums,target,midPoint+1,right);
		}else{
			return rSearch(nums,target,left,midPoint-1);
		}
	}

	private int lSearch(int[] nums, int target, int left, int right) {
		int midPoint = (left+right)/2;
		if(nums[midPoint]==target){
			if(midPoint==0 || nums[midPoint-1]!=target){
				return midPoint;
			}else{
				return lSearch(nums,target,left,midPoint-1);
			}
		}else if(nums[midPoint] < target){
			return lSearch(nums,target,midPoint+1,right);
		}else{
			return lSearch(nums,target,left,midPoint-1);
		}
	}

	public static void main(String[] arg){
		int[] result = new SearchRange().searchRange(new int[]{2,2},1);
		System.out.println(result[0]+" "+result[1]);
	}
}
