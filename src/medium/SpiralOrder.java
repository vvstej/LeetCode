package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
	public List<Integer> spiralOrder(int[][] matrix) {
		if(matrix.length==0){
			List<Integer> emptyList = new ArrayList<Integer>();
			return emptyList;
		}
		if(matrix.length==1){
			List<Integer> rowList = new ArrayList<Integer>();
			for(int i=0;i<matrix[0].length;i++){
				rowList.add(matrix[0][i]);
			}
			return rowList;
		}
		else if(matrix[0].length==1){
			List<Integer> colList = new ArrayList<Integer>();
			for(int i=0;i<matrix.length;i++){
				colList.add(matrix[i][0]);
			}
			return colList;
		}
        int leastDimension = (matrix.length<=matrix[0].length)?matrix.length:matrix[0].length;
        int counter = (leastDimension%2==0)? (leastDimension/2)-1: leastDimension/2;
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<=counter;i++){
           spiralPrint(matrix, i,(matrix.length-1-i),i,matrix[0].length-1-i,result);
        }
        return result;
    }
    
    public void spiralPrint(int[][] matrix, int startX, int endX, int startY, int endY,List<Integer> result){
    	if(startX==endX && startY==endY){
    		result.add(matrix[startX][startY]);
    		return;
    	}
    	else if(startX == endX && startY!=endY){
    		for(int j=startY;j<=endY;j++){
    			result.add(matrix[startX][j]);
    		}
    		return;
    	}
    	else if(startX != endX && startY == endY){
    		for(int j=startX;j<=endX;j++){
    			result.add(matrix[j][startY]);
    		}
    		return;
    	}
        for(int j=startY;j<endY;j++){
        	result.add(matrix[startX][j]);
        }
        for(int i=startX;i<endX;i++){
            result.add(matrix[i][endY]);
        }
        for(int j=endY;j>startY;j--){
            result.add(matrix[endX][j]);
        }
        for(int i=endX;i>startX;i--){
            result.add(matrix[i][startY]);
        }
    }
    
    public static void main(String[] arg){
    	List<Integer> result = new SpiralOrder().spiralOrder(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}});
    	for(int i : result){
    		System.out.println(i);
    	}
    }
}
