package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder1 {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ret = new ArrayList<>();
		int m = matrix.length;
		if (m == 0)
			return ret;
		int n = matrix[0].length;

		for (int i = 0, j = 0; i <= m / 2 && j <= n / 2; ++i, ++j) {
			int startX = i;
			int startY = j;
			int endX = m - startX - 1;
			int endY = n - startX - 1;
			for (int k = startY; k < endY; ++k) {
				ret.add(matrix[startX][k]);
			}
			for (int k = startX; k < endX; ++k) {
				ret.add(matrix[k][endY]);
			}
			for (int k = endY; k > startY; --k) {
				ret.add(matrix[endX][k]);
			}
			for (int k = endX; k > startX; --k) {
				ret.add(matrix[k][startY]);
			}
		}

		return ret;
	}
	
	public static void main(String[] arg){
		System.out.println(new SpiralOrder1().spiralOrder(new int[][]{{2,3}}));
		double val = (double)6/4;
		Double x = 0.0D;
		Double y = 0.0D;
		System.out.println(x.equals(y));
		System.out.print(val);
	}
}
