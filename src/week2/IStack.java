package week2;

/**
 * 
 * @author Javier Aspiroz de la Calle
 * @since February 2017
 * @version 1.0
 *
 */

public interface IStack {
	public boolean isEmpty();
	public void push(Object elem);
	public Object pop();
	public Object top();
	public int getSize();
}