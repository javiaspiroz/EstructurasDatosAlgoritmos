package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public class Phase2 {
	SQueue q=new SQueue();
	SQueue q2=new SQueue();
	BSTree tree=new BSTree();
	DList d2=new DList();

	//Method used to split the text
	public String [] split (String text){
		text=text.toLowerCase();
		String res[];
		String fin[];
		res=text.split(" ");
		String rubbish = "";
		if (res[0].compareTo(rubbish)==0){
			fin = new String [res.length-1];
			System.arraycopy(res, 1, fin, 0, res.length-1);
			return fin;
		}
		else
			return res;
	}
	//Create queue method
	public SQueue createQueue(String [] text){
		for(int ii=0; ii<text.length; ii++){
			q.enqueue(text[ii]);
		}
		return q;
	}
	public SQueue createQueue2(String [] text){
		for(int ii=0; ii<text.length; ii++){
			q2.enqueue(text[ii]);
		}
		return q2;
	}
	//Create first add method
	public void add(SQueue q){
		while(!q.isEmpty()){
			BSTNode node = new BSTNode(q.dequeue());
			add(node);
		}
	}
	public void add (BSTNode node){
		if (tree.root==null){
			tree.root=node;
			tree.root.freq=0;
			System.out.println("succes!!");
		}
		BSTNode auxnode=tree.root;
		BSTNode parent;
		while(true){
			parent=auxnode;
			//word smaller
			if(auxnode.elem.compareToIgnoreCase(node.elem)>0){
				auxnode=auxnode.left;
				if(auxnode==null){
					parent.left=node;
					System.out.println(node.elem+" left child of "+parent.elem);	
					return;
				}
			}
			//word bigger
			else if (auxnode.elem.compareToIgnoreCase(node.elem)<0){
				auxnode=auxnode.right;
				if(auxnode==null){
					parent.right=node;
					System.out.println(node.elem+" rigth child of "+parent.elem);
					return;
				}
			}
			//if equal, increase freq
			else if(auxnode.elem.compareToIgnoreCase(node.elem)==0){
				System.out.println(node.elem+" had its frequency increased.");
				auxnode.freq++;
				return;
			}
		}						
	}
	public void show (char mander){
		BSTNode node=tree.root;
		if (mander=='A'){
			node.getInorder(node);
		}
		else{
			//Method created to go from right to left
			node.getViceOrder(node);
		}
	}
	public String search (String word){
		String text="";
		BSTNode node=tree.root;
		boolean found=false;
		while(node!=null){
			if (word.equals(node.elem)){
				text="Word: "+node.elem+", Frequency: "+node.freq;
				node=null;
				found=true;
			}
			else if(word.compareTo(node.elem)<0){
				node=node.left;
			}
			else{
				node=node.right;
			}
		}
		if(node==null && found==false){
			System.out.println(word+" doesn't exists in the tree.");
		}
		return text;
	}

	public void add2(SQueue q){
		while(!q2.isEmpty())	{
			add2(q2.dequeue());
		}
	}
	public void add2(String word){
		if(d2.contains(word)){
			int index=0;				
			for (DNode nodeIt = d2.header.next; nodeIt != d2.trailer && index<=d2.getIndexOf(word); nodeIt = nodeIt.next) {
				if(index==d2.getIndexOf(word)){
					nodeIt.freq++;
				}
				index++;
			}				
		}
		else{
			d2.addFirst(word);
			d2.header.freq=1;
			d2.sort();
		}
	}
	//As we are not said to use a list, we will reuse the methods from the Phase1
	public void freqSort(DList d2){	
		boolean foundChange = true;
		while(foundChange) {
			foundChange = false;
			for (DNode nodeIt = d2.header.next; nodeIt != d2.trailer; nodeIt = nodeIt.next) {
				if (nodeIt.freq<nodeIt.next.freq) {//Previously the sign was incorrect, that's why it didn't work
					//Make sure we change both, not just the frequency or the element.
					foundChange=true;
					int aux=nodeIt.freq;
					String aux2=nodeIt.elem;
					nodeIt.freq=nodeIt.next.freq;
					nodeIt.elem=nodeIt.next.elem;
					nodeIt.next.freq=aux;	
					nodeIt.next.elem=aux2;
				}
			}
		}
	}
	public String getTop(int n){
		String text="";
		freqSort(d2);
		int index=0;
		boolean foundChange = true;
		while(foundChange) {
			foundChange = false;
			for (DNode nodeIt = d2.header.next; nodeIt != d2.trailer.prev; nodeIt = nodeIt.next) {
				if (nodeIt.freq==nodeIt.next.freq){
					if (nodeIt.elem.compareToIgnoreCase(nodeIt.next.elem)>0){
						//Make sure we change both, not just the frequency or the element.
						//It doesn't matters here, because both freq should be the same.
						foundChange=true;
						String aux=nodeIt.elem;
						int aux2=nodeIt.freq;
						nodeIt.elem=nodeIt.next.elem;
						nodeIt.freq=nodeIt.next.freq;
						nodeIt.next.elem=aux;	
						nodeIt.next.freq=aux2;
					}
				}
			}
		}
		for (DNode nodeIt = d2.header.next; nodeIt != d2.trailer && index<n; nodeIt = nodeIt.next) {
			index++;
			text=text+" Word: "+nodeIt.elem+" Frequency: "+nodeIt.freq+'\n';
		}
		return text;
	}
	public String getLow(int n){
		String text="";
		freqSort(d2);
		int index=0;
		boolean foundChange = true;
		while(foundChange) {
			foundChange = false;
			for (DNode nodeIt = d2.header.next; nodeIt != d2.trailer.prev; nodeIt = nodeIt.next) {
				if (nodeIt.freq==nodeIt.next.freq){
					if (nodeIt.next.elem.compareToIgnoreCase(nodeIt.elem)>0){//We change it because of the way we print it
						//Make sure we change both, not just the frequency or the element.
						//It doesn't matters here, because both freq should be the same.
						foundChange=true;
						String aux=nodeIt.elem;
						int aux2=nodeIt.freq;
						nodeIt.elem=nodeIt.next.elem;
						nodeIt.freq=nodeIt.next.freq;
						nodeIt.next.elem=aux;	
						nodeIt.next.freq=aux2;
					}
				}
			}
		}
		for (DNode nodeIt = d2.trailer.prev; nodeIt != d2.header && index<n; nodeIt = nodeIt.prev) {
			index++;
			text=text+" Word: "+nodeIt.elem+" Frequency: "+nodeIt.freq+'\n';
		}
		return text;
	}		
	//Methods from part e)
	public void save (Phase1 p1){
		for (DNode nodeIt = p1.d2.header.next; nodeIt != p1.d2.trailer; nodeIt = nodeIt.next) {
			//What happens if the freq is repeated?? We don't insert a lot of words!!
			tree.insert(nodeIt.freq, nodeIt.elem);
		}
	}
	public void add (String word, int freq){
		tree.insert(freq, word);
	}
}