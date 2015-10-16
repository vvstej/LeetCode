package medium;

public class PowerFunction {
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        boolean isPowerEven = (n%2==0);
        boolean isPowerNegative = (n < 0);
        boolean isBaseNegative = (x > 0) ? false : true;
        boolean isResultNegative =  isBaseNegative && !isPowerEven;
        long n1 = n;
        n1 = Math.abs(n1);
        double result = pow(x,n1);
        if(n1%2!=0 && n1>1){
            result*= x;
        }
        result = (isResultNegative) ? result*-1 : result;
        result = (isPowerNegative) ? 1/result : result;
        return result ;
    }
    
    public double pow(double x,long n){
        if(n==1){
            return x;
        }
        double result = pow(x,n/2);
        result *= result;
        return result;
    }
    
    public static void main(String[] arg){
    	System.out.println(new PowerFunction().myPow(4.70975,6));
    }
}
