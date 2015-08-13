package medium;

import java.util.TreeSet;

public class MaximumSquareDP {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		int maxLength = rowLength > colLength ? rowLength : colLength;
		TreeSet<Integer> maxSquareDimensions = new TreeSet<Integer>();
		boolean[][][] maxSquarePresenceArray = new boolean[rowLength][colLength][maxLength + 2];
		

		for (int i = 0; i <= rowLength - 1; i++) {
			for (int j = 0; j <= colLength - 1; j++) {
				maxSquarePresenceArray[i][j][1] = (matrix[i][j] == '1');
				if(maxSquarePresenceArray[i][j][1]){
					maxSquareDimensions.add(1);
				}
				
			}
		}
		
		for (int i = 0; i < rowLength - 1; i++) {
			for (int j = 0; j < colLength - 1; j++) {

					maxSquarePresenceArray[i][j][2] = (matrix[i][j] == '1'
							&& matrix[i][j + 1] == '1' && matrix[i + 1][j] == '1' && matrix[i + 1][j + 1] == '1');
					if (maxSquarePresenceArray[i][j][2]) {
						maxSquareDimensions.add(2);
					}
				
			}
		}

		for (int k = 3; k <= maxLength; k++) {
			for (int i = 0; i <= rowLength - k; i++) {
				for (int j = 0; j <= colLength - k; j++) {
					maxSquarePresenceArray[i][j][k] = (maxSquarePresenceArray[i][j][k - 1]
							&& maxSquarePresenceArray[i][j + 1][k - 1]
							&& maxSquarePresenceArray[i + 1][j][k - 1] && maxSquarePresenceArray[i + 1][j + 1][k - 1]);
					if (maxSquarePresenceArray[i][j][k]) {
						maxSquareDimensions.add(k);
					}
				}
			}
		}

		if (maxSquareDimensions.isEmpty()) {
			return 0;
		} else {
			Integer highestDimesion = maxSquareDimensions.last();
			return highestDimesion > 0 ? (highestDimesion * highestDimesion)
					: 0;
		}

	}

	public static void main(String[] arg) {
		char[][] nums = new char[][] { {'1','1'} };
		System.out.println(new MaximumSquareDP().maximalSquare(nums));
	}
}
