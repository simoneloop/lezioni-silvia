package lezioniSilvia.Esercizi;
import lezioniSilvia.Esercizi.*;
public class Esercizio13 {

	
	//Matrice di toeplitz
	//Verificare se una matrice quadrata instanziata nel main è Toeplitz
	//Una matrice è Toeplitz se e solo se ogni diagonale(da sinistra verso destra) contiene lo stesso elemento.

//[1,2,3,4]
//[5,1,2,3]
//[9,5,1,2]
//[1,9,5,1]
	
	//se ti muovi come nella diagonale principale stare attenta ai bound della matrice
	
	//al posto di tornare false; lancia MatriceNonValidaException
	public static void main(String[]args) throws Exception {
		int[][]matrix= {{1,2,3,4},{5,1,2,3},{9,5,1,2},{1,9,5,1}};
		System.out.println("E' una matrice Toeplitz? "+verificaTeoplitz(matrix));
	}
	static boolean verificaTeoplitz(int[][]m)throws Exception {
		int res=m[0][0];
		for(int k=0; k<m.length; k++) {
			if(m[k][k]!=res) {
				throw new MatrixError();
			}
			for(int i=0; i<m.length-1; i++) {
				for(int j=0; j<m[0].length-1; j++) {
					if(m[i][j]!=m[i+1][j+1]) {
						throw new MatrixError();
					}
			
				}
			}
		}
		return true;
	}
}
