package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxPoint {
	private double getSlope(Point p1, Point p2) {
		if (p1.x == p2.x)
			return Double.MAX_VALUE;
		double slope = (double) (p2.y - p1.y) / (p2.x - p1.x);
		if (Math.abs(slope) == 0.0D)
			return 0.0D;
		return slope;
	}

	public int maxPoints(Point[] points) {
		Map<String, Map<Double, Integer>> map = new HashMap<String, Map<Double, Integer>>();
		int max = points.length == 0 ? 0 : 1;
		Arrays.sort(points, (p1, p2) -> {
			return p1.y - p2.y;
		});
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double slope = getSlope(points[i], points[j]);
				String key = points[i].x + "," + points[i].y;
				Map<Double, Integer> currPointMap = map.get(key);
				if (currPointMap == null)
					currPointMap = new HashMap<Double, Integer>();
				Integer currCount = currPointMap.get(slope);
				if (currCount == null)
					currCount = 1;
				currCount = currCount + 1;
				max = Math.max(max, currCount);
				currPointMap.put(slope, currCount);
				map.put(key, currPointMap);
			}
		}
		return max;
	}

	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static void main(String[] arg) {
		Point[] points = new Point[3];
		points[0] = new Point(1, 1);
		points[1] = new Point(1, 1);
		points[2] = new Point(1, 1);
		System.out.print(new MaxPoint().maxPoints(points));
	}
}
