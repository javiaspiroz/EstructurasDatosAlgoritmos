package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public interface IBSTree {

	public Object find(Integer key);

	public void insert(Integer key, String elem);

	public void remove(Integer key);

}