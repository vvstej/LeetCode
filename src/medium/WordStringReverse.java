package medium;

public class WordStringReverse {

    public void reverseWords(char[] s) {
        int start = 0;
        int end = 0;
        boolean isPrevDelimeter = false;
        for(int i=0;i<s.length;i++){
            if(s[i]==' '){
                end = i-1;
                isPrevDelimeter =  true;
            
                for(int j=start,k=end;j<k;j++,k--){
                    char temp = s[j];
                    s[j] = s[k];
                    s[k] = temp;
                }
                start = i+1;
            }
        }
        // last word
        for(int j=start,k=s.length-1;j<k;j++,k--){
            char temp = s[j];
            s[j] = s[k];
            s[k] = temp;
        }
        
        // reverse string
        for(int i=0,j=s.length-1;i<j;i++,j--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
    
    public static void main(String[] arg){
    	char[] s = "the sky is blue".toCharArray();
    	new WordStringReverse().reverseWords(s);
    	System.out.println(s);
    	
    }
}
