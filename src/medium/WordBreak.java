package medium;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || s.length()==0){
            return false;
        }
        int length = s.length();
        s = s.trim();
        boolean[] dp = new boolean[length];
        
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                boolean isWordPresentInDict = wordDict.contains(s.substring(i,j+1));
                if(i>0){
                	if(!dp[j])
                		dp[j] = isWordPresentInDict && dp[i-1];
                }
                else{
                	if(!dp[j])
                		dp[j] = isWordPresentInDict;
                }
            }
        }
        
        return dp[length-1];
    }
	
	public static void main(String[] arg){
		WordBreak word = new WordBreak();
		Set<String> s = new HashSet<String>();
//		s.add("a");
//		s.add("b");
//		s.add("abc");
//		s.add("cd");
		s.add("l");
		s.add("le");
		s.add("et");
		s.add("code");
//		s.add("aaaa");
//		s.add("aa");
		System.out.println(word.wordBreak("letcode", s));
	}
}
