package easy;

import java.util.Arrays;
import java.util.Comparator;

class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval v1, Interval v2){
        if(v1==v2){
            return 0;
        }
        if(v1==null && v2!=null){
            return -1;
        }
        else if(v1!=null && v2==null){
            return 1;
        }
        return v1.start-v2.start;
        
    }
}
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
    	if(intervals==null || intervals.length==0){
    		return false;
    	}
        Arrays.sort(intervals,new IntervalComparator());
        for(int i=1;i<intervals.length;i++){
            if(intervals[i-1].end > intervals[i].start){
                return false;
            }
        }
        return true;
    }
    
}

  class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
 
