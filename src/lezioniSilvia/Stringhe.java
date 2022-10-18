package lezioniSilvia;

//testi,messaggi,codici
public class Stringhe {
	
	public static void main(String[]args) {
		//a5,b6
		String titolo="titolo";//literal- letterali

		String nuovoTitolo=new String("nuovo titolo");
		
		char c='c';//i char vengono denotati dal singolo apice ', le stringhe invece dai doppi apici "
		char[] arraySottotitolo= {'h','e','l','l','o'};
		String sottotitolo=new String(arraySottotitolo);
		
		System.out.println(arraySottotitolo[1]);
		System.out.println(sottotitolo.charAt(1));
	}
	
	
	
	
	

}
