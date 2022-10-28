package lezioniSilvia.Esercizi;

import java.util.Scanner;

public class prove { 
	public static void main(String[]args) {
		int[][]m= new int[3][3];
		leggiEScrivi(m);
		verificaCelle(m);
	}
	static boolean verificaCelle(int[][]m1){
		if(m1.length!=m1[0].length) {
			System.out.println("non è possibile moltiplicare queste due matrici");
			System.exit(-1);	
		}
		boolean verifica=true;
		for(int i=2; i<m1.length && verifica; i++) {
			for(int j=0; j<m1[0].length; j++) {
				if(m1[i][j]<m1[i-1][j]+m1[i-2][j]) {
					verifica=false;
				}
			}
		}
		return verifica;
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
