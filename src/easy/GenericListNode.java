package easy;

public class GenericListNode<E> {	
	E data;
	GenericListNode<E> next;
	
	GenericListNode(E data){
		this.data = data;
	}
}
