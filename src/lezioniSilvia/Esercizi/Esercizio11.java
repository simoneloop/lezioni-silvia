package lezioniSilvia.Esercizi;

public class Esercizio11 {
	//Verificare se in una matrice quadrata(istanziata nel main) ogni cella è uguale alla somma di tutte le celle che la precedono sulla stessa riga
	

	//1 2 3 4 quindi 2==1+null?, 3==1+2?, 4==1+2+3?
	//2 3 4 5
	//3 4 5 6
	//4 5 6 7

//	for(righe)
//		for(colonne)
//			if(colonne>0){
			//	for(0 a colonne-1)
			//	somma=sommaElementi in riga;
			//m[i][j]==somma;
//}
	static boolean verificaCelle(int[][]m) {
		int sommaPrecedenti;
		for(int i=0; i<m.length; i++) {
			int valore=0;
			for(int j=0; j<m[0].length; j++) {
				valore=m[i][j];
				if(j>0) {
					sommaPrecedenti=0;
					for(int k=0; k<=j-1; k++) {
		        		sommaPrecedenti+=m[i][k];
		        	}
					if(valore!=sommaPrecedenti) {
						System.out.println("Elemento= "+valore+" (in posizione "+i+","+j+") e somma precedenti= "+sommaPrecedenti+", sono diversi");
						return false;
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[][]matrix= {{1,1,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};
		System.out.println("La matrice ha tutte le celle uguali alla somma delle celle precedenti? "+verificaCelle(matrix));
	}

}
