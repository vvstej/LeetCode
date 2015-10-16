package medium;

public class Search2DMatrix1 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length==0){
			return false;
		}
        int colLength = matrix[0].length;
        int rowLength = matrix.length;
        int totalLength = colLength * rowLength;
        return binarySearch(matrix, target, 0, totalLength-1, colLength , rowLength);
    }
    
    public boolean binarySearch(int [][] matrix, int target, int startIndex, int endIndex, int colLength, int rowLength){
    	if(startIndex==endIndex){
    		int ithIndex = startIndex / colLength;
            int jthIndex = endIndex % colLength;
    		if(matrix[ithIndex][jthIndex]==target){
                return true;
            }else{
            	return false;
            }
    		
    	}
        int midPoint = (startIndex+endIndex) / 2;
        int ithIndex = midPoint / colLength;
        int jthIndex = midPoint % colLength;
        if(matrix[ithIndex][jthIndex]==target){
            return true;
        }
        if(matrix[ithIndex][jthIndex] > target){
        	if(midPoint==0){
        		return false;
        	}
            return binarySearch(matrix, target, startIndex, midPoint-1, colLength, rowLength);
        }else if(matrix[ithIndex][jthIndex] < target){
            return binarySearch(matrix, target, midPoint+1, endIndex, colLength, rowLength);
        }else{
        	return true;
        }
    }
    
    public static void main(String[] arg){
    	//int [][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    	int [][] matrix = new int[][]{{1,1},{3,3}};
    	System.out.println(new Search2DMatrix1().searchMatrix(matrix, 2));
    }
}
