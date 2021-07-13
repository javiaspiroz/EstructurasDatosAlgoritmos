package LabCaseUse;

/**
 * 
 * @author Javier Aspiroz de la Calle & Carlos Prieto
 * @since May 2017
 * @version 1.0
 *
 */

public interface IListG {

	public void addFirst(int v, float f);

	public void addLast(int v, float f);

	public void removeFirst();

	public void removeLast();
	
	
	public void insertAt(int index, int v, float f);
	
	public boolean isEmpty();

	public boolean contains(int v);

	public int getSize();

	public int getIndexOf(int v);

	public String getFirst();

	public String getLast();

	public String getVertexAt(int index);
	public Float getWeightAt(int index);

	public String toString();

	public void removeAll(int vertex);

	public void removeAt(int index);

}


