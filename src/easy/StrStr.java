package easy;

public class StrStr {
	public int strStr(String haystack, String needle) {
		if (needle == null || haystack == null) {
			return -1;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		} else if (!haystack.contains(needle)) {
			return -1;
		}
		return haystack.indexOf(needle);
	}

	public static void main(String[] arg) {
		System.out.println(new StrStr().strStr(
				"alsdjflalsdireiowtuincnxm,nskafjdkajfruifjdslkfd", "nm"));
	}
}
