package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public interface IQueue {
	
	public boolean isEmpty();

	public void enqueue(String elem);

	public String dequeue();

	public Object front();

	public int getSize();
	
}