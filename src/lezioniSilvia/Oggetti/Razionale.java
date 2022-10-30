package lezioniSilvia.Oggetti;

public class Razionale {
	//è un semplice rapporto tra due numeri interi
	//gli oggetti che andremo a creare sono oggetti immutabili quindi ogni operazione aritmetica non modifica this ma crea un nuovo razionale
	//a tempo di costruzione controlliamo che il denominatore non sia nullo
	//a/b con b=0 forma indeterminata
	//a/b con a=0 return 0 a*1/b
	//un eventuale segno negativo al denominatore è trasferito al numeratore
	//una frazione è mantenuta ridotta ai minimi termini, ovvero numeratore e denominatore sono primi tra loro
	
	//2/6 =1/3, 3/9
	
	private final int NUM,DEN;
	private static int contatore=0;//classe
	
	
	public Razionale(int num,int den) {
		if(den==0) {
			System.out.println("il denominatore non può essere 0");
			System.exit(-1);
		}
		if(num!=0) {
			int n=Math.abs(num);
			int d=Math.abs(den);
			int cd=mcd(n,d);
			num=num/cd;
			den=den/cd;
		}
		if(den<0) {
			num*=-1;
			den*=-1;
		}
		this.NUM=num;
		this.DEN=den;
		
		
		
		
		
		
		contatore++;
	}
	
	private int mcd(int x,int y) {
		do {
			int r=x%y;
			x=y;
			y=r;
		}
		while(y!=0);
		return x;
	}
	
	public static int razionaliCreati() {
		return contatore;
	}
	
	public String toString() {
		if(DEN==1) return ""+NUM;
		if(NUM==0) return "0";
		return ""+NUM+"/"+DEN;
	}

}
