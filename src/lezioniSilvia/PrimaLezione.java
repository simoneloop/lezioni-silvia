package lezioniSilvia;

import java.util.*;

public class PrimaLezione {
	public static void main(String[]args) {
		//tipi di base
//		interi:
//			int 2^32-1 int maxInt=4294967295;
//			long
//		
//		reali:
//			float 3.14
//			double
//		non numerici:
//			boolean
//			char
		int i,a,c;//dichiarazione ma non inizializzazione
		i=0;
		a=1;c=2;
		double d=3.14;
		float f=3.14f;
		a=(int)3.14;
		//System.out.println("a prima era 3.14 ora è: "+a);
		
		
		System.out.print("questo è un print normale");
		System.out.println("questo è ln");
		System.out.println("di nuovo normale");
		System.out.println(a++);//incremento post istruzione printerà 3
		System.out.println(++a);//incremento pre istruzione printerà 4
		
		int y=10/8;//restituisce il quoziente
		System.out.println("il quoziente di 10/8 è: "+y);
		int resto=10%8;//restituisce il resto
		System.out.println("il resto di 10/8 è: "+resto);
		
		double divisione=10.0/8;
		System.out.println(divisione);
		a=0;
		//corto circuito mi permette di non andare ad analizzare la seconda condizione quindi non causare in caso problemi
		if(a>0 && 8/a>1) {//true and true=true; true and false=false; false and....=false
			System.out.println("a >0 e 8/a >1");
		}
		a=-1;
		if(a<0 || Math.sqrt(a)>1) {//true or...=true; false or false=false; false or true=true
			System.out.println("radice di a >1");
			
		}
		//boolean assegnazione diretta
		boolean female=true;
		
		
		//boolean assegnazione indiretta
		int eta=18;
		boolean isMajor=eta>18;//condizione
		if(eta>18) {
			System.out.println("è maggiorenne");
		}
		//sintassi dell'if
//		if(condizione) {
//			istruzione;
//		}
		boolean majorAndFemale=female&&isMajor;
		System.out.println("è femmina e maggiorenne: "+majorAndFemale);
		
		
		//classe Math
		//esponenziale Math.exp(x)
		//logaritmo log(x);
		//potenza pow(x,y); x^y
		
		//arrotondamento
//		inferiore ceil(x); arrotondamento inferiore 2.6=2
//		superiore floor(x); arrotondamento superiore 2.4=3
//		normale round(x); arrotondamento normale 2.5+=3; 2.4-=2
//		valore assoluto abs(x); -x=x
//		massimo e minimo max(x,y), min(x,y);
//		numero casuale random(); così solo un numero compreso tra [0,1)
		double r=Math.random()*10;//pseudo random //ambiente deterministico
		System.out.println((int)r);
		System.out.println("il maggiore tra 2 e 3 è: "+ Math.max(2, 3));
		
		//espressioni
		int x,w,z;
		x=1;
		w=2;
		z=3;
		double espressione=x+w*z+2;
		System.out.println("l'espressione vale: "+espressione);
		
		//scanner sistema basilare per operazioni IO
//		Scanner sc=new Scanner(System.in);//quando un'oggeto inizia con la lettera maiuscola è un oggetto complesso //system.in=tastiera
//		System.out.println("leggiamo e stampiamo qualcosa, inserisci un intero:");
//		int input=sc.nextInt();
//		System.out.println("il numero intero inserito è:"+input);
//		
		
		if(eta>18) {
			System.out.println("è maggiorenne");
		}
		else if(eta==18) {
			System.out.println("ha esattamente 18 anni");
		}
		else if(eta<0) {
			System.out.println("non è ancora nata");
		}
		else {
			System.out.println("non è maggiorenne");

		}
			
		
		
	}

}
