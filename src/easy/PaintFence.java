package easy;

import java.util.HashMap;
import java.util.Map;

public class PaintFence {
	Map<Integer,Integer> fibMap = new HashMap<Integer,Integer>();

	public int numWays(int n, int k) {
        if(n==0 || k==0){
            return 0;
        }
        if(k==1 && n>=3){
            return 0;
        }
        else if(k==1 && n<3){
            return 1;
        }
        int[] numberOfWays = new int[n+1];
        numberOfWays[1] = k;
        int counter = 1;
        for(int i=2;i<=n;i++){
            if(i>=3){
            	int nthFib = nthFib(counter++);
                numberOfWays[i] = (numberOfWays[i-1] * k)-(nthFib * k);
            }else{
                numberOfWays[i] = numberOfWays[i-1] * k;
            }
        }
        return numberOfWays[n];
    }
	
	public int nthFib(int num){
		if(num==1 || num==2){
			fibMap.put(num, 1);
			return 1;
		}
		if(fibMap.containsKey(num)){
			return fibMap.get(num);
		}
		else{
			Integer left = fibMap.get(num-1);
			if(left==null){
				left = nthFib(num-1);
			}
			fibMap.put(num-1, left);
			Integer right = fibMap.get(num-2);
			if(right==null){
				right = nthFib(num-1);
			}
			fibMap.put(num-2, right);
			int val = left + right;
			fibMap.put(num, val);
			return val;
		}
	}
	
	public static void main(String[] arg){
		System.out.println(new PaintFence().numWays(4, 3));
	}
}
