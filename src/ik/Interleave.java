package ik;

import java.io.*;
public class Interleave {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        System.out.println(interleave("db","b", "cbb"));
    }
    
    private static boolean interleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                int k = i+j-1;
                if(i==0 && j==0) {
                    dp[i][j] = true;
                }
                else{ 
                    if(i==0) {
                        dp[i][j] = (dp[i][j-1] && s3.charAt(k) == s2.charAt(j-1));
                    }
                    else if(j==0) {
                        dp[i][j] = (dp[i-1][j] && s3.charAt(k) == s1.charAt(i-1));
                    }
                    else{
                        if(!dp[i-1][j] && !dp[i][j-1]) {
                            dp[i][j] = false;
                        }
                        else if(dp[i-1][j] && dp[i][j-1]) {
                            dp[i][j] = (s3.charAt(k) == s1.charAt(i-1)) || (s3.charAt(k) == s2.charAt(j-1));
                        }
                        else{
                            if(dp[i-1][j]) {
                                dp[i][j] = s3.charAt(k) == s1.charAt(i-1);
                            }else{
                                dp[i][j] = s3.charAt(k) == s2.charAt(j-1);
                            }
                        }
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}