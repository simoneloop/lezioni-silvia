package lezioniSilvia.Esercizi;
//somma palindroma:
//data una matrice quadrata verificarne se è "somma-palindroma per riga e per colonna" ovvero 
//se la somma degli elementi nella prima riga/colonna è uguale alla somma degli elementi
//dell'ultima riga/colonna
//se la somma della seconda riga/colonna == somma penultima riga/colonna
import java.util.*;

public class Esercizio8 {
	static boolean sommaPalindromaRighe(int[][]m) {
		int sommaRigheS=0;
		int sommaRigheI=0;
		for(int i=0;i<m.length;i++) {
			if(i<m.length/2) {
				for(int j=0;j<m[0].length;j++) {
					sommaRigheS+=m[i][j];
					sommaRigheI+=m[m.length-1-i][j];
				}
				if(sommaRigheS!=sommaRigheI) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	static boolean sommaPalindromaColonne(int[][]m) {
		int sommaColonneS=0;
		int sommaColonneI=0;
		for(int i=0;i<m.length;i++) {
			if(i<m.length/2) {
				for(int j=0;j<m[0].length;j++) {
					sommaColonneS+=m[j][i];
					sommaColonneI+=m[i][m.length-1-j];
				}
				if(sommaColonneS!=sommaColonneI) {
					return false;
				}
			}
		}
		return true;
	}	
	
	
	static void verificaMatricePalindroma(int[][]m) {
		if(sommaPalindromaRighe(m) && sommaPalindromaColonne(m)) {
			System.out.println("La matrice è palindroma sia sulle righe sia sulle colonne");
		}
		else if(sommaPalindromaRighe(m)) {
			System.out.println("La matrice è palindroma solo sulle righe");
		}
		else if(sommaPalindromaColonne(m)){
			System.out.println("La matrice è palindroma solo sulle colonne");
		}
		else {
			System.out.println("La matrice NON è palindroma");
		}
	}
	public static void main(String[]args) {
		//int[][] matrice= new int[4][4];
		int[][]matrice= {{1,0,1,1},
						{1,0,1,1},
		 		        {1,1,1,1},
		 		        {1,0,1,1}};
		//leggiEScrivi(matrice);
		verificaMatricePalindroma(matrice);
		
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
//PRIMA PROVA
//int count1=0;
//int count2=0;
//for(int i=0; i<m.length; i++) {
//	int sommaR1=0;
//	for(int j=0; j<m[0].length; j++) {
//		sommaR1+=m[i][j];
//	}
//	count1=sommaR1;
//}
//for(int i=m.length-1; i>0; i--) {
//	int sommaR2=0;
//	for(int j=0; j<m[0].length; j++) {
//		sommaR2+=m[i][j];
//	}
//	count2=sommaR2;
//}
//if(count1==count2) {
//	return true;
//}
//return false;
