package week1;

/**
 * 
 * @author Javier Aspiroz de la Calle
 * @since February 2017
 * @version 1.0
 *
 */

public class ListInt implements iListInt{
	//Variables
	public int [] list;
	//Constructor
	public ListInt (int size){
		list=new int [size];
	}
	//Methods
	@Override
	public void addFirst(int newElem){
		if (list[list.length-1]!=0){
			for (int ii=list.length-1; ii>=1;ii--){
				list[ii]=list[ii-1];
			}
			list[0]=newElem;
		}
		else System.out.println("Array is full");
	}
	@Override
	public void addLast(int newElem){
		if (list[list.length-1]!=0){
			for (int ii=0; ii<=list.length-2;ii--){
				list[ii+1]=list[ii];
			}
			list[list.length-1]=newElem;
		}
		else System.out.println("Array is full");
	}
	@Override
	public void removeFirst(){
		if (list[0]!=0){
			for (int ii=0; ii<list.length;ii++){
				list[ii]=list[ii+1];
			}
			list[0]=0;
		}
		else System.out.println("Array is empty");
	}
	@Override
	public void removeLast(){
		if (list[list.length-1]!=0){
			list[list.length-1]=0;
		}
		else System.out.println("Array is empty");
	}
	@Override
	public void insertAt(int index, int newElem){
		if (index<0 || index>=list.length){
			System.out.println(index+" is not a valid index");
		}
		else if (list[list.length-1]==0){
			System.out.println("Array is full");
		}
		else{
			list[index]=newElem;
		}
	}
	@Override
	public boolean isEmpty(){
		boolean res=false;
		int count=0;
		if (list==null){
			res=true;
		}
		for (int ii=0; ii<list.length; ii++){
			if (list[ii]==0){
				count++;
			}
		}
		if (count==list.length){
			res=true;
		}
		return res;
	}
	@Override
	public boolean contains(int elem){
		boolean res=false;
		for (int ii=0; ii<list.length; ii++){
			if (list[ii]==elem){
				res=true;
			}
		}
		return res;
	}
	@Override
	public int getSize(){
		return list.length;
	}
	@Override
	public int getIndexOf(int elem){
		int aux=-2;
		for (int ii=0; ii<list.length; ii++){
			if (list[ii]==elem){
				aux=ii;
			}
			else aux=-1;
		}
		return aux;	
	}
	@Override
	public int getFirst(){
		int aux=-2;
		if (list==null){
			aux=-1;
		}
		else aux=list[0];
		return aux;
	}
	@Override
	public int getLast(){
		int aux=-2;
		if (list==null){
			aux=-1;
		}
		else aux=list[list.length-1];
		return aux;
	}
	@Override
	public int getAt(int index){
		int aux=0;
		if (index<0 ||index>=list.length){
			aux=-1;
		}
		else aux=list[index];
		return aux;
	}
	@Override
	public String toString(){
		String res="";
		if (list==null) res="The list is empty";
		else{
			for (int ii=0; ii<list.length; ii++){
				res=res+list[ii]+" ";
			}
		}
		return res;
	}
	@Override
	public void removeAll(int elem){
		for (int ii=0; ii<list.length; ii++){
			if (list[ii]==elem){
				list[ii]=0;//Default number for integers.
			}
		}
	}
	@Override
	public void removeAt(int index){
		if (index>=list.length){
			System.out.println(index +" is not a valid position");
		}
		else{
			list[index]=0;
		}
	}
}