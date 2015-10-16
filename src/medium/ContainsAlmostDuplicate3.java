package medium;

import java.util.Arrays;
import java.util.Comparator;

public class ContainsAlmostDuplicate3 {
	// k index diff, t is num diff
public boolean containsNearbyAlmostDuplicate(int [] nums, int k , int t){
	if(nums.length==0 || nums.length==1){
		return false;
	}
	Pair1<Long,Integer> [] numsAsPairs = new Pair1[nums.length];
	for(int i=0;i<nums.length;i++){
		numsAsPairs[i] =  new Pair1<Long,Integer>((long) nums[i],i);
	}
	Arrays.sort(numsAsPairs);
	for(int i=0;i<numsAsPairs.length;i++){		
		for(int j=i+1;j<numsAsPairs.length && Math.abs((long)numsAsPairs[j].getX()-(long)numsAsPairs[i].getX()) <=t ;j++){
			if(Math.abs(numsAsPairs[i].getY()-numsAsPairs[j].getY()) <= k){
				return true;
			}
		}
	}
	return false;
	
}

public static void main(String[] arg){
	ContainsAlmostDuplicate3 dup = new ContainsAlmostDuplicate3();
	System.out.println(dup.containsNearbyAlmostDuplicate(new int[]{-1,2147483647},1,2147483647)); 
}
}

class Pair1<X extends Comparable<X>,Y extends Comparable<Y>> implements Comparable<Pair1<X,Y>> {
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
		Pair<X,Y> other = (Pair<X,Y>) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		return true;
	}

	X x;
	Y y;

	public Pair1(X x, Y y) {
		this.x = x;
		this.y = y;
	}

	public Pair1() {
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

	@Override
	public int compareTo(Pair1<X, Y> o) {
		return this.getX().compareTo(o.getX());
	}
}
