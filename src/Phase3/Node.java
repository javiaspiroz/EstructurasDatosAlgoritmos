package Phase3;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public class Node {
	
	public String elem;
	public int pos;
	public Node next;
	public Node prev;
	public String pre; // first two letters
	public String last; // last two letters
	
	public Node(String e) {
		elem = e;
		pre = e.substring(0, 2); // get first two letters 
		last = e.substring(e.length()-2); // get last two letters 		
	}
	public Node(int e) {
		pos = 0;
	}
}
