package easy;

public class GenericListNode<E> {	
	E data;
	GenericListNode<E> next = null;
	
	GenericListNode(E data){
		this.data = data;
	}
}
