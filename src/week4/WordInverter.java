package week4;

public class WordInverter {
	String word;
	//Methods
	public char [] divider (String word){
		char[] divided=new char [word.length()];
		for(int ii=0; ii<word.length();ii++){
			divided[ii]=word.charAt(ii);
		}
		return divided;
	}
	public char [] inverter (char [] divided){
		char [] res=new char[divided.length];
		for(int ii=divided.length-1; ii>0; ii--){
			int i=0;
			res[ii]=divided[i];
			i++;
		}
		return res;
	}
	public String toString(char [] inverted){
		String res="";
		for (int ii=0; ii<inverted.length; ii++){
			res=res+inverted[ii];
		}
		return res;
	}
	//Method to use the whole program
	public void wordInverter(String word){
		char [] ex=divider(word);
		char[] fin=inverter(ex);
		toString(fin);
	}
	public static void main(String[] args) {
		WordInverter p = new WordInverter();
		p.wordInverter("Hello");
		System.out.println(p.toString());
	}
}