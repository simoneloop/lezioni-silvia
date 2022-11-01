package lezioniSilvia.Esercizi;

public class Esercizio12 {
	//data una matrice quadrata istanziata nel main verificare che la somma delle celle sopra la diagonale principale è maggiore della somma delle celle
	//sotto la diagonale principale
	
//	-1- 2 3 4   sopra la diag principale=24=2+3+4+4+5+6
//	2 -3- 4 5
//	3 4 -5- 6
//	3 5 6 -7-
// 			 sotto la diag principale =23 =2+3+4+3+5+6

	static boolean verificaSomme(int[][]m) {
		int sommaSup=0;
		int sommaInf=0;
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++) {
				if(i!=j){
					if(i>j) {
						sommaInf+=m[i][j];
					}
					else {
						sommaSup+=m[i][j];
				
					}
				}
			}
		}
		if(sommaSup>sommaInf) {
			System.out.println("Stampa somma superiore "+sommaSup);
			System.out.println("Stampa somma inferiore "+sommaInf);
			return true;
		}
		return false;	
	}
	public static void main(String[]args) {
		int[][]matrix= {{1,100,1,1},
						{2,3,1,1},
						{3,4,5,1},
						{3,5,6,7}};
		System.out.println("La somma del triangolo superiore alla diagonale principale è maggiore della somma del triangolo inferiore della stessa? "+verificaSomme(matrix));
	}
}
