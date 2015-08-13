package easy;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        String res = "";
        for(int i = 0; i < Integer.MAX_VALUE&& strs.length!=0;i++){
            if(i >= strs[0].length()) return res;
            char c = strs[0].charAt(i);
            for(String s : strs){
                if(i >= s.length()||c!=s.charAt(i)) return res;
            }
            res+=c;
        }

        return res;
    }
	public static void main(String[] arg){
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"hello","hellw","hel"}));
	}
}
