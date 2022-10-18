package lezioniSilvia;
//scrivere un programma che stampa su console x,y(interi da 1 a 10 ) random, e prende in input z
//restituisce true solo se x+z=z

//inserire un numero negativo per interrompere
	
//con il while true
import java.util.*;
public class DoWhile {
	public static void main(String [] args) {
		//boolean condizione=true;
		boolean continua=true;
		while(continua) {
			int max=10;
			int x =(int)(Math.random()*max)+1;
			int y =(int)(Math.random()*max)+1;
			Scanner sc = new Scanner(System.in);
			System.out.println("Quale può essere la somma tra "+x+" e "+y);
			int z= sc.nextInt();
			int somma=x+y;
			if(somma!=z){
				System.out.println("No, mi dispiace.. la somma tra "+x+" e "+y+" è: "+somma);

			}
			else{
				System.out.println("Bravo, hai indovinato!Infatti i numeri erano x="+x+" e y="+y+" e la somma è proprio="+z);
			}
			System.out.print("inserisci un numero negativo per interrompere il programma: ");
			if(sc.nextInt()<0) {
				//System.exit(-1);
				continua=false;
			}
		}
		boolean continuaa;
		do {
			int max=10;
			int x =(int)(Math.random()*max)+1;
			int y =(int)(Math.random()*max)+1;
			Scanner sc = new Scanner(System.in);
			System.out.println("Quale può essere la somma tra "+x+" e "+y);
			int z= sc.nextInt();
			int somma=x+y;
			if(somma!=z){
				System.out.println("No, mi dispiace.. la somma tra "+x+" e "+y+" è: "+somma);

			}
			else{
				System.out.println("Bravo, hai indovinato!Infatti i numeri erano x="+x+" e y="+y+" e la somma è proprio="+z);
			}
			System.out.print("inserisci un numero negativo per interrompere il programma: ");
			if(sc.nextInt()<0) {
				continuaa=false;
			}
			else {
				continuaa=true;
			}
		}
		while(continuaa);
	}
}