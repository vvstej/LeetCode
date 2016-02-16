package hard;

public class RegexMatchingDP {

	public boolean isMatch(String s, String p) {
		int index = -1;
		int fromIndex = 0;
		char[] inputArray = s.toCharArray();

		int noOfMultiChars = 0;
		while ((index = p.indexOf("*", fromIndex)) != -1) {
			noOfMultiChars++;
			fromIndex = index + 1;
		}
		String[] patternArray = new String[p.length() - noOfMultiChars];
		index = 0;
		for (int i = 0; i < p.length(); i++) {
			if (i < p.length() - 1 && p.charAt(i + 1) == '*') {
				patternArray[index++] = p.substring(i, i + 2);
				i++;
			} else {
				patternArray[index++] = p.substring(i, i + 1);
			}
		}
		boolean[][] dpArray = new boolean[patternArray.length + 1][inputArray.length + 1];

		dpArray[0][0] = true;
		for (int j = 1; j <= patternArray.length; j++) {
			dpArray[j][0] = (patternArray[j - 1].contains("*") && dpArray[j - 1][0]) ? true : false;
		}
		for (int j = 1; j <= inputArray.length; j++) {
			dpArray[0][j] = false;
		}
		for (int i = 0; i < patternArray.length; i++) {
			for (int j = 0; j < inputArray.length; j++) {
				if (patternArray[i].contains("*")) {
					if (patternArray[i].substring(0, 1).charAt(0) == '.') {
						if (dpArray[i + 1][j] || dpArray[i][j] || dpArray[i][j + 1]) {
							dpArray[i + 1][j + 1] = true;
						} else {
							dpArray[i + 1][j + 1] = false;
						}
					} else if (patternArray[i].substring(0, 1).charAt(0) == inputArray[j]) {
						if (dpArray[i + 1][j] || dpArray[i][j] || dpArray[i][j + 1]) {
							dpArray[i + 1][j + 1] = true;
						} else {
							dpArray[i + 1][j + 1] = false;
						}
					} else {
						if (dpArray[i][j + 1]) {
							dpArray[i + 1][j + 1] = true;
						} else {
							dpArray[i + 1][j + 1] = false;
						}
					}
				} else {
					if (patternArray[i].charAt(0) == '.') {
						dpArray[i + 1][j + 1] = dpArray[i][j];
					} else {
						dpArray[i + 1][j + 1] = dpArray[i][j] && (patternArray[i].charAt(0) == inputArray[j]);
					}

				}
			}
		}
		return dpArray[patternArray.length][inputArray.length];
	}

	public static void main(String[] arg) {
		System.out.println(new RegexMatchingDP().isMatch("afaf", "af.*af")); //aaaaaaaaaaaaaaaba abc*a
	}

}
