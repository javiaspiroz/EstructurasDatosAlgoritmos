package week2;

/**
 * 
 * @author Javier Aspiroz de la Calle
 * @since February 2017
 * @version 1.0
 *
 */

public class StackGen implements IStack{
	//Implementation for a simple Stack
	SNode peak=null;
	public boolean isEmpty(){
		return peak==null;
	}
	public void push(Object elem){
		SNode newNode=new SNode(elem);
		newNode.next=peak;
		peak=newNode;
	}
	public Object pop(){
		if (isEmpty()){
			System.out.println("The stack is empty");
			return null;
		}
		Object elem=peak.elem;
		peak=peak.next;
		return elem;
	}
	public Object top(){
		if (isEmpty()){
			System.out.println("The stack is empty");
			return null;
		}
		return peak.elem;
	}
	public int getSize(){
		int size=0;
		SNode node=peak;
		while (node!=null){
			size++;
			node=node.next;
		}
		return size;
	}
	//Method for proving if balanced
	public boolean isBalanced (char [] exp){
		boolean res=false;
		for (int ii=0; ii<exp.length; ii++){
			if (exp[ii]=='[' ||exp[ii]=='{' || exp[ii]=='('){
				push(exp[ii]);
			}
			else if (exp[ii]==']' || exp[ii]=='}' || exp[ii]==')'){
				push(exp[0]);//First position is queried
				if ((exp[0]=='['&& exp[ii]==']')){
					pop();
				}
				if ((exp[0]=='{'&& exp[ii]=='}')){
					pop();
				}
				if((exp[0]=='('&& exp[ii]==')')){
					pop();
				}
			}
			else{
				pop();
			}
		}
		if (isEmpty()){
			res=true;
		}
		return res;
	}
}