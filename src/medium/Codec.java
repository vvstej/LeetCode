package medium;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        StringBuilder concatenatedStrings = new StringBuilder();
        int noOfStrings = strs.size();
        encodedString.append(noOfStrings).append(";");
        for(String str : strs){
            encodedString.append(str.length()).append(";");
            concatenatedStrings.append(str);
        }
        encodedString.append(concatenatedStrings);
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int prevOccuranceOfDelimeter = s.indexOf(";");
        
        String temp = s.substring(0,prevOccuranceOfDelimeter);
        int noOfStrings = Integer.parseInt(temp);
        int[] lengthsOfStrings = new int[noOfStrings];
        List<String> sourceList = new ArrayList<String>(noOfStrings);
        int j=0;
        int nextOccuranceOfDelimeter = 0;
        for(int i=0;i<noOfStrings;i++){
        	nextOccuranceOfDelimeter = s.indexOf(";",prevOccuranceOfDelimeter+1);
            lengthsOfStrings[j] = Integer.parseInt(s.substring(prevOccuranceOfDelimeter+1,nextOccuranceOfDelimeter));
            prevOccuranceOfDelimeter = nextOccuranceOfDelimeter;
            j++;
        }
        int start = prevOccuranceOfDelimeter+1;
        for(int i=0;i<noOfStrings;i++){
            sourceList.add(s.substring(start,start+lengthsOfStrings[i]));
            start=start+lengthsOfStrings[i];
        }
        return sourceList;
    }
    
    public static void main(String[] arg){
    	List<String> strings = new ArrayList<String>();
    	strings.add("అఋ");
    	strings.add("afsdfa3543$%#$``@#$@$#");
    	Codec c = new Codec();
    	String encodedString = c.encode(strings);
    	System.out.println(encodedString);
    	List<String> decodedStrings = c.decode(encodedString);
    	for(String s : decodedStrings){
    		System.out.println(s);
    	}
    }
}
