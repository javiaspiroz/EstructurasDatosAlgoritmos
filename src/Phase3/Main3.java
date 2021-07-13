package Phase3;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public class Main3 {
	public static String file;
	public static void main(String[] args) {
		Chain chain = new Chain();
		//We should write down here the path of our file.
		file = "C:/Users/AspiCalle/Desktop/readme.txt";
		chain.getWords("C:/Users/AspiCalle/Desktop/readme.txt"); 
		System.out.println();
		chain.selectWords(5);
		//testing some methods
		chain.getChainOf("lover") ;
		System.out.println();
		chain.getBigChain();
		System.out.println();
		chain.sink("house");
		chain.sink("time");
		chain.sink("isabel");
		chain.sink("lover");	
		chain.getBigChain();
	}	
}