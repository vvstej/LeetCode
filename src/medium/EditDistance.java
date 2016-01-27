package medium;

public class EditDistance {

	public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen!=tLen){
        	String biggerString = (sLen>tLen)?s:t;
        	String smallerString = (sLen<tLen)?s:t;
        	if(Math.abs(sLen-tLen)>1){
        		return false;
        	}else{
        		if(biggerString.contains(smallerString)){
        			return true;
        		}
        		int rdiff=0;
        		for(int i=0,start=1;i<smallerString.length();i++,start++){
        			if(biggerString.charAt(start)!=smallerString.charAt(i)){
        				rdiff++;
        			}
        		}
        		int ldiff=0;
        		for(int i=0,start=0;i<smallerString.length();i++,start++){
        			if(biggerString.charAt(start)!=smallerString.charAt(i)){
        				ldiff++;
        			}
        		}
        		if(rdiff==1 && (biggerString.charAt(0)==smallerString.charAt(0))){
        			return true;
        		}else{
        			if(ldiff==1 &&(biggerString.charAt(biggerString.length()-1)==smallerString.charAt(smallerString.length()-1))){
        				return true;
        			}
        		}
        		return false;
        	}
        }
        else{
        	boolean isOneEditDistance = false;
        	for(int i=0;i<sLen;i++){
        		if(s.charAt(i)!=t.charAt(i)){
        			if(!isOneEditDistance)
        				isOneEditDistance=true;
        			else{
        				return false;
        			}
        		}
        	}
        	return isOneEditDistance;
        }
    }
	
	public static void main(String[] arg){
		System.out.println(new EditDistance().isOneEditDistance("acb", "ab"));
	}
}
