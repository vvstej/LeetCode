package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClouderaTask1 {

	public int solution(int[] A){
		if(A.length==0 || A.length==1){
			return -2;
		}
		if(A.length==2){
			long distance = Math.abs((long)A[0]- (long)A[1]);
			if(distance > 100000000){
				return -1;
			}else{
				return (int)distance;
			}
		}
		LongPairComparator comparator = new LongPairComparator();
		List<Pair1<Long,Integer>> listOfPairs = new ArrayList<Pair1<Long,Integer>>();
		for(int i=0;i<A.length;i++){
			listOfPairs.add(new Pair1<Long,Integer>((long)A[i],i));
		}
		Collections.sort(listOfPairs, comparator);
		long minDistance = Long.MAX_VALUE;
		for(int i=1;i<listOfPairs.size();i++){			
			long pairDistance = Math.abs(A[listOfPairs.get(i-1).getY()]-A[listOfPairs.get(i).getY()]);
			if(pairDistance < minDistance){
				minDistance = pairDistance;
			}
		}
		if(minDistance > 100000000){
			return -1;
		}
		return (int)minDistance;
	}
	
	public static void main(String[] arg){
		ClouderaTask1 task1 = new ClouderaTask1();
		int solution = task1.solution(new int[]{50000000,300000000,150000001});
			System.out.println(solution);
	}
}

class LongPairComparator implements Comparator<Pair1<Long,Integer>> {
	@Override
	public int compare(Pair1<Long,Integer> o1, Pair1<Long,Integer> o2) {
		return o1.getX().compareTo(o2.getX());
	}

}

class Pair<X,Y> {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair1 other = (Pair1) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		return true;
	}

	X x;
	Y y;

	public Pair(X x, Y y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
	}

	public X getX() {
		return this.x;
	}

	public void setX(X x) {
		this.x = x;
	}

	public Y getY() {
		return this.y;
	}

	public void setY(Y y) {
		this.y = y;
	}
}