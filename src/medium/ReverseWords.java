package medium;

public class ReverseWords {

	public String reverseWords(String s) {
        if(s==null  || s.length()==0){
            return "";
        }else{
            String[] strings = s.trim().split("\\s+");
            StringBuilder builder = new StringBuilder();
            
            for(int i=strings.length-1;i>=0;i--){
               builder.append(strings[i]);
               if(i>0){
                   builder.append(" ");
               }
            }
            return builder.toString();
        }
    }
	
	public static void main(String[] arg){
		System.out.println(new ReverseWords().reverseWords("the sky is blue "));
	}
}
