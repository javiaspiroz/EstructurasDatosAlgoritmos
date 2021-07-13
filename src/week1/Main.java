package week1;

/**
 * 
 * @author Javier Aspiroz de la Calle
 * @since February 2017
 * @version 1.0
 *
 */

public class Main {

	public static void main(String[] args) {
		ListInt l=new ListInt(4);
		l.addFirst(5);
		System.out.println(l);
		l.isEmpty();
		l.insertAt(3, 5);
		System.out.println(l);
		System.out.println(l.getFirst());

	}

}
