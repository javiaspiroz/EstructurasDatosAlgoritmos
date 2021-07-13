package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0 
 * 
 */

public class Phase1 {
	//We create an Object of SQueue type
	SQueue q=new SQueue();
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
	//Create first add method
	public void add(SQueue q){
		while(!q.isEmpty())	{
			add(q.dequeue());
		}
	}
	public void add(String word){
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
	public String show(char mander){
		String text="";
		if (mander=='A'){
			for (DNode nodeIt = d2.header.next; nodeIt != d2.trailer; nodeIt = nodeIt.next) {
				text=text+" Word: "+nodeIt.elem+" Frequency: "+nodeIt.freq+'\n';
			}
		}
		else{
			for (DNode nodeIt = d2.trailer.prev; nodeIt != d2.header; nodeIt = nodeIt.prev) {
				text=text+" Word: "+nodeIt.elem+" Frequency: "+nodeIt.freq+'\n';
			}
		}
		return text;
	}
	public String search (String text){
		int num=0;
		int index=0;
		for (DNode nodeIt = d2.header.next; nodeIt != d2.trailer && index<=d2.getIndexOf(text); nodeIt = nodeIt.next) {
			if(index==d2.getIndexOf(text)){
				num=nodeIt.freq;
			}
			index++;
		}
		return "The word "+text+" appears "+num+" times";
	}
	//Method to order the frequencies
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
	//Have to adjust for when the freq is repeated
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
}