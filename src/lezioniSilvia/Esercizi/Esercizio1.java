package lezioniSilvia.Esercizi;
//scrivere un programma che stampa su console x,y(interi da 1 a 10 ) random, e prende in input z
import java.util.*;
public class Esercizio1 {
	public static void main(String [] args) {
		//boolean condizione=true;
		while(true) {
			int max=10;
			int x =(int)(Math.random()*max)+1;
			int y =(int)(Math.random()*max)+1;
			Scanner sc = new Scanner(System.in);
			System.out.println("Quale può essere la somma tra x e y?");
			int z= sc.nextInt();
			int somma=x+y;
			if(somma!=z){
				System.out.println("No, mi dispiace.. la somma tra "+x+" e "+y+" è: "+somma);

			}
			else{
				System.out.println("Bravo, hai indovinato!Infatti i numeri erano x="+x+" e y="+y+" e la somma è proprio="+z);
				break;
			}
		}	
	}
}
