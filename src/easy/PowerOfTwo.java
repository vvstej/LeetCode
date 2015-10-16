package easy;

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
	    if(n==1){
	        return false;
	        
	    }
	    int noBits = Integer.bitCount(Math.abs(n));
	    if(noBits==1) {
	        return true;
	    }
	    return false;
	    }
	
	public static void main(String[] arg){
		
		System.out.println(new PowerOfTwo().isPowerOfTwo(2));
	}
}
