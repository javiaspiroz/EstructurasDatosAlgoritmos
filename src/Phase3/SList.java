package Phase3;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public class SList {
	Main3 m = new Main3(); //To get the content of the file
	public Node first ,last; 
	int size = 0 ;
	String file = m.file;
	//Methods
	public boolean isEmpty() {
		return (first == null);
	}
	public boolean contains(String elem) {
		boolean result=false;
		for (Node nodeIt=first; nodeIt!=null && result==false; nodeIt=nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				result=true;
			}
		}
		return result;
	}
	// Adding method to a single linked list
	public void addToList(String newElem) {
		if (isEmpty()) {
			Node node = new Node(newElem);
			first = node;
			last = node ; 
			size++;
		}
		else {
			Node node = new Node(newElem);
			last.next=node;
			last=node;
			size++;
		}	
	}
	public String getAt(int index) {
		if (index<0 || index>=size) {
			System.out.println("SList: getAt index out of bounds");
			return null;
		}
		int i = 0;
		String result=null;
		for (Node nodeIt = first; nodeIt != null && result==null; nodeIt = nodeIt.next) {
			if (i == index) {
				result= nodeIt.elem;
			}
			++i;
		}
		return result;
	}
	// PRINT NODES IN LIST
	public void print(){
		last=first;
		while(last.next !=null){
			System.out.print(last.elem+ ", ");
			last = last.next;
		}
		System.out.println(last.elem);
	}
	public void removeAt(int index) {
		if (index<0 || index>=size) {
			System.out.println("index out of range");
			return;
		}
		if (index==0) removeFirst();
		else if (index==size-1) removeLast();
		else {
			int i=1;
			Node nodeIt=first;
			while (nodeIt!=null & i<index) {
				i=i+1;
				nodeIt=nodeIt.next;
			}
			nodeIt.next=nodeIt.next.next;
			size--;
		}
	}
	public void removeLast() {
		if (isEmpty()){
			return;
		}
		if (size==1) 
			removeFirst();
		else {
			Node nodeIt=first;
			while (nodeIt.next!=last) {
				nodeIt=nodeIt.next;
			}
			last=nodeIt;
			last.next=null;
			size--;
		}
	}
	public void removeFirst() {
		if (!isEmpty()) {
			first = first.next;
			if (first==null) last=null;
			size--;
		}
	}
	public int getIndexOf(Node elem) {
		int result=-1;
		int index=0;
		for (Node nodeIt=first; nodeIt!=null && result==-1; nodeIt=nodeIt.next) {
			if (nodeIt==elem) {
				result=index;
			}
			index++;
		}
		return result;
	}
	public void removeAll(){
		if(!isEmpty()){
			first.next=null;
			first = null;
			last=first;
			size = 0;
		}
	}
}