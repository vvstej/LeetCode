package medium;

public class Search2DMatrix {
	 public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix.length==0){
	            return false;
	        }
	        for(int i=0,j=0;i<matrix[0].length && j<matrix.length;i++,j++){
	            boolean found = doBinarySearchColumnWise(target, matrix, i,j,matrix.length-1);
	            if(!found){
	            	found = doBinarySearchRowWise(target, matrix, i,j,matrix[0].length-1);
	            	if(found){
	            		return true;
	            	}
	            }else{
	            	return true;
	            }
	        }
	        return false;
	        
	    }

	private boolean doBinarySearchColumnWise(int target, int[][] matrix, int fixedColumn, int rowBegin,
			int rowEnd) {
		int[] newArray = new int[rowEnd+1-rowBegin];
		for(int i=0;i<newArray.length;i++){
			newArray[i] = matrix[rowBegin][fixedColumn];
			rowBegin++;
		}
		return binarySearch(target,newArray,0,newArray.length-1);
	}
	
	private boolean binarySearch(int target, int[] newArray, int start, int end) {
		if(start>end){
			return false;
		}
		if(start==end){
			if(newArray[start]==target){
				return true;
			}else{
				return false;
			}
		}else{
			int middle = (end+start)/2;
			if(target< newArray[middle]){
				return binarySearch(target, newArray, start, middle-1);
			}else if(target > newArray[middle]){
				return binarySearch(target, newArray, middle+1, end);
			}else{
				return true;
			}
		}		
	}

	private boolean doBinarySearchRowWise(int target, int[][] matrix, int columnBegin, int fixedRow, int columnEnd){
		int[] newArray = new int[columnEnd+1-columnBegin];
		for(int i=0;i<newArray.length;i++){
			newArray[i] = matrix[fixedRow][columnBegin];
			columnBegin++;
		}
		return binarySearch(target,newArray, 0,newArray.length-1);
		
	}
	
	public static void main(String[] arg){
		int input[][] = new int[][]{{1,6,10,13,14,16,21},{3,10,12,18,22,27,29},{3,15,19,20,23,29,34},{8,15,19,25,27,29,39},{12,17,24,25,28,29,41},{16,22,27,31,31,33,44},{20,26,28,35,39,41,45},{25,31,34,39,44,45,47}};
		System.out.println(new Search2DMatrix().searchMatrix(input, 38));
	}
}
