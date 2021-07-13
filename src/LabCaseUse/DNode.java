package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public class DNode {

	public String elem;
	public DNode prev;
	public DNode next;
	public int freq=1;
	
	public DNode(String elem) {
		this.elem = elem;
	}
}