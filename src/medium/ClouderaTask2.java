package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClouderaTask2 {

	public int solution(int[] A, int[]B){
		if(A.length==0 || B.length==0){
			return 0;
		}
		if(A.length==1 || B.length==1){
			return 1;
		}
		List<Pair<Integer,Integer>> listOfPairs = new ArrayList<Pair<Integer,Integer>>();
		IntegerPairComparator integerComparator = new IntegerPairComparator();
		for(int i=0;i<A.length;i++){
			listOfPairs.add(new Pair<Integer,Integer>(A[i],B[i]));
		}
		Collections.sort(listOfPairs, integerComparator);
		Pair<Integer,Integer> pair1 = listOfPairs.get(0);
		int countDisjointPairs = 0;
		for(int i=1;i<listOfPairs.size();i++){
			Pair<Integer,Integer> pair2 = listOfPairs.get(i);
			if(pair2.getX() <= pair1.getY()){
				int lowerBound = Math.min(pair1.getX(), pair2.getX());
				int upperBound = Math.max(pair1.getY(), pair2.getY());
				Pair<Integer,Integer> newPair = new Pair<Integer,Integer>(lowerBound, upperBound);
				pair1 = newPair;
			}else{
				System.out.println(pair1.getX()+" "+pair1.getY());
				countDisjointPairs++;
				pair1 = pair2;
			}
			
		}
		System.out.println(pair1.getX()+" "+pair1.getY());
		//always last pair will be left from our count, so add it
		countDisjointPairs++;
		return countDisjointPairs;
	}
	
	public static void main(String[] arg){
		ClouderaTask2 task2 = new ClouderaTask2();
		int result = task2.solution(new int[]{1}, new int[]{100});
		System.out.println(result);
	}
	
}

class IntegerPairComparator implements Comparator<Pair<Integer,Integer>> {
	@Override
	public int compare(Pair<Integer,Integer> o1, Pair<Integer,Integer> o2) {
		return o1.getX().compareTo(o2.getX());
	}

}
