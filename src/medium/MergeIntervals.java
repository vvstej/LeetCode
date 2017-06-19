package medium;

import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	 public List<Interval> merge(List<Interval> intervals) {
		return intervals;
	        
	    }
}

class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval v1, Interval v2){
        return new Integer(v1.start).compareTo(new Integer(v2.start));
    }
}

class Interval {
	     int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }

