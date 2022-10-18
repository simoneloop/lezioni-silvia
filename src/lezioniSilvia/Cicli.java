package lezioniSilvia;
import java.util.*;

public class Cicli {
	public static void main(String[] args) {
		//ciclo while a condizione iniziale e sarà ripetuto 0-1-più volte
//		int contatore=0;
//		while(contatore<10) {
//			System.out.println(contatore++);
//		}
//		
		int contatore=0;
		while(contatore==-1) {
			contatore++;
		}
		System.out.println("ciclo while a condizione iniziale: "+contatore);
		
		//ciclo while a condizione finale e sarà ripetuto almeno 1 volta
		do {
			contatore++;
		}
		while(contatore==-1);
		
		
		System.out.println("ciclo while a condizione finale: "+contatore);
		//true==true
		//tutti i numeri naturali
//		int cont=0;
//		while(true) {
//			System.out.println(cont++);
//		}
		
		//operatore ternario
		int a=2;
		int b=2;
		//boolean aMajorB=a>b?true:false;
		int c=a>b?1:-1;//se a>b c>0; se a<b c<0;se a=b c=0 //importante
		System.out.println(c);
		c=a>b?1:a==b?0:-1;//se a>b c>0; se a<b c<0;se a=b c=0 //molto meno importante
		System.out.println(c);
		
		Random randomGenerator=new Random();
		int index=randomGenerator.nextInt(12)+1;//Uguale a randomGenerator.nextInt(12)+1; //overloading è la sovrascrizione di un metodo passandogli diversi parametri
		System.out.println("mese dell'anno di indice: "+index);
		if(index==1) {
			System.out.println("è gennaio");
		}
		else if(index==2) {
			System.out.println("è febbraio");
		}
		else {
			System.out.println("troppo lungo da completare");
		}
		
		switch(index) {
			case 1:System.out.print("Gennaio");break;
			case 2:System.out.print("Febbraio");break;
			case 3:System.out.print("Marzo");break;
			case 4:System.out.print("Aprile");break;
			case 5:System.out.print("Maggio");break;
			case 6:System.out.print("Giugno");break;
			case 7:System.out.print("Luglio");break;
			case 8:System.out.print("Agosto");break;
			case 9:System.out.print("Settembre");break;
			case 10:System.out.print("Ottobre");break;
			case 11:System.out.print("Novembre");break;
			case 12:System.out.print("Dicembre");break;
			default:System.out.println("questo mese è sconosciuto all'uomo");
		}
		
	}
	

}
