package exampleExercises;

public class Main {

	public static void main(String[] args) {
		int [] coefs=new int[]{5,8,9,7,2,4,6}, p2=new int[]{2,5,6,9,8};
		Polynomial pol=new Polynomial(coefs);
		Polynomial p=new Polynomial(p2);
		pol.show();
		p.show();
		System.out.println(pol.getDegree());
		pol.getCoeficient(9);//no that pos
		System.out.println(pol.getCoeficient(3));
		pol.setCoeficient(9, 5);//no that pos
		pol.setCoeficient(3, 25);
		pol.show();
		System.out.println(pol.getValue(6));
		System.out.println(pol.getValue(2));
		pol.suma(p).show();
		

	}

}
