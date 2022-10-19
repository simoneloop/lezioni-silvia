package lezioniSilvia.Esercizi;
//leggere una sequenza di interi fino al primo negativo e contare quante volte succede che un numero è
//maggiore del precedente
//esempio: 2 1 4 3 2 4 67 8 4 -1 ---->3

import java.util.*;
public class Esercizio2 {
	public static void main(String [] args) {
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		int count=0;
		while(a>0) {
			int b=sc.nextInt();
			if (b>a) {
				count++;
				a=b;
			}
			else {
				a=b;
			}
		}
		System.out.println("Il numero totale di elementi maggiori dei precedenti è: "+count);	
	}
}	




