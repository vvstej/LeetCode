package medium;

import java.util.StringTokenizer;

public class ValidSerialization {
	public boolean isValidSerialization(String preorder) {
		StringTokenizer st = new StringTokenizer(preorder, ",");
		return !st.hasMoreTokens() && isValid(st);
	}

	private boolean isValid(StringTokenizer st) {
		if (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.equals("#"))
				return true;
			else {
				boolean left = isValid(st);
				boolean right = isValid(st);
				return left && right;
			}
		} else
			return false;
	}

	public static void main(String[] arg) {
		String st = "9,3,4,#,#,1,#,#,2,#,6,#";
		System.out.println(new ValidSerialization().isValid(new StringTokenizer(st, ",")));
	}
}
