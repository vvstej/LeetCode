package medium;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int[][] minSumArray = new int[grid.length][grid[0].length];
        minSumArray[0][0] = grid[0][0];
        for(int j=1;j<grid[0].length;j++){
                minSumArray[0][j]=minSumArray[0][j-1]+grid[0][j];
            }
        for(int i=1;i<grid.length;i++){
                minSumArray[i][0]=minSumArray[i-1][0]+grid[i][0];
        }    
        
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[i].length;j++){
                int fromLeft = minSumArray[i][j-1]+grid[i][j];
                int fromTop = minSumArray[i-1][j]+grid[i][j];
                minSumArray[i][j] = Math.min(fromLeft,fromTop);
            }
        }
        return minSumArray[grid.length-1][grid[0].length-1];
    }
    public static void main(String[] arg){
    	MinPathSum min = new MinPathSum();
    	int [][] input = new int[][]{{1},{4},{7},{10}};
    	System.out.println(min.minPathSum(input));
    }
}
