package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public interface IQueueG {

	public boolean isEmpty();

	public void enqueue(Integer elem);

	public Integer dequeue();

	public Integer front();
	
	public int getSize();
	

}

