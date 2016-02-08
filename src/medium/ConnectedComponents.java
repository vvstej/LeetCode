package medium;

public class ConnectedComponents {

	public int countComponents(int n, int[][] edges) {
        int[] unionFindArray = new int[n];
        for(int i=0;i<n;i++){
            unionFindArray[i] = -1;
        }
        for(int i=0;i<edges.length;i++){
        		unionFindArray[edges[i][1]]= edges[i][0];
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(unionFindArray[i]==-1){
                count++;
            }
        }
        return count;
    }
	
	public static void main(String[] arg){
		new ConnectedComponents().countComponents(5, new int[][]{{0,1},{1,2},{3,4}});
	}
}
