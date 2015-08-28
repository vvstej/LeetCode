package medium;

public class JumpGame {

	public boolean canJump(int [] nums){
		if(nums.length==0) return false;
		if(nums.length==1) return true;
		int maxReach = 0;
		for(int i=0;i<nums.length;i++){
			if(i>maxReach){
				return false;
			}
			maxReach = (maxReach > (i+nums[i])) ? maxReach : (i+nums[i]);
		}
		return true;
		
	}
	
	public static void main(String[] arg){
		JumpGame game = new JumpGame();
		System.out.println(game.canJump(new int[]{2,3,1,1,4}));
		System.out.println(game.canJump(new int[]{3,2,1,0,4}));
		System.out.println(game.canJump(new int[]{0,2,1,0,4}));
		System.out.println(game.canJump(new int[]{4,0,0,0,4}));
	}
}
