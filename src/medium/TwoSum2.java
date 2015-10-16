package medium;

import java.util.Arrays;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0){
            return new int[]{-1,-1};
        }
        int sumRemaining = target;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] > sumRemaining ){
                return new int[]{-1,-1};
            }
            sumRemaining = sumRemaining - numbers[i];
            if(sumRemaining < numbers[i]){
                return new int[]{-1,-1};
            }
            int index = Arrays.binarySearch(numbers,i+1,numbers.length,sumRemaining);
            if(index<0){
            	sumRemaining = target;
                continue;
            }
            else{
                return new int[]{i,index};
            }
        }
		return new int[]{-1,-1};
    }
    
    public static void main(String[] arg){
    	TwoSum2 sum2 = new TwoSum2();
    	int[] ret = sum2.twoSum(new int[]{2,7,11,15}, 22);
    	for(int i=0;i<2;i++){
    		System.out.println(ret[i]);
    	}
    }
}
