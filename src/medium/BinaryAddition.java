package medium;

public class BinaryAddition {

	public String binaryAddition(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		int resultLen = sLen > tLen ? sLen : tLen;
		String smallerString = (sLen == resultLen) ? t : s;
		String biggerString = s.equals(smallerString) ? t : s;
		StringBuilder smallerStringBuilder = new StringBuilder();
		if (sLen == resultLen) {
			for (int i = 0; i < resultLen - tLen; i++) {
				smallerStringBuilder.append("0");
			}
		}
		smallerStringBuilder.append(smallerString);
		smallerString = smallerStringBuilder.toString();
		StringBuilder sb = new StringBuilder();
		int prevCarry = 0;
		for (int i = resultLen - 1; i >= 0; --i) {
			int carry = 0;
			int s1 = biggerString.charAt(i) == '0' ? 0 : 1;
			int t1 = smallerString.charAt(i) == '0' ? 0 : 1;
			int result = s1 ^ t1;
			if (s1 == 1 && t1 == 1) {
				carry = 1;
			}
			if (result == 1 && prevCarry == 1) {
				carry = 1;
			}
			result ^= prevCarry;
			sb.append(String.valueOf(result));
			prevCarry = carry;
		}
		if (prevCarry == 1) {
			sb.append("1");
		}
		return sb.reverse().toString();
	}

	public static void main(String[] arg) {
		System.out.println(new BinaryAddition().binaryAddition("111", "10"));
	}
}
