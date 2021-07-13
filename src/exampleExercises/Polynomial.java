package exampleExercises;

public class Polynomial implements iPolynomial{
	int [] coef;
	public Polynomial(int [] coefs){
		coef=coefs;
	}
	@Override
	public int getDegree(){
		//return coef[coef.length-1];
		for (int i=coef.length-1;i>=0;i--) {
			if (coef[i]!=0) return i;
		}
		return 0;
	}
	@Override
	public int getCoeficient(int n){
		if (n>=coef.length || n<0) {
			System.out.println(n + " is out of range");
			return -1;
			}
			return coef[n];
	}
	@Override
	public void setCoeficient(int n, int newValue){
		if (n>=coef.length || n<0) {
			System.out.println(n + " is out of range");
			return;
		}
			coef[n]=newValue;
	}
	@Override
	public int getValue(int x){
		int value =0;
		for (int ii=0; ii<coef.length; ii++){
			value=value+coef[ii]*(int)Math.pow(x,ii);
		}
		return value;
	}
	@Override
	public iPolynomial suma(iPolynomial p){
		int maxDegree=Math.max(p.getDegree(), this.getDegree());
		int minDegree=Math.min(p.getDegree(), this.getDegree());
		int[] sumPoly=new int[maxDegree];		
		if (p.getDegree()<this.getDegree()) {
			for (int i=minDegree; i<this.getDegree(); i++) {
				sumPoly[i]=this.getCoeficient(i);
			}
		} else if (p.getDegree()>this.getDegree()) {
			for (int i=minDegree; i<p.getDegree(); i++) {
				sumPoly[i]=p.getCoeficient(i);
			}
		}
		for (int i=0; i<minDegree; i++) {
			sumPoly[i]=p.getCoeficient(i)+this.getCoeficient(i);
		}
		iPolynomial newPol=new Polynomial(sumPoly);
		return newPol;
	}
	public void show(){
		String res="";
		for (int ii=0; ii<coef.length; ii++){
			res=res+coef[ii]+"x^"+ii+"+";
		}
		System.out.println(res);
	}
}