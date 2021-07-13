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

public class Main {
	public static void main (String [] args) throws FileNotFoundException{
		Phase1 p1=new Phase1();
		//Method to read from a text file
		@SuppressWarnings("resource")
		String text =new Scanner(new File("readme.txt")).useDelimiter("\\Z").next();
		String [] words=p1.split(text);
		SQueue cola=p1.createQueue(words);
		
		//Tries phase 1
		p1.add(cola);
		System.out.println();
		System.out.println(p1.show('A'));
		System.out.println();
		System.out.println(p1.show('g'));
		System.out.println(p1.search("time"));
		System.out.println(p1.search("JGJ"));
		System.out.println(p1.search("house"));
		System.out.println(p1.getTop(3));
		System.out.println(p1.getLow(4));
		
		//Tries phase2
		Phase2 p2=new Phase2();
		String [] words2=p2.split(text);
		SQueue cola2=p2.createQueue(words2);
		SQueue cola3=p2.createQueue2(words2);
		//Using methods
		p2.add(cola2);
		p2.add2(cola3);
		System.out.println();
		p2.show('A');
		System.out.println();
		p2.show('c');
		System.out.println(p2.search("isabel"));
		System.out.println(p2.search("time"));
		System.out.println(p2.search("per"));
		System.out.println(p2.getTop(2));
		System.out.println(p2.getLow(8));		
	}
}