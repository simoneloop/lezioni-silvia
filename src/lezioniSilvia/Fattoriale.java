package lezioniSilvia;
import java.util.*;
public class Fattoriale {
	//4!=6 2*3*4
	public static void main(String[]args) {
		System.out.println("calcolo del fattoriale di un intero n non negativo");
		Scanner sc=new Scanner(System.in);
		System.out.print("n(>=0):");
		int n=sc.nextInt();
		int fattoriale=1;
		int i=2;
		while(i<=n) {
			fattoriale=fattoriale*i;
			i++;
		}
		System.out.println(n+"! ="+fattoriale);
		
		
		fattoriale=1;
		for(int j=2;j<=n;j++) {
			fattoriale=fattoriale*j;
			
		}
		System.out.println(n+"! ="+fattoriale);
		
		int res=fattoriale(5);
	}
	
	
	
	//public private protected //public condivisione libera tra package diversi //private nessuna condivisione tra classi diverse 
	//protected condivisione libera solo nello stesso package
	static int fattoriale(int n) {
		int fattoriale=1;
		for(int j=2;j<=n;j++) {
			fattoriale=fattoriale*j;
			
		}
		return fattoriale;
		
	}
	

}
