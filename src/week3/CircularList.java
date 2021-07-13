package week3;

/**
 * 
 * @author Javier Aspiroz de la Calle
 * @since February 2017
 * @version 1.0
 *
 */

public class CircularList implements IList {
	public SNode first; 
	public SNode last;
	int size; //by default is 0
	public boolean isEmpty() {
		return (first == null);
	}
	@Override
	public int getSize() {
		return size;
	}		
	public void addFirst(String newElem) {
		SNode newNode = new SNode(newElem);
		newNode.next = first;
		//If list is empty, last has also to reference to newNode
		if (first==null) last=newNode;
		//we set the new first node
		first = newNode;
		size++;
	}
	public void removeFirst() {
		if (!isEmpty()) {
			first = first.next;
			if (first==null){
				last=null;
			}
			size--;
		}
	}
	public void addLast(String newElem) {
		SNode node = new SNode(newElem);
		if (isEmpty()){
			addFirst(newElem);
		}
		else {
			//We should remove the node from the previous one to the one we are creating now and disconnect it from the first.
			if (last.next==first){
				last.next=null;
			}
			last.next=first;//We modify it to assign the node to the next position the first element of the list.
			last=node;
			
			size++;
		}	
	}
	@Override
	public String getFirst() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		return first.elem;
	}
	@Override
	public String getLast() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		return last.elem;
	}
	@Override
	public String getAt(int index) {
		if (index<0 || index>=size) {
			System.out.println("SList: getAt index out of bounds");
			return null;
		}
		int i = 0;
		String result=null;
		for (SNode nodeIt = first; nodeIt != null && result==null; nodeIt = nodeIt.next) {
			if (i == index) {
				result= nodeIt.elem;
			}
			++i;
		}
		return result;
	}
	@Override
	public void insertAt(int index, String newElem) {
		if (index<0 || index>size) {
			System.out.println("SList: Insertion out of bounds");
		}
		SNode newNode = new SNode(newElem);
		if (index == 0) {
			addFirst(newElem);
		}
		else if (index==size) {
			addLast(newElem);
		} 
		else {
			int i = 1;
			boolean inserted=false;
			for (SNode nodeIt = first; nodeIt != null && inserted==false; nodeIt = nodeIt.next) {
				if (i == index) {
					newNode.next = nodeIt.next;
					nodeIt.next = newNode;
					inserted=true;
				}
				i=i+1;
			}
			size++;
		}
	}
	public void removeLast() {
		if (isEmpty()) {
			//List is empty
			return;
		}
		if (size==1) 
			removeFirst();
		else {
			SNode nodeIt=first;
			//stop in the previous node
			while (nodeIt.next!=last) {
				nodeIt=nodeIt.next;
			}
			//		for (SNode nodeIt=first;nodeIt.next!=last;nodeIt=nodeIt.next) {
			//			
			//		}
			last=nodeIt;
			last.next=first;//We modify it to assign the node to the next position, the first element of the list.
			size--;
		}
	}
	@Override
	public boolean contains(String elem) {
		boolean result=false;
		int ii=1;
		for (SNode nodeIt=first; nodeIt!=null && result==false && ii<=getSize(); nodeIt=nodeIt.next) {//We have to avoid infinite repetition

			if (nodeIt.elem.equals(elem)) {
				result=true;
			}
			ii++;
		}			
		return result;
	}
	@Override
	public void removeAt(int index) {
		if (index<0 || index>=size) {
			System.out.println("index out of range");
			return;
		}			
		if (index==0) removeFirst();			
		else if (index==size-1) removeLast();			
		else {
			int i=1;
			SNode nodeIt=first;
			while (nodeIt!=null & i<index) {
				i=i+1;
				nodeIt=nodeIt.next;
			}
			nodeIt.next=nodeIt.next.next;
			size--;
		}			
	}
	@Override
	public void removeAll(String elem) {			
		SNode prev=null;
		for (SNode nodeIt=first;nodeIt!=null;nodeIt=nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				if (prev==null) {
					removeFirst();
				} else {
					prev.next=nodeIt.next;
					size--;
				}
			} else {
				prev=nodeIt;
			}
		}			
	}		
	@Override
	public int getIndexOf(String elem) {
		int result=-1;
		int index=0, ii=1;
		for (SNode nodeIt=first; nodeIt!=null && result==-1 && ii<=getSize(); nodeIt=nodeIt.next) {	//We have to avoid infinite repetition			
			if (nodeIt.elem.equals(elem)) {
				result=index;
			}
			index++;
			ii++;
		}			
		return result;
	}
	public String toString() {
		String result = null;
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (result == null) {
				result = nodeIt.elem.toString();
			} else {
				result += "," + nodeIt.elem.toString();
			}
		}			
		//			if (result==null)
		//				result="empty";
		//			return result;
		return result == null ? "empty" : result;
	}
}