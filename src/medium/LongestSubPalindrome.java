package medium;

public class LongestSubPalindrome {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        int length = s.length();
        int maxPalinLength = 0;
        int startIndex = 0;
        boolean[][] isPalindrome = new boolean[length][length];
        for(int j=0;j<length;j++){
            isPalindrome[j][j] = true;
            maxPalinLength = 1;
            startIndex = j;
        }
        for(int i=0;i<length-1;i++){
            isPalindrome[i][i+1] = (s.charAt(i)==s.charAt(i+1));
            if(isPalindrome[i][i+1]){
               startIndex = i;
               maxPalinLength = 2;
            }
            
            
        }
        int len=0;
        for(len=3;len<=length;len++){
            for(int i=0;i<length-len+1;i++){
                int j = len+i-1;
                if(isPalindrome[i+1][j-1] && (s.charAt(i)==s.charAt(j))){
                    isPalindrome[i][j] = true;
                    maxPalinLength = len;
                    startIndex = i;
                }
                
            }
        }
		return s.substring(startIndex, startIndex+maxPalinLength);
    }
    
    public static void main(String[] arg){
    	System.out.println(new LongestSubPalindrome().longestPalindrome("ababa"));
    }
}
