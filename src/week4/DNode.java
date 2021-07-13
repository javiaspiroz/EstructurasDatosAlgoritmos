package week4;

/**
 * 
 * @author Javier Aspiroz de la Calle
 * @since February 2017
 * @version 1.0
 *
 */

public class DNode {
	public String elem;
	public DNode prev;
	public DNode next;
	//Constructor
	public DNode(String elem) {
		this.elem = elem;
	}
}