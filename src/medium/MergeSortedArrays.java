package medium;

public class MergeSortedArrays {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(n==0){
			return;
		}
		if(m==0){
			for(int i=0;i<n;i++){
				nums1[i] = nums2[i];
			}
		}
        for(int i=m+n-1,j=m-1;j>=0;i--,j--){
            nums1[i] = nums1[j];

        }
        int i=0;
        int j = n;
        int index=0;
        while(i<n && j<m+n){
            if(nums1[j] < nums2[i]){
                nums1[index++] = nums1[j];
                nums1[j] = Integer.MIN_VALUE;
                j++;
            }else if(nums1[j] >nums2[i]){
                nums1[index++] = nums2[i];
                i++;
            }else{
                nums1[index++] = nums2[i];
                nums1[index++] = nums1[j];
                i++;
                j++;
            }
        }
        if(i<=n-1){
            //copy from nums2 to nums1;
            for(;i<=n-1;i++){
                nums1[index++] = nums2[i] ;
            }
        }
        if(j<m+n){
        	for(;j<=m+n-1;j++){
                nums1[index++] = nums1[j] ;
            }
        }
    
    }
	
	public static void main(String[] arg){
		MergeSortedArrays m = new MergeSortedArrays();
		int[] mArray = new int[6];
		mArray[0] = 1;
		mArray[1] = 2;
		mArray[2] = 4;
		mArray[3] = 5;
		mArray[4] = 6;
		m.merge(mArray, 5, new int[]{3}, 1);
		for(int num : mArray){
			System.out.println(num);
		}
		
	}
}
