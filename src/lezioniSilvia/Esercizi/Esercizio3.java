package lezioniSilvia.Esercizi;
//leggere un intero positivo N e scrivere l'N-esimo numero della serie di Fibonacci così definita: 
//1 1 2 3 5 8 13....
//esempi: fibonacci(5) =>5; fibonacci(6) =>8; fibonacci(50)?
import java.util.*;
public class Esercizio3 {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Seleziona un numero intero per trovare il suo corrispondente nella serie di Fibonacci: ");
		long n=sc.nextInt();
		long numeroFibonacci= cercaNumero(n);
		System.out.print("Il numero che corrisponde a: "+n+" è: "+numeroFibonacci);
	}
	static long cercaNumero(long n) {
		long numeroEquivalente;
		if(n==0) {
			numeroEquivalente=0;
		}
		else if(n==1) {
			numeroEquivalente=1;
		}
		else {
			numeroEquivalente= cercaNumero(n-1)+cercaNumero(n-2);
			//fibonacci(5)--> fibonacci(4)+ fibonacci(3)--> 3+2=5
			//fibonacci(4)--> fibonacci(3)+ fibonacci(2)--> 2+1=3
			//fibonacci(3)--> fibonacci(2)+ fibonacci(1)--> 1+1=2
			//fibonacci(2)--> fibonacci(1)+ fibonacci(0)--> 1+0=1
			//fibonacci(1)--> 1
			//fibonacci(0)--> 0
		}
		return numeroEquivalente;
	}
}

