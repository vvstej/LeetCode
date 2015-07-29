package easy;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

	private static final int MAX_SIZE = 100;
	List<Integer> stackList = new ArrayList<Integer>(MAX_SIZE);
	int top =-1;
	List<Integer> minStackList = new ArrayList<Integer>(MAX_SIZE);
	private int currMin = Integer.MAX_VALUE;
	
	public void push(int x) {
		if(this.top== MAX_SIZE-1){
			//noop
			return;
		}
		
				
		if(x < currMin){
			top++;
			minStackList.add(top,x);
			currMin = x;
		}else{
			top++;
			minStackList.add(top,this.currMin);
		}
		stackList.add(top,x);
	}
	
	public void pop() {
		if(this.top==-1){
			// throw exception or noop
			return;
		}
		stackList.remove(top);
		minStackList.remove(top);
		top--;
		currMin = this.getMin();
	}
	
	public int top() {
		if(this.top == -1){
			//noop return
			return Integer.MAX_VALUE;
		}
		return stackList.get(top);
	}
	
	public int getMin() {
		if(this.top == -1){
			return Integer.MAX_VALUE;
		}
		return minStackList.get(top);
	}
	
	public static void main(String []arg){
		MinStack stack = new MinStack();
		try {
			stack.push(2147483646);
			stack.push(2147483646);
			stack.push(2147483647);
			System.out.println(stack.top());
			stack.pop();
			System.out.println(stack.getMin());
			stack.pop();
			System.out.println(stack.getMin());
			stack.pop();
			stack.push(2147483647);
			System.out.println(stack.top());
			System.out.println(stack.getMin());
			stack.push(-2147483648);
			System.out.println(stack.top());
			System.out.println(stack.getMin());
			stack.pop();
			System.out.println(stack.getMin());			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
