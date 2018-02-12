package ik;

import java.util.HashMap;
import java.util.Map;

public class CountTrees {
	/*
     * Complete the function below.
     */
    static int countTrees(int iNodeCount) {
        if(iNodeCount == 0) {
            return 0;
        }
        Map<Integer, Integer> memoMap = new HashMap<Integer,Integer>();
        memoMap.put(0,1);
        countTreesHelper(iNodeCount, memoMap);
        return memoMap.get(iNodeCount);
    }

    private static void countTreesHelper(int iNodeCount, Map<Integer,Integer> memoMap) {
        if(iNodeCount == 1) {
            memoMap.put(1,1);
            return;
        }
        if(memoMap.containsKey(iNodeCount)) {
            return;
        }
        int totalCount = 0;
        for(int begin=iNodeCount-1, end=0; begin>=end; begin--,end++) {
            if(!memoMap.containsKey(begin)) {
                countTreesHelper(begin,memoMap); 
            }
            if(!memoMap.containsKey(end)) {
                countTreesHelper(end,memoMap); 
            }
            int beginResult = memoMap.get(begin);
            int endResult = memoMap.get(end);
            int crossProduct = beginResult * endResult;
            totalCount+=(begin > end) ? (crossProduct *2) : crossProduct; 
        }
        memoMap.put(iNodeCount, totalCount);
        return;
    }
    public static void main(String[] arg){
    	CountTrees.countTrees(3);
    }
}
