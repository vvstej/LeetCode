package ik;

public class KMP {

	public static void main(String[] arg) {
		String s = "ABC ABCDAB ABCDABCDABDE";
		String s1 = "AAAAAAAB";
		String p1 = "AAAAAAB";
		System.out.print(kmp(s1.toCharArray(), p1.toCharArray()));
	}

	private static boolean kmp(char[] text, char[] pattern) {
		int m = pattern.length;
		int n = text.length;
		int[] pmt = partialMatchTable(pattern);
		int i = 0;
		int j = 0;
		while (true) {
			// end of string
			if (j == n)
				break;
			if (pattern[i] == text[j]) {
				i++;
				j++;
				if (i == m)
					return true;
			} else if (i > 0) {
				// next best
				//j = j + ()
				i = pmt[i];
			} else {
				j++;
			}
		}
		return false;

	}

	private static int[] partialMatchTable(char[] pattern) {
		int[] pmt = new int[pattern.length+1];
		pmt[0] = 0;
		pmt[1] = 0;
		int j = 0;
		for (int i = 2; i <= pattern.length; i++) {
			j = pmt[i - 1];
			for (;;) {
				if (pattern[j] == pattern[i-1]) {
					pmt[i] = j+1;
					break;
				}
				if (j == 0) {
					pmt[i] = 0;
					break;
				} else {
					j = pmt[j];
				}
			}

		}
		return pmt;
	}
}
