package medium;

public class LongestIncreasingPath {

	public int longestIncreasingPath(int[][] matrix) {
		int[][] lipValues = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				lipValues[i][j] = -1;
			}
		}
		if (matrix.length == 0) {
			return 0;
		}
		int globalMax = 0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				int currGlobalMax = calculateVal(i, j, matrix, lipValues, 0);
				if(currGlobalMax> globalMax){
					globalMax = currGlobalMax;
				}
			}
		} 
		return globalMax;
	}

	private int calculateVal(int i, int j, int[][] matrix, int[][] lipValues, int globalMax) {
		int right = 1;
		int left = 1;
		int bottom = 1;
		int top = 1;
		if (i < matrix.length-1 && matrix[i][j] < matrix[i + 1][j]) {
			if (lipValues[i + 1][j] == -1) {
				calculateVal(i + 1, j, matrix, lipValues, globalMax);
			}
			bottom = 1 + lipValues[i + 1][j];
		}
		if (j < matrix[0].length-1 && matrix[i][j] < matrix[i][j + 1]) {
			if (lipValues[i][j + 1] == -1)
				calculateVal(i, j + 1, matrix, lipValues, globalMax);
			right = 1 + lipValues[i][j + 1];
		}
		if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
			if (lipValues[i - 1][j] == -1)
				calculateVal(i - 1, j, matrix, lipValues, globalMax);
			top = 1 + lipValues[i - 1][j];
		}
		if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
			if (lipValues[i][j - 1] == -1)
				calculateVal(i, j - 1, matrix, lipValues, globalMax);
			left = 1 + lipValues[i][j - 1];
		}
		int maxBR = Math.max(bottom, right);
		int maxTL = Math.max(top, left);
		lipValues[i][j] = Math.max(maxBR, maxTL);
		if (lipValues[i][j] > globalMax) {
			globalMax = lipValues[i][j];
		}
		return globalMax;
	}

	public static void main(String[] arg) {
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{{3,4,5}}));
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{{3},{36},{22}}));
		System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{{4}}));
	}
}
