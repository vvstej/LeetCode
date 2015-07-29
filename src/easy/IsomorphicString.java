package easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

	public boolean isIsomorphic(String s, String t) {
		int length = s.length();
		if (t.length() != length) {
			return false;
		}

		Map<Character, Character> presenceMap = new HashMap<Character, Character>();
		Map<Character, Character> reversePresenceMap = new HashMap<Character, Character>();
		for (int index = 0; index < length; index++) {
			if (presenceMap.containsKey(s.charAt(index))) {
				Character expectedCharAtIndex = presenceMap
						.get(s.charAt(index));
				Character reverseExpectation = reversePresenceMap.get(t
						.charAt(index));
				if (expectedCharAtIndex != null
						&& expectedCharAtIndex.charValue() == t.charAt(index)
						&& reverseExpectation != null
						&& reverseExpectation.charValue() == s.charAt(index)) {
					continue;
				} else {
					return false;
				}
			} else {
				if (reversePresenceMap.containsKey(t.charAt(index))) {
					return false;
				} else {
					presenceMap.put(s.charAt(index), t.charAt(index));
					reversePresenceMap.put(t.charAt(index), s.charAt(index));
				}

			}
		}
		return true;
	}

	public static void main(String[] arg) {
		System.out.println(new IsomorphicString().isIsomorphic("abcg", "defd"));
	}
}
