package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0 
 *
 */

public interface IBSTNode {

	/* number of nodes in its subtree */
	public int getSize();

	/* length of the longest way to some of its subtree's leaves plus one */
	public int getHeight();

	/* length of the way from to the root */
	public int getDepth();

	public IBSTNode getRoot();

	public void getPreorder();

	public void getInorder();

	public void getPostorder();

}