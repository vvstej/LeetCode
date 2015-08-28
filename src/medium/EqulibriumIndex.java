package medium;

public class EqulibriumIndex {

	public int solution(int[] A){
		if(A.length==0) return -1;
		if(A.length==1) return 1;
		long totalSum = A[0];
		long[] interSum = new long[A.length];
		int index = -1;
		for(int i=1;i<A.length;i++){
			totalSum+=A[i];
		}
		interSum[0] = A[0];
		for(int i=1;i<A.length;i++){
			interSum[i]= interSum[i-1]+A[i];
		}
		for(int i=0;i<A.length;i++){
			long temp = totalSum-interSum[i];
			if(i==0 || i==A.length-1){
				if(i==0){
					if(interSum[i+1]==0){
						index = i;
						break;
					}
				}else if(i==A.length-1){
					if(interSum[i-1]==0){
						index = i;
						break;
					}
				}
				
			}
			else{
				if(temp==interSum[i-1]){
					index = i;
					break;
				}
			}
		}
		return index;
	}
public static void main(String[] arg){
	System.out.println(new EqulibriumIndex().solution(new int[]{500, 1, -2, -1, 2}));
}
}

