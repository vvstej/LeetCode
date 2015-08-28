package medium;

public class NumDecodings {

	public int numDecodings(String s) {
        int n = s.length();
        
        if (n == 0 || s.startsWith("0")) {
            return 0;
        }
        int dp[] = new int[s.length()];
        if(s.length()==1){
        	dp[0] = 1;
        }
        if(s.length()==2){
        	int val = Integer.parseInt(s);
        	dp[1] = (val <=26 && val!=10) ? 2 : 1;
        }
        for (int i = 2; i <= n; i++) {
        	
//            int first = Integer.parseInt(s.substring(i-2, i));
//            int prev = (first <= 26 && first > 9) ? ways[i-2]:0;
//            int plus = (Integer.parseInt(s.substring(i-1, i)) == 0) ? 0:ways[i-1];
//            ways[i] = prev + plus;
        }
        return dp[n];
    }
	
	public static void main(String[] arg){
		System.out.println(new NumDecodings().numDecodings("12345"));
	}
}
