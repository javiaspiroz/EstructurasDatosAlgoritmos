package week4;

/**
 * 
 * @author Javier Aspiroz de la Calle
 * @since February 2017
 * @version 1.0
 *
 */

public class DoubleList implements IList{
	DNode header;
	DNode trailer;
	int size;
	//Constructor
	public DoubleList(){
		header=new DNode(null);
		trailer=new DNode(null);
		header.next=trailer;
		trailer.next=header;
	}
	//Methods
	@Override
	public void addFirst(String newElem) {
		DNode newNode=new DNode(newElem);
		newNode.next=header.next;
		newNode.prev=header;
		header.next.prev=newNode;
		header.next=newNode;
		size++;
	}
	@Override
	public void addLast(String newElem) {
		DNode newNode=new DNode(newElem);
		newNode.next=trailer;
		newNode.prev=trailer.prev;
		header.prev.next=newNode;
		header.prev=newNode;
		size++;
	}
	@Override
	public void removeFirst() {
		if (isEmpty()){
			System.out.println("DList: List is empty");
		}
		header.next=header.next.next;
		header.next.prev=header;
		size--;
	}
	@Override
	public void removeLast() {
		if (isEmpty()){
			System.out.println("DList: List is empty");
		}
		trailer.prev=trailer.prev.prev;
		trailer.prev.next=trailer;
		size--;
	}
	@Override
	public void insertAt(int index, String newElem) {
		DNode newNode=new DNode(newElem);
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
	@Override
	public boolean isEmpty() {
		return (header.next==trailer);
	}
	@Override
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
	@Override
	public int getSize() {
		if (isEmpty()){
			System.out.println("DList: List is empty");
			return 0;
		}
		return size;
	}
	@Override
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
	@Override
	public String getFirst() {
		if (isEmpty()){
			System.out.println("DList: List is empty");
			return null;
		}
		return header.next.elem;
	}
	@Override
	public String getLast() {
		if (isEmpty()){
			System.out.println("DList: List is empty");
			return null;
		}
		return header.prev.elem;
	}
	@Override
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
	@Override
	public void removeAll(String elem) {
		for(DNode aux=header.next; aux.next!=trailer;aux=aux.next){
			header=null;
		}
	}
	@Override
	public void removeAt(int index) {
		int counter=1;
		for(DNode aux=header.next; aux.next!=trailer;aux=aux.next){
			if(counter==index){
				aux=null;
			}
			counter++;
		}
	}
	//Sorting method by Bubble Sort
	public void bubbleSort (){
		if (isEmpty()){
			System.out.println("DList is empty");
		}
		//As we are not said anything about how to sort it, I'll sort them by length
		DNode aux = new DNode("");
		for (DNode aux1=header; aux1.next!=trailer.prev;aux1=aux1.next){
			if (aux1.elem.length()>aux1.next.elem.length()){
				aux = aux1.next;
				aux1.next = aux1;
				aux1 = aux;
			}
		}
	}
}