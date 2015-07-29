package easy;

public class VersionCompare {
	public int compareVersion(String version1, String version2) {
		String[] version1Array = version1.split("\\.");
		String[] version2Array = version2.split("\\.");
		int maxLength = (version1Array.length > version2Array.length) ? version1Array.length : version2Array.length;
		long [] version1NumberArray = new long[maxLength];
		long [] version2NumberArray = new long[maxLength];
		for(int i=0;i<maxLength;i++){
			if(i >= version1Array.length){
				version1NumberArray[i] = 0;
				
			}else{
				version1NumberArray[i] = Long.parseLong(version1Array[i]);
			}
			if(i >= version2Array.length){
				version2NumberArray[i] = 0;				
			}else{
				version2NumberArray[i] = Long.parseLong(version2Array[i]);
			}
		}
		for(int i=0;i<maxLength;i++){
			if(version1NumberArray[i] > version2NumberArray[i]){
				return 1;
			}else if(version1NumberArray[i] < version2NumberArray[i]){
				return -1;
			}else{
				continue;
			}
		}
		return 0;
	}

	public static void main(String[] arg) {
		System.out.println(new VersionCompare().compareVersion("1.1", "1"));
	}
}
