package medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
        int maxCount = 0;
        int maxElement = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            Integer count = countMap.get(nums[i]);
            if(count==null){
            	count=1;
                countMap.put(nums[i],1);
            }else{
                count++;
                countMap.put(nums[i],count);
                
            }
            if(count>maxCount){
                maxCount = count;
                maxElement = nums[i];
            }
        }
         return maxElement; 
      }
    
    public static void main(String[] arg){
    	System.out.println(new MajorityElement().majorityElement(new int[]{1,1,1,1,5,68,9,1,14,14,3,2,1,6,6,6,6,4,4,4,9,4,4,4}));
    }
}
