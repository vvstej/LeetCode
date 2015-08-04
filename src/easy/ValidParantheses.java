package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidParantheses {
	public boolean isValid(String s) {
		if(s.trim().equals("")){
			return false;
		}
		s = s.trim();
		Deque<Character> stack = new ArrayDeque<Character>();
		final List<Character> popElements = new ArrayList<Character>();
		popElements.add(')');
		popElements.add('}');
		popElements.add(']');
		final List<Character> pushElements = new ArrayList<Character>();
		pushElements.add('(');
		pushElements.add('{');
		pushElements.add('[');
		Map<Character, Character> paranMap = new HashMap<Character, Character>();
		for (int i = 0; i < 3; i++) {
			paranMap.put(pushElements.get(i), popElements.get(i));
		}

		for (int i = 0; i < s.length(); i++) {
			char currParan = s.charAt(i);
			if (pushElements.contains(currParan)) {
				stack.push(s.charAt(i));
			} else if (popElements.contains(currParan)) {
				if(stack.isEmpty()) return false;
				char stackParan = stack.pop();
				if (paranMap.get(stackParan) != currParan) {
					return false;
				} else {
					continue;
				}
			}else{
				// invalid element
				return false;
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] arg){
		System.out.println(new ValidParantheses().isValid("[{({})}]"));
	}
}
