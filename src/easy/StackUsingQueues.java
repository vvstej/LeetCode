package easy;

public class StackUsingQueues {
	Queue<Integer> queue1 = new Queue<Integer>();
	Queue<Integer> queue2 = new Queue<Integer>();
	GenericListNode<Integer> top;
	
	public void push(int x) {
		queue1.insert(x);
	}

	public int pop() {
		while(queue1.size>1){
			int data = queue1.poll();
			queue2.insert(data);
		}
		int data = queue1.poll();
		queue1= queue2;
		queue2 = new Queue<Integer>();
		return data;
	}

	public int top() {
		if(queue1.rear!=null)
			return queue1.rear.data;
		return -1;
	}

	public boolean empty() {
		if(queue1.front==null){
			return true;
		}
		return false;
	}
	
	public static void main(String [] arg){
		StackUsingQueues stack = new StackUsingQueues();
		stack.push(10);
		stack.push(20);
		System.out.println(stack.pop());
		stack.push(30);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.pop());
	}
}
