package easy;
public class Queue<E> {

	GenericListNode<E> front = null;
	GenericListNode<E> rear = null;
	int size;
	
	public void insert(E data){
		GenericListNode<E> newNode = new GenericListNode<E>(data);
		if(front == null && rear == null){
			front = newNode;
			rear = newNode;
		}else{
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}
	
	public E peek(){
		if(rear !=null)
			return rear.data;
		return null;		
	}
	
	public E poll(){
		if(front==null){
			return null;
		}
		E data= front.data;
		front = front.next;
		if(front == null){
			rear = null;
		}
		size--;
		return data;		
	}
	
	public int size(){
		return this.size;
	}
	
}
