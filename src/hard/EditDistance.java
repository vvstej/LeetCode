package hard;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		int[][] minDistanceArray = new int[word1.length()+1][word2.length()+1];
//		minDistanceArray[0][0] = (word1.charAt(0)==word2.charAt(0)) ? 0 : 1;
		for(int i=0;i<=word1.length();i++){
			minDistanceArray[i][0] = i;
		}
		for(int i=0;i<=word2.length();i++){
			minDistanceArray[0][i] = i;
		}
		for(int i=1;i<=word1.length();i++){
			for(int j=1;j<=word2.length();j++){
				int interMin = Math.min(minDistanceArray[i-1][j]+1, minDistanceArray[i][j-1]+1);
				int min = Math.min(interMin, minDistanceArray[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1));
				minDistanceArray[i][j] = min;
			}
		}
		return minDistanceArray[word1.length()][word2.length()];
	}
	public static void main(String[] arg){
		System.out.println(new EditDistance().minDistance("", "b"));
	}
}
