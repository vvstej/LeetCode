package easy;

import java.util.*;

public class GroupShiftedStrings {

	public List<List<String>> groupStrings(String[] strings) {
		if (strings.length == 0) {
			List<List<String>> results = new ArrayList<List<String>>();
			return results;
		}
		Arrays.sort(strings);
		Arrays.sort(strings, new StringLengthComparator());
		Map<String,List<String>> lengthMap = new HashMap<String,List<String>>();
		String prev = strings[0];
		List<List<String>> results = new ArrayList<List<String>>();
		List<String> prevShiftingSequence = new ArrayList<String>();
		prevShiftingSequence.add(prev);
		results.add(prevShiftingSequence);
		for (int i = 1; i < strings.length; i++) {
			if (prev.length() == strings[i].length()) {
				boolean isSameSequence = isSameShiftingSequence(prev,
						strings[i]);
				if (isSameSequence) {
					prevShiftingSequence.add(strings[i]);
					prev = strings[i];
					continue;
				}
			}
			prevShiftingSequence = new ArrayList<String>();
			prevShiftingSequence.add(strings[i]);
			results.add(prevShiftingSequence);
			prev = strings[i];
		}
		return results;
	}

	boolean isSameShiftingSequence(String prev, String curr) {
		char prevFirstChar = prev.charAt(0);
		char currFirstChar = curr.charAt(0);
		int shiftNo = currFirstChar - prevFirstChar;
		if (shiftNo < 0) {
			shiftNo = 26 - Math.abs(shiftNo);
		}
		for (int i = 0; i < prev.length(); i++) {
			int currShiftNo = curr.charAt(i) - prev.charAt(i);
			if (currShiftNo < 0) {
				currShiftNo = 26 - Math.abs(currShiftNo);
			}
			if (currShiftNo != shiftNo) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] arg) {
		List<List<String>> results = new GroupShiftedStrings()
				.groupStrings(new String[] { "fpbnsbrkbcyzdmmmoisaa",
						"cpjtwqcdwbldwwrryuclcngw", "a", "fnuqwejouqzrif",
						"js", "qcpr", "zghmdiaqmfelr", "iedda", "l",
						"dgwlvcyubde", "lpt", "qzq", "zkddvitlk",
						"xbogegswmad", "mkndeyrh", "llofdjckor", "lebzshcb",
						"firomjjlidqpsdeqyn", "dclpiqbypjpfafukqmjnjg",
						"lbpabjpcmkyivbtgdwhzlxa", "wmalmuanxvjtgmerohskwil",
						"yxgkdlwtkekavapflheieb", "oraxvssurmzybmnzhw",
						"ohecvkfe", "kknecibjnq", "wuxnoibr", "gkxpnpbfvjm",
						"lwpphufxw", "sbs", "txb", "ilbqahdzgij", "i", "zvuur",
						"yfglchzpledkq", "eqdf", "nw", "aiplrzejplumda", "d",
						"huoybvhibgqibbwwdzhqhslb", "rbnzendwnoklpyyyauemm" });
		for (List<String> result : results) {
			for (String str : result) {
				System.out.print(str + ",");
			}
			System.out.println();
		}
	}
}

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		Integer len1 = o1.length();
		Integer len2 = o2.length();
		return len1.compareTo(len2);
	}

}
