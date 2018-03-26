package hard;

public class MinCost2 {

    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0) return 0;
        int[][] minCost = new int[costs.length][costs[0].length];
        //int[] colors = new int[costs.length];
        int totalMin = Integer.MAX_VALUE;
        
        for(int i=0;i<costs[0].length;i++) {
            minCost[0][i] = costs[0][i];
        }
        
        for(int i=1; i<costs.length; i++) {
            for(int k=0;k < costs[0].length; k++) {
                int prevMin = Integer.MAX_VALUE;
                for(int j=0;j<costs[0].length; j++) {
                	if(j!=k) {
                		prevMin = Math.min(prevMin, minCost[i-1][j]);
                	}
                    //System.out.println(minCost[i-1][j]);
                }
                if(prevMin!=Integer.MAX_VALUE)
                    minCost[i][k] = prevMin + costs[i][k];
                System.out.println(minCost[i][k]);
            }
        }
        
        for(int k=0;k<costs[0].length;k++) {
            totalMin = Integer.min(totalMin, minCost[costs.length-1][k]);
        }
        
        return totalMin;
    }
    
    public static void main(String[] arg) {
    	new MinCost2().minCostII(new int[][]{{2,1,3},{1,3,2}});
    }
}
