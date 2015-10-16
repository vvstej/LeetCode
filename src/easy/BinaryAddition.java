package easy;

public class BinaryAddition {

	public String addBinary(String a, String b){
		if(a==null || a.length()==0){
			if(b==null || b.length()==0){
				return "";
			}
			return b;
		}
		if(b==null || b.length()==0){
			if(a==null || a.length()==0){
				return "";
			}
			return a;
		}
		long aAsLong = Long.parseUnsignedLong(a,2);
		long bAsLong = Long.parseUnsignedLong(b,2);
		String result = Long.toUnsignedString(aAsLong+bAsLong, 2);
		return result;
	}
	public static void main(String[] arg){
		System.out.println(new BinaryAddition().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "1"));
		//"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
	}
}
