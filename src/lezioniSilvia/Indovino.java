package lezioniSilvia;
import java.util.*;

public class Indovino {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int max=10;
		int random=(int)(Math.random()*max)+1;
	
		System.out.println("sto pensando ad un numero tra 1 e "+max);
		System.out.println("qual è?");
		int risposta=sc.nextInt();
		if(random==risposta) {
			System.out.println("bravo!");
		}
		else {
			System.out.println("oh no ho pensato a: "+random+" ritenta sara più fortunato");
		}
	}
	// scrivere un programma che stampa su console x,y(interi da 1 a 10 ) random, e prende in input z
	//restituisce true solo se x+z=z
	
	//con il while true

}
