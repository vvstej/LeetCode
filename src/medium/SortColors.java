package medium;

public class SortColors {

    public void sortColors(int[] nums) {
    	if(nums.length==0){
    		return;
    	}
        int i=0;
        int j= nums.length-1;
        while(i<j){
            while(i<nums.length && nums[i]==0){
                i++;
            }
            while(j>=0 && nums[j]==2){
                j--;
            }
            if(i<j){
              if(nums[j]==0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
                i++;
            }else{
                j--;
            }
            }
       
        }
        
        i=0;
        j= nums.length-1;
        while(i<j){
        	while(i<nums.length && nums[i]==0){
                i++;
            }
            while(j>=0 && nums[j]==2){
                j--;
            }
            if(i<j){
              if(nums[i]==2){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
                i++;
            }else{
                i++;
            }
            }
       
        }
        
    }
    
    public static void main(String[] arg){
    	int[] colors = new int[]{2,2,1};
    	new SortColors().sortColors(colors);
    	for(int color: colors)
    	System.out.println(color);
    }
}
