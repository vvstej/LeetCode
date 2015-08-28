package medium;

public class MinAbsDiff {

	public int solution(int[] A){
		if(A.length==0 || A.length==1){
			return -1;
		}
		int [] reverseSum = new int[A.length];
		long forwardSum = 0;
		reverseSum[A.length-1] = A[A.length-1];
		for(int i=A.length-2;i>=0;i--){
			reverseSum[i] = reverseSum[i+1] + A[i];
		}
		forwardSum = A[0];
		long absDiff = 0;
		long globalMinDiff = Long.MAX_VALUE;
		for(int i=1;i<A.length;i++){
			absDiff = Math.abs(forwardSum-reverseSum[i]);
			if(absDiff < globalMinDiff){
				globalMinDiff=absDiff;
			}
			forwardSum+=A[i];
		}
		return (int)globalMinDiff;
	}
	
	public static void main(String[] arg){
		MinAbsDiff diffCal = new MinAbsDiff();
		int []input = new int[]{3,1,2,4,3};
		int [] input1 = new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE};
		int [] input2 = new int[100000];
		for(int i=0;i<input2.length;i++){
			if(i%2==0){
				input2[i] = -1000;
			}else{
				input2[i] = 1000;
			}
			
		}
		
		System.out.println(diffCal.solution(input2));
	}
}
