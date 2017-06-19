package hard;

public class RegexMatchingBackTracking {

	public boolean isMatch(String s, String p) {
		int patternIndex = 0, stringIndex = 0;
		return isMatch(patternIndex, stringIndex, s, p);
		// isMatch(String s, string p, patternIndex, stringIndex);

	}

	private boolean isMatch(int patternIndex, int stringIndex, String s, String p) {
		// TODO Auto-generated method stub
		if (patternIndex == p.length() ^ stringIndex == s.length()) {
			return false;
		}
		if(patternIndex == p.length() && stringIndex == s.length()){
			return true;
		}
		char currentCharInString = s.charAt(stringIndex);
		if (p.charAt(patternIndex) == '*') {
			char charToRepeat = p.charAt(patternIndex - 1);
			if(charToRepeat=='.'){
				if(currentCharInString==s.charAt(stringIndex-1)){
					isMatch(patternIndex, stringIndex + 1, s, p);
				}else{
					return false;
				}
			}
			if (charToRepeat == currentCharInString) {
				if(stringIndex==s.length()-1){
					if(patternIndex==p.length()-1){
						return true;
					}else return false;
				}
				boolean matched = isMatch(patternIndex, stringIndex + 1, s, p);
				if(!matched){
					return isMatch(patternIndex+1,stringIndex,s,p);
				}
				return true;
			} else {
				return isMatch(patternIndex+1,stringIndex,s,p);
			}
		} else if (p.charAt(patternIndex) == '.') {
			isMatch(patternIndex + 1, stringIndex + 1, s, p);
		} else if (p.charAt(patternIndex) != s.charAt(stringIndex)) {
			return false;
		} else if (p.charAt(patternIndex) == s.charAt(stringIndex)) {

			return isMatch(patternIndex + 1, stringIndex + 1, s, p);
		}
		return true;

	}
	
	public static void main(String[] arg){
		System.out.println(new RegexMatchingBackTracking().isMatch("aa", "a*b"));
	}
}
