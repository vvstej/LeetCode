package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ListProblem1 {

	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    int begin = -1;
	    TreeSet<ArrayList<Integer>> result= new TreeSet<ArrayList<Integer>>(new ListComparator());
	    int end = -2;
	    for(int i=0;i<a.size();i++){
	        if(a.get(i)<0){
	            if(end<begin){
	                //do nothing since this is the first value and its negative
	                continue;
	            }
	            else if(end>=begin){
	                //end = i;
	            	ArrayList<Integer> subSet = new ArrayList<Integer>();
	            	for(int j=begin;j<=end;j++){
	            		subSet.add(a.get(j));
	            	}
//	                subSet.add(begin);
//	                subSet.add(end);
	                result.add(subSet);
	            }
	        }
	        if(a.get(i)>=0){
	            if(i==0){
	                begin = 0;
	                end = 0;
	            }
	            else if(i>0 && a.get(i-1) < 0){
	                begin = i;
	                end = i;
	            }else{
	                end++;
	            }
	            if(i==a.size()-1){
	            	ArrayList<Integer> subSet = new ArrayList<Integer>();
	            	for(int j=begin;j<=end;j++){
	            		subSet.add(a.get(j));
	            	}
	                result.add(subSet);
	            }
	            
	        }
	    }
	    return result.first();
//	    ArrayList<Integer> resultList = new ArrayList<Integer>();
//	    for(int i: result.first()){
//	        resultList.add(a.get(i));
//	    }
//	    return resultList;
	}
	
	public static void main(String[] arg){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(336465782);
		list.add(-278722862);
		list.add(-2145174067);
		list.add(1101513929);
		list.add(1315634022);
		list.add(-1369133069);
		list.add(1059961393);
		list.add(628175011);
		list.add(-1131176229);
		list.add(-859484421);
		new ListProblem1().maxset(list);
	}
}

class ListComparator implements Comparator<ArrayList<Integer>>{


	@Override
	public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
		// TODO Auto-generated method stub
		long sum2 = 0;
		long sum1 = 0;
		for(int i: o2){
			sum2+=i;
		}
		for(int i:o1){
			sum1+=i;
		}
		if(new Long(sum2).compareTo(sum1) > 0){
			return 1;
		}else if(new Long(sum2).compareTo(sum1) < 0){
			return -1;
		}else{
			if(o2.size()>o1.size()){
				return 1;
			}else if(o2.size()<o1.size()){
				return -1;
			}else{
				return new Integer(o1.get(0)).compareTo(new Integer(o2.get(0)));
			}
		}
	}
	
}
