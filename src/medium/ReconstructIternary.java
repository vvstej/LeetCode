package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ReconstructIternary {

	public List<String> findItinerary(final String[][] tickets) {
        final Map<String,TreeSet<String>> itineraryMap = new HashMap<String,TreeSet<String>>();
        for(int i=0;i<tickets.length;i++){
            final String from  = tickets[i][0];
            final String to = tickets[i][1];
            TreeSet<String> toSet = itineraryMap.get(from);
            if(toSet==null){
                toSet = new TreeSet<String>();
            }
            toSet.add(to);
            itineraryMap.put(from,toSet);
        }
        final List<String> itineraryList  = new ArrayList<String>();
        final Set<String> visitedSet = new HashSet<String>();
        itineraryList.add("JFK");
        traverse("JFK",itineraryMap,visitedSet,itineraryList);
        return itineraryList;
    }
    
    private boolean traverse(final String from, final Map<String,TreeSet<String>> iMap, final Set<String> vSet, final List<String> iList){
        final TreeSet<String> toSet = iMap.get(from);
        if(toSet==null || toSet.isEmpty()) {
        	if(iList.size()==iMap.size()) return true;
        	else return false;
        }
        for(final String to : toSet){
        	 iList.add(to);
             toSet.remove(to);
             final boolean result = traverse(to, iMap, vSet, iList);
             if(result){
            	 break;
             }else{
            	 iList.remove(to);
             }
        }
        return false;

    }
    
    public static void main(final String[] arg){
    	final String[][] tickets = new String[][]{{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
    	final ReconstructIternary it = new ReconstructIternary();
    	final List<String> result = it.findItinerary(tickets);
    	for(final String r: result){
    		System.out.print(r+" ");
    	}
    }
}
