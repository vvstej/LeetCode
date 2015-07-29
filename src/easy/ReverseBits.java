package easy;

import java.math.BigInteger;

public class ReverseBits {

	public int reverseBits(int n) {
		String binaryString = Integer.toBinaryString(n);
		StringBuilder binaryString32Builder = new StringBuilder();
		for(int i=1;i<=32-binaryString.length();i++){
			binaryString32Builder.append("0");
		}
		binaryString = binaryString32Builder.append(binaryString).toString();
		int length = binaryString.length();
		char[] reverseString = binaryString.toCharArray();
		for (int i = 0; i < length / 2; i++) {
			char temp = reverseString[i];
			reverseString[i] = reverseString[length - i - 1];
			reverseString[length - i - 1] = temp;
		}
		long result = 0;
		for (int i = reverseString.length - 1; i >= 0; i--) {
			int valOfI = (int) reverseString[i] - 48;
			result += valOfI * Math.pow(2, length - i - 1);
		}
		int res = (int) (result & 0xffffffffL);		

		return res;
	}

	public static void main(String[] arg) {
		System.out.println(new ReverseBits().reverseBits(1));
	}
}
