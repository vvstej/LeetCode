package medium;

public class Power {
	public double myPow(double x, int n) {
        double retVal = myPower(x,n);
        if(n%2==1){
            return x * retVal; 
        }
        else 
            return retVal;
    }
    public double myPower(double x, int n){
        if(n==0){
            return 1;
        }else if(n==1){
            return x;
        }else{
            double retVal = myPow(x,n/2);
            return retVal * retVal;
        }
    }   
    
    public static void main(String[] arg){
    	Power p = new Power();
    	p.myPow(2,3);
    }
}
