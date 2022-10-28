package lezioniSilvia.Esercizi;
//Verificare se una matrice quadrata di interi è una “scacchiera” ovvero se vi sono presenti solo 0 e 1 alternati tra loro.
import java.util.*;

public class Esercizio9 {
	public static void main(String[]args) { 						//010
		int[][] matrice= new int[3][3];								//101
		leggiEScrivi(matrice);										//010 sì scacchiera
		System.out.println("La matrice è una scacchiera? "+eUnaScacchiera(matrice));
	}																
	
																	//avvalersi del supporto di un booleano
	static boolean verificaDiversi(int first,int[][]m) {
		int second=0;
		for(int i=0; i<m.length; i++) {
			for(int j=i+1; j<m.length-1; j++) {
				second=m[i][j];
				//System.out.println("Il valore da verificare è: "+first+". E' diverso da: "+second+"?");
			}
			if(second!=first) {
				//System.out.println(true);
				return true;
			}
			break;
		}
		return false;
	}
	static boolean eUnaScacchiera(int[][]m) {
		boolean condizione= true;
		int first;
		for(int i=0; i<m.length; i++) {
			first=0;
			for(int j=0; j<m.length; j++) {
				first=m[i][j];
				//System.out.println("Il primo valore è: "+first);
				if(first==1) {
					//System.out.println("siamo entrati nell'if ==1 ");
					condizione=verificaDiversi(first,m);
				}
				else if(first==0) {
					//System.out.println("Siamo entrati nell'if ==0 ");
					condizione=verificaDiversi(first,m);
				}
				else {
					System.out.println("Non è una matrice composta da 0 e 1");
					System.exit(-1);
				}
			}
			if(condizione) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	static void leggiEScrivi(int[][]m) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Inserisci i valori che compongono la matrice: ");
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				m[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				System.out.print(" "+m[i][j]);
			}
			System.out.println();
		}
	}
}
