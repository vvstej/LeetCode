package medium;

public class NumberOfIslands {
	 public int numIslands(char[][] grid) {
	   if(grid==null || grid.length==0){
		   return 0;
	   }
	   int count=0;
	   for(int i=0;i<grid.length;i++){
		   for(int j=0;j<grid[0].length;j++){
			   if(grid[i][j]=='1'){
				   count++;
				   union(i,j,grid);
			   }
		   }
	   }
	   return count;
	   }

	private void union(int i, int j, char[][] grid) {
		//right
		if(j<grid[0].length-1 && grid[i][j+1]=='1'){
			grid[i][j+1] = 0;
			union(i,j+1,grid);
			//mark as visited since the main double loop shouldnt pick it again.
			
		}
		if(j>0 && grid[i][j-1]=='1'){
			grid[i][j-1] = 0;
			union(i,j-1,grid);
			//mark as visited since the main double loop shouldnt pick it again.
			
		}
		if(i<grid.length-1 && grid[i+1][j]=='1'){
			grid[i+1][j] = 0;
			union(i+1,j,grid);
			//mark as visited since the main double loop shouldnt pick it again.
			
		}
		if(i>0 && grid[i-1][j]=='1'){
			grid[i-1][j] = 0;
			union(i-1,j,grid);
			//mark as visited since the main double loop shouldnt pick it again.
			
		}		
	}
	
	public static void main(String[] arg){
		System.out.println(new NumberOfIslands().numIslands(new char[][]{{'1','1','1','1','0'},
																		 {'1','1','0','0','0'},
																		 {'0','0','1','0','0'},
																		 {'0','0','0','1','1'}
		                												}));
	}
}
