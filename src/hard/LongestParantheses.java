package hard;

import java.util.Stack;

public class LongestParantheses {
	public int longestValidParentheses(String s) {
		Stack<SEntry> stack = new Stack<>();
		int gMax = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(new SEntry('(', 0));
			} else if (s.charAt(i) == ')' && !stack.isEmpty()) {
				SEntry top = stack.peek();
				if (top.c == '(') {
					stack.pop();
					stack.push(new SEntry('#', 2));
					gMax = Math.max(gMax, 2);
				} else if (top.c == '#') {
					int currCount = 0;
					while (top.c == '#') {
						stack.pop();
						currCount += top.count;
						if (stack.isEmpty())
							break;
						top = stack.peek();
					}
					if (!stack.isEmpty() && stack.peek().c == '(') {
						currCount += 2;
						stack.pop();
						stack.push(new SEntry('#', currCount));
					}
					gMax = Math.max(gMax, currCount);

				}
			}
		}
		int currCount = 0;
		while(!stack.isEmpty()) {
			if(stack.peek().c=='(') {
				currCount = 0;
				stack.pop();
			}
			else if(stack.peek().c == '#') {
				currCount += stack.pop().count;
				gMax = Math.max(gMax, currCount);
			}
		}
		return gMax;
	}

	static class SEntry {
		Character c;
		int count;

		public SEntry(Character c, int count) {
			this.c = c;
			this.count = count;
		}
	}

	public static void main(String[] arg) {
		System.out.println(new LongestParantheses().longestValidParentheses(")()(((())))("));
	}

}