package lezioniSilvia.Esercizi;

import java.util.Scanner;

//Verificare se in una matrice quadrata ogni cella è uguale alla somma delle celle che la precedono sulla stessa riga.
public class Esercizio10 {
	static boolean verificaCelle(int[][]m1){
		if(m1.length!=m1[0].length) {
			System.out.println("non è possibile moltiplicare queste due matrici");
			System.exit(-1);	
		}
		boolean verifica=true;
		for(int i=2; i<m1.length; i++) {
			for(int j=0; j<m1[0].length; j++) {
				if(m1[i][j]!=m1[i-1][j]+m1[i-2][j] && verifica) {
					verifica=false;
				}
			}
		}
		return verifica;
	}
	public static void main(String[]args) {
		int[][]m=new int[3][3];
		leggiEScrivi(m);
		System.out.println("La somma cella è uguale alla somma delle celle precedenti? "+verificaCelle(m));
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





//1 1 2 4
//2 2 4 8
//3 3 6 12