package easy;

public class ClosestBinarySearch {
    public int closestValue(TreeNode root, double target) {
        return search(root,target).val;
    }
    
    private static Result search(TreeNode root, double target){
        double diff = Math.abs(target-root.val);
        Result minDiffFromChildren = null;
        if(target < root.val){
            if(root.left!=null)
                minDiffFromChildren = search(root.left,target);
            else{
                minDiffFromChildren = new ClosestBinarySearch.Result(root.val,diff);
                return minDiffFromChildren;
            }
        }else if(target > root.val){
            if(root.right!=null){
                minDiffFromChildren = search(root.right,target);
            }else{
                minDiffFromChildren = new Result(root.val,diff);
                return minDiffFromChildren;
            }
            
        }
        Result minDiff = new Result();
        if(diff < minDiffFromChildren.diff){
            minDiff.setDiff(diff);
            minDiff.setVal(root.val);
            return minDiff;
        }
        else{
            return minDiffFromChildren;
        }
        
    }
    
    static class Result{
        public Result(int val2, double diff2) {
    		this.val = val2;
    		this.diff =diff2;
    	}
    	public Result() {
    		// TODO Auto-generated constructor stub
    	}
    	int val;
        public int getVal() {
    		return val;
    	}
    	public void setVal(int val) {
    		this.val = val;
    	}
    	public double getDiff() {
    		return diff;
    	}
    	public void setDiff(double diff) {
    		this.diff = diff;
    	}
    	double diff;
    }
    
    public static void main(String[] arg){
    	
    }
}


