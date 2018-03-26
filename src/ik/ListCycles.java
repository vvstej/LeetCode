package ik;

public class ListCycles {

	 static float pow(float base, int power) {
	        float result = powHelper(base, power);
	        return power < 0 ? (1/result) : result;
	    }
	    

	    static float powHelper(float base, int power) {
	        if(power==0) {
	            return 1;
	        }
	        float prev = powHelper(base, power/2);
	        float curr = prev*prev;
	        if(power%2==1 || power%2==-1) {
	            curr*=base;
	        }
	        return curr;
	        }    
	    
	    public static void main(String[] arg) {
	    	System.out.println(pow(4.5F, -3));
	    }
}
