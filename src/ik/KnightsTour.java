package ik;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KnightsTour {
	
	public static void main(String[] arg) {
		System.out.println(numPhoneNumbers(6, 10));
	}

	static long numPhoneNumbers(int startdigit, int phonenumberlength) {
        Map<Integer, Set<Integer>> moves = new HashMap<Integer, Set<Integer>>();
        
        Set<Integer> s = new HashSet<>();
        s.add(8);
        s.add(6);
        moves.put(1, new HashSet<Integer>(s));
        s.clear();
        s.add(9);
        s.add(7);
        moves.put(2, new HashSet<Integer>(s));
        s.clear();
        s.add(8);
        s.add(4);
        moves.put(3, new HashSet<Integer>(s));
        s.clear();
        s.add(3);
        s.add(9);
        s.add(0);
        moves.put(4, new HashSet<Integer>(s));      
        s.clear();
        moves.put(5, new HashSet<Integer>(s));
        s.add(1);
        s.add(7);
        s.add(0);
        moves.put(6, new HashSet<Integer>(s));
        s.clear();
        s.add(2);
        s.add(6);
        //s.add(0);
        moves.put(7, new HashSet<Integer>(s));
        s.clear();
        s.add(1);
        s.add(3);
        moves.put(8, new HashSet<Integer>(s));
        s.clear();
        s.add(2);
        s.add(4);
        moves.put(9, new HashSet<Integer>(s));
        s.clear();
        s.add(4);
        s.add(6);
        moves.put(0, new HashSet<Integer>(s));
        Set<Integer> prev = new HashSet<>();
        prev.add(startdigit);
        long[][] dp = new long[10][phonenumberlength+1];
        for(int len=1;len<=phonenumberlength;++len) {
        	for(int i=0;i<=9;i++) {
        		if(len==1) {
        			dp[i][len] = 1;
        		}
        		else{
        			long sum=0;
        			//System.out.println(i);
        			for(int n: moves.get(i)) {
        				sum+=dp[n][len-1];
        			}
        			dp[i][len] = sum;
        		}
        	}
        }
        return dp[startdigit][phonenumberlength];
        
    }
}
