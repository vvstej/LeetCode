package medium;

import java.util.Arrays;

public class RotatedSearch {

    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int pivot = findPivot(nums,0, nums.length-1);
        int index = binarySearch(nums, pivot, target, 0, nums.length);
        return index;
    }
    
    private int binarySearch(int[] nums, int pivot, int target, int startIndex, int endIndex) {
		if(pivot!=-1){
			if(target <= nums[pivot] && target >= nums[0]){
				int ret =  Arrays.binarySearch(nums, startIndex, pivot+1, target);
				return ret < 0 ? -1 : ret;
			}
			if(target <= nums[pivot] && target < nums[0]){
				int ret =  Arrays.binarySearch(nums, pivot+1, endIndex, target);
				return ret < 0 ? -1 : ret;
			}
		}
		int ret = Arrays.binarySearch(nums, startIndex, endIndex, target);
		return ret < 0 ? -1 : ret;
	}

	public int findPivot(int[] nums, int startIndex, int endIndex){
        if(startIndex==endIndex){
        	if(startIndex==nums.length-1){
        		return -1;
        	}
            if(nums[startIndex] < nums[startIndex+1]){
                return -1;
            }else{
                return startIndex;
            }
        }
        int mid = (startIndex + endIndex)/2;
        if(nums[mid] > nums[mid+1]){
            return mid;
        }
        if(nums[mid] >= nums[0]){
            return findPivot(nums, mid+1, endIndex);
        }
        else{
            return findPivot(nums, startIndex, mid-1);
        }
        
    }
    
    public static void main(String[] arg){
    	System.out.println(new RotatedSearch().search(new int[]{4,5 ,6 ,7 ,0 ,1 ,2}, 4));
    }
}
