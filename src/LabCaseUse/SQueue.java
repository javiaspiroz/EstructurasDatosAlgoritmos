package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public class SQueue implements IQueue {
	private SNode first;
	private SNode last;
	int size=0;
	@Override
	public boolean isEmpty(){
		return first==null;
	}
	@Override
	public void enqueue(String elem) {
		SNode node=new SNode (elem);
		if(isEmpty()){
			first=node;
		}
		else{
			last.next=node;
		}
		last=node;
		size++;
	}
	@Override
	public String dequeue() {
		if(isEmpty()){
			System.out.println("Queue is empty!");
			return null;
		}
		else{
			String firstElem=first.elem;
			first=first.next;
			if (first==null){
				last=null;
			}
			size--;
			return firstElem;
		}
	}
	@Override
	public Object front() {
		if (isEmpty()){			
			System.out.println("Queue is empty!");
			return null;
		}
		return first.elem;
	}
	@Override
	public int getSize() {
		return size;
	}
	public void sort() {
		if (isEmpty()) {
			System.out.println("Emtpy!!!");
			return;
		}			
		boolean foundChange = true;
		while(foundChange) {
			foundChange = false;
			for(SNode nodeIt=first; nodeIt!=last; nodeIt=nodeIt.next) {
				if (nodeIt.elem.compareTo(nodeIt.next.elem)>0) {
					foundChange=true;
					String aux=nodeIt.elem;
					nodeIt.elem=nodeIt.next.elem;
					nodeIt.next.elem=aux;
				}	
			}     
		}
	}
}