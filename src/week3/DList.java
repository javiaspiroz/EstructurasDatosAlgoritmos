package week3;

/**
 * A double-linked list class with sentinel nodes
 */

public class DList implements IList {
	DNode header; //by default is null
	DNode trailer;//by default is null
	int size; //by default is 0
	public DList() {
		//we have to create the sentinel nodes
		header = new DNode(null);
		trailer = new DNode(null);
		//they have to point with each other
		header.next = trailer;
		trailer.prev= header;
	}	
	public void addFirst(String elem) {
		DNode newNode = new DNode(elem);
		newNode.next = header.next;
		newNode.prev= header;
		header.next.prev= newNode;
		header.next = newNode;
		size++;
	}	
	public void addLast(String elem) {
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev= trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev= newNode;
		size++;
	}
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.next = header.next.next;
		header.next.prev= header;
		size--;
	}	
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.prev= trailer.prev.prev;
		trailer.prev.next = trailer;
		size--;
	}	
	public void insertAt(int index, String elem) {
		DNode newNode=new DNode(elem);
		int i=0;
		boolean inserted=false;
		for(DNode nodeIt=header;nodeIt!=trailer && inserted==false;nodeIt=nodeIt.next){
			if(i==index){
				newNode.next=nodeIt.next;
				newNode.prev=nodeIt;
				nodeIt.next.prev=newNode;
				nodeIt.next=newNode;
				inserted=true;
			}
			++i;
		}
		if(!inserted)System.out.println("DList: Insertionout of bounds");
		else size++;
	}	
	public boolean isEmpty() {
		/*if (header==null){
			return true;
		}
		return false;*/
		return (header.next==trailer);
	}	
	public boolean contains(String elem) {
		boolean res=false;
		if (isEmpty()){
			System.out.println("DList is empty");
		}
		else{
			for(DNode aux=header.next; aux.next!=trailer;aux=aux.next){
				if(aux.elem.equals(elem)){
					res=true;
				}
			}
		}
		return res;
	}	
	public int getIndexOf(String elem) {
		int res=-1;
		if (isEmpty()){
			System.out.println("DList is empty");			
		}
		else{
			int counter=1;
			for(DNode aux=header.next; aux.next!=trailer;aux=aux.next){
				if(aux.elem.equals(elem)){
					res=counter;
				}
				counter++;
			}
		}
		return res;
	}	
	public void removeAll(String elem) {
		for(DNode aux=header.next; aux.next!=trailer;aux=aux.next){
			header=null;
		}
	}	
	public void removeAt(int index) {
		int counter=1;
		for(DNode aux=header.next; aux.next!=trailer;aux=aux.next){
			if(counter==index){
				aux=null;
			}
			counter++;
		}
	}	
	public int getSize() {
		return size;
	}	
	public String getFirst() {
		if (isEmpty()){
			System.out.println("DList is empty");
		}
		return header.elem;
	}
	public String getLast() {
		if (isEmpty()){
			System.out.println("DList is empty");
		}
		return trailer.elem;
	}	
	public String getAt(int index) {
		String res="";
		if (isEmpty()){
			System.out.println("DList is empty");
		}
		int counter=1;
		for(DNode aux=header.next; aux.next!=trailer;aux=aux.next){
			if(counter==index){
				aux.elem=res;
			}
			counter++;
		}
		return res;
	}
	public String toString() {
		String result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			if (result == null) {
				result = nodeIt.elem;
			} else {
				result += "," + nodeIt.elem;
			}
		}
		return result == null ? "empty" : result;
	}	
	public void sort() {
		if (isEmpty()){
			System.out.println("DList is empty");
		}
		//Copy code from programming course
		
	}
	//Main Method
	public static void main(String[] args) {
		// incomplete test
		DList list = new DList();
		System.out.println(list.toString());
		System.out.println("isEmpty?" + list.isEmpty());
		list.addLast("Ana");
		System.out.println(list.toString());
		list.removeLast();
		System.out.println(list.toString());
		list.addLast("Isabel");
		System.out.println(list.toString());
		list.removeFirst();
		System.out.println(list.toString());
		list.addLast("Maria");
		System.out.println(list.toString());
		list.addLast("Ana");
		System.out.println(list.toString());
		list.addFirst("Pilar");
		System.out.println(list.toString());	
	}
}