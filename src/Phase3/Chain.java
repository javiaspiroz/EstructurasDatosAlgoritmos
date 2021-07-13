package Phase3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public class Chain {
	SList words = new SList();
	SList choosed = new SList();
	SList chained = new SList();
	static int maxSize = 0;
	static SList bigChain = new SList(); // Biggest chain will be stored there 
	Scanner sc = new Scanner(System.in);
	//Methods
	// Method saving all words in the file
	public void getWords( String file){			
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			System.out.println("File was read");						
			try {						
				String line ;							
				while( (line = br.readLine()) != null){
					String arr[] =  line.split(" ");
					for(int i = 0; i< arr.length ; i++){
						words.addToList(arr[i]);
					}
				}
			} catch (IOException e) {
				System.out.println("Error");
			}
		} catch(FileNotFoundException f){
			System.out.println("File wasn't found");
		}
	}
	public void selectWords(int n){
		int randPos;
		int wordsc = n ;
		while(wordsc != 0){
			randPos = (int) (Math.random()*(words.size));
			if(!choosed.contains((words.getAt(randPos)))){
				Node sel = new Node(words.getAt(randPos));
				choosed.addToList(sel.elem);
				wordsc--;
			}
		}
		System.out.println("Selected words: ");
		choosed.print();
		System.out.println();
	}
	// Check if a word is a Sinkhole
	public boolean sink(String w){
		Node n=new Node(w);
		boolean b=true ;
		choosed.last = choosed.first;
		while(choosed.last!=null){
			if(!n.last.equals(choosed.last) && n.last.equals(choosed.last.pre)){
				b=false;  System.out.println(n.elem+" is not a sinkhole");
				break;
			}
			choosed.last = choosed.last.next;
		}
		if(b){
			System.out.println("A sinkhole was found: "+n.elem);
			choosed.last = choosed.first;
			while(choosed.last.next !=null){choosed.last = choosed.last.next;}
			selectWords(1); 
			choosed.removeAt((choosed.getIndexOf(n)));
			System.out.println("Sinkhole was replaced, the new list of words is: ");
			choosed.print();
			System.out.println();
		}
		return b ;
	}
	//Word chaining
	public void getChainOf(String w){
		chained.addToList(w);
		int n = choosed.size;
		boolean found  = true;
		n--;
		while(found){
			choosed.last = choosed.first;
			while(choosed.last.next!=null){
				if(!chained.last.equals(choosed.last)&& chained.last.last.equals(choosed.last.pre)){ 
					chained.addToList(choosed.last.elem);}
				choosed.last =choosed.last.next;
				n--;
				if(n<0){found = false;}
			}
		}
		System.out.println();
		System.out.println("Chain with "+w+": ");
		chained.print();
		// saving biggest chain 
		if(chained.size > maxSize){
			maxSize = chained.size;
			// remove previous elements from last list
			bigChain.removeAll();
			chained.last = chained.first;
			while(chained.last != null){
				bigChain.addToList(chained.last.elem); // copy chained list 
				chained.last = chained.last.next;
			}
		}
		chained.removeAll();
	}
	public void getBigChain(){
		if(bigChain.isEmpty()){System.out.println(" Chain has not been created yet");}
		else{
			System.out.println("Biggest chain created");
			bigChain.print();
			System.out.print(bigChain.last.elem);
			System.out.println(); 
		}
	}
	public int getword(){
		return words.size;
	}
}