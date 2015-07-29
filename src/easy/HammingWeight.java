package easy;

public class HammingWeight {

	public int hammingWeight(int n){
		long longNum = (long)n;
		int countOnes = 0;
		for(int i=0;i<32;i++){
			long result = longNum & (long) Math.pow(2, i);
			if(result!=0){
				countOnes++;
			}
		}
		return countOnes;
	}
	
	public static void main(String []arg){
		System.out.println(new HammingWeight().hammingWeight(Integer.MAX_VALUE+1));
	}
}
