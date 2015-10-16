package medium;

public class MultiThreadedFibonacci extends Thread{

	public MultiThreadedFibonacci(int i) {
		this.input = i;
	}
	public static void main(String[] arg) throws InterruptedException{
		MultiThreadedFibonacci m = new MultiThreadedFibonacci(10);
		m.start();
		m.join();
		System.out.println(m.answer);
	}
	
	int answer;
	int input;
	
	@Override
	public void run(){
		if(input==1){
			this.answer = 0;
		}else if(input == 2){
			this.answer = 1;
		}else{
			MultiThreadedFibonacci left = new MultiThreadedFibonacci(input-1);
			MultiThreadedFibonacci right = new MultiThreadedFibonacci(input-2);
			left.start();
			right.start();
			try {
				left.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				right.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.answer = left.answer + right.answer;
		}
	}
}
