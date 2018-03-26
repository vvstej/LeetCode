package hard;

public class MaxRectangle {
	public int maximalRectangle(char[][] mtx) {
		if (mtx.length == 0)
			return 0;
		Result[][] dp = new Result[mtx.length][mtx[0].length];
		int maxArea = 0;
		if (Character.getNumericValue(mtx[0][0]) == 1) {
			dp[0][0] = new Result(1, 1);
			maxArea = 1;
		} else {
			dp[0][0] = new Result(0, 0);
		}

		for (int i = 1; i < mtx.length; i++) {
			int curr = Character.getNumericValue(mtx[i][0]);
			if (curr == 1) {
				dp[i][0] = new Result(1, dp[i - 1][0].jMax + 1);
				maxArea = Math.max(maxArea, dp[i][0].jMax);
			} else {
				dp[i][0] = new Result(0, 0);
			}
		}
		for (int i = 1; i < mtx[0].length; i++) {
			int curr = Character.getNumericValue(mtx[0][i]);
			if (curr == 1) {
				dp[0][i] = new Result(dp[0][i - 1].iMax + 1, 1);
				maxArea = Math.max(maxArea, dp[0][i].iMax);
			} else {
				dp[0][i] = new Result(0, 0);
			}
		}

		for (int i = 1; i < mtx.length; i++) {
			for (int j = 1; j < mtx[0].length; j++) {
				int curr = Character.getNumericValue(mtx[i][j]);
				if (curr == 1) {
					dp[i][j] = new Result(dp[i][j - 1].iMax + 1, dp[i - 1][j].jMax + 1);
					int maxArea1 = Math.max(dp[i][j].iMax,
							Math.max(dp[i][j].jMax, dp[i][j - 1].jMax * dp[i - 1][j].iMax));
					maxArea = Math.max(maxArea1, maxArea);

				} else {
					dp[i][j] = new Result(0, 0);
				}
				System.out.print(dp[i][j].iMax + "," + dp[i][j].jMax + "   ");
			}
			System.out.println();
		}
		return maxArea;
	}

	static class Result {
		public int iMax;
		public int jMax;

		public Result(int maxI, int maxJ) {
			this.iMax = maxI;
			this.jMax = maxJ;
		}
	}

	public static void main(String[] arg) {
		new MaxRectangle().maximalRectangle(new char[][] { { '1', '0', '1', '0' }, { '1', '0', '1', '1' },
				{ '1', '0', '1', '1' }, { '1', '1', '1', '1' } });
	}

}
