package ik;

public class RecursivePalin {

	static boolean isPalindrome(String strarr) {
        char[] input = strarr.toCharArray();
        return isPalindromeHelper(strarr);

    }

    static boolean isPalindromeHelper(String input) {
        if(input.length() == 0 || input.length() ==1 ) {
            return true;
        }
        int beginIndex = 0;
        int endIndex = input.length()-1;
        while(input.charAt(beginIndex)=='.' || input.charAt(beginIndex)==',' || input.charAt(beginIndex)=='!' || input.charAt(beginIndex)==';' || input.charAt(beginIndex) == ' ' || input.charAt(beginIndex)== '-' || input.charAt(beginIndex)==':' || input.charAt(beginIndex)=='"' || input.charAt(beginIndex)=='\'' || input.charAt(beginIndex)=='\\') {
              beginIndex++;
              }
         while(input.charAt(endIndex)=='.' || input.charAt(endIndex)==',' || input.charAt(endIndex)=='!' || input.charAt(endIndex)==';' || input.charAt(endIndex) == ' ' || input.charAt(endIndex)== '-' || input.charAt(endIndex)==':' || input.charAt(endIndex)=='"' || input.charAt(endIndex)=='\'' || input.charAt(endIndex)=='\\') {
              endIndex--;
              }
          if(beginIndex > endIndex) {
              return true;
          }
          if(Character.toLowerCase(input.charAt(beginIndex)) == Character.toLowerCase(input.charAt(endIndex))){
        	  if(beginIndex+1 <= endIndex)
        		  return isPalindromeHelper(input.substring(beginIndex+1, endIndex));
        	  else return true;
          }
              return false;
    }
    
    public static void main(String[] arg) {
    	System.out.println(RecursivePalin.isPalindrome("Dammit I'm mad."));
    }

}
