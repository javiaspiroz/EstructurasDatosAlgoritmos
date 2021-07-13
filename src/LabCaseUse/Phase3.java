package LabCaseUse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public class Phase3 {
	DList d=new DList();//all words in the text file
	DListVertex d2=new DListVertex();//list with words to play the game
	DList di=new DList();//initial parts of words
	DList df=new DList();//final part of words
	GraphLA g;
	//method to split the text
	public String [] split (String text){
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
	@SuppressWarnings("resource")
	public void getWords(int n, String f) throws FileNotFoundException{
		//first we got the all the words
		String text = new Scanner(new File(f)).useDelimiter("\\Z").next();
		//we split the text
		String [] words=split(text);
		//add words to DList
		for (int ii=0; ii<words.length; ii++){
			d.addFirst(words[ii]);
		}
		//select words to play the game, we don't mind if there are repeated ones
		for (int ii=0; ii<n;ii++){
			int num=(int)(Math.random()*words.length-1);
			int pos=0;
			for (DNode nodeIt = d.header.next; nodeIt != d.trailer; nodeIt = nodeIt.next){
				if (pos==num){
					d2.addFirst(nodeIt.elem);
					d.removeAt(pos);
				}
				pos++;
			}
		}
		g=new GraphLA(n,n,true);
		
	}
	public void first(){
		/*for (DNode nodeIt = d2.header.next; nodeIt != d2.trailer; nodeIt = nodeIt.next){
			di.addFirst(nodeIt.elem.substring(0, 2));
		}*/
	}
	public void last(){
		/*for (DNode nodeIt = d2.header.next; nodeIt != d2.trailer; nodeIt = nodeIt.next){
			df.addFirst(nodeIt.elem.substring(nodeIt.elem.length()-2));
		}*/
	}
	public void sinkholes(){
		/*for (DNode nodeIt = di.header.next; nodeIt != di.trailer; nodeIt = nodeIt.next){
			int reps=0;
			for (DNode nodeIt2 = df.header.next; nodeIt2 != df.trailer; nodeIt2 = nodeIt2.next){
				if (nodeIt.elem.equals(nodeIt2.elem)){
					reps++;
				}
				if (di.getSize()==reps){
					//Now we have to find a new word
					
				}
			}
		}*/
	}
	public String list(String word){
		if (d2.contains(word)==false){
			return null;
		}
		else{
			String text="";
			
			return text;
		}		
	}
	public String maxList(){
		String text="";		
		/*for (int ii=0; ii<di.getSize();ii++){
			for (DNode nodeIt = di.header.next; nodeIt != di.trailer; nodeIt = nodeIt.next){
			
			}
		}*/
		
		return text;
	}	
}