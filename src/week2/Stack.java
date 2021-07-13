package week2;

public class Stack implements IStack{
	//Implementation for a Stack managing an Array
	//Variables
	Object [] stack;
	int top;
	//Constructor
	public Stack (int N){
		stack=new Object[N];
		top=0;
	}
	//Methods
	public boolean isEmpty(){
		return top==0;
	}
	public int getSize(){
		return top;
	}
	public Object pop(){
		if(isEmpty()){
			System.out.println("The stack is empty");
			return null;
		}
		Object peek=stack[top-1];
		stack[top-1]=null;
		top--;
		return peek;
	}
	public Object top(){
		if(isEmpty()){
			System.out.println("The stack is empty");
			return null;
		}
		return stack[top-1];
	}
	public void push (Object elem){
		//Not well implemented
		/*if (stack.length==top){
			System.out.println("Stack is full");
		}
		else{
		SNode newNode=new SNode(elem);
		stack[top]=elem;
		top++;
		newNode.next=;
		}*/
	}
}