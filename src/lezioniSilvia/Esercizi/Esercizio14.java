package lezioniSilvia.Esercizi;
import lezioniSilvia.Eccezioni.*;
public class Esercizio14 {
	
	//check n_regine
	//data una matrice quadrata di booleani che rappresenta una scacchiera dove il valore true significa che c'è una regina nella cella e false significa cella vuota
	//il metodo torna true se e solo se le n regine non vanno in contrasto tra di loro
	
	
//	[true,false,false]
//	[false,false,true]
//	[false,false,false]	ritorna true
	
//	[true,false,false]
//	[false,false,true]
//	[false,false,true] ritorna false

	
	//al posto di tornare false; lancia MatriceNonValidaException
	public static void main(String[]args) throws Exception {
		boolean[][]m= {{true,true,false},
						{false,false,true},
						{false,false,false}};
		System.out.println("La scacchiera non ha regine in contrasto tra loro? "+verificaRegine(m));
//		System.out.println("Non ci sono altre regine sulla stessa colonna? "+verificaColonne(m));
//		System.out.println("Non ci sono altre regine sulla stessa diagonale? "+verificaDiagonaleDaSxADx(m));
//		System.out.println("Non ci sono altre regine sulla stessa diagonale secondaria? "+verificaDiagonaleDaDxASx(m));
	}
	
	static boolean verificaRegine(boolean[][]m) throws Exception  {
		if(verificaColonne(m) && verificaDiagonaleDaSxADx(m) && verificaDiagonaleDaDxASx(m)) {
			return true;
		}
	return false;
	}
	static boolean verificaColonne(boolean[][]m) {
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++) {
				if(m[i][j]==true) {
					for(int k=i+1; k<m.length; k++) {
						if(m[k][j]==true) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
//	static boolean verificaDiagonaleDaSxADx(boolean[][]m) {
//		for(int i=0; i<m.length; i++) {
//			for(int j=0; j<m[0].length; j++) {
//				if(m[i][j]==true) {
//					for(int k=i+1; k<m.length; k++) {
//						if(m[k][k]==true) {
//							return false;
//						}
//					}
//				}
//			}
//		}
//		return true;
//	}
//	static boolean verificaDiagonaleDaDxASx(boolean[][]m) {
//		for(int i=0; i<m.length; i++) {
//			for(int j=0; j<m[0].length; j++) {
//				if(m[i][j]==true && j>0) {
//					for(int k=j-1; k<m.length-1; k--) {
//						for(int x=i+1; x<m.length-1; x++) {
//							if(m[x][k]==true) {
//								return false;
//							}
//						}
//					}
//				}
//			}
//		}
//		return true;
//	}
	
	static boolean verificaDiagonaleDaDxASx(boolean[][]m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				if(m[i][j]) {
					int x=i+1;
					int k=j-1;
					while(x<=m.length-1 && k>=0) {
						if(m[x][k]) {
							return false;
						}
						else {
							x++;
							k--;
						}
					}
					
					
				}
			}
		}
		return true;
	}
	
	static boolean verificaDiagonaleDaSxADx(boolean[][]m) {
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++) {
				if(m[i][j]) {
					int x=i+1;
					int k=j+1;
					while(x<=m.length-1 && k<=m.length-1) {
						if(m[x][k]) {
							return false;
						}
						else {
							x++;
							k++;
						}
					}
					
				}
			}
		}
		return true;
	}
	
	static boolean verificaRighe(boolean[][]m) {
		for(int i=0;i<m.length;i++) {
			boolean trovata=false;
			for(int j=0;j<m.length;j++) {
				if(m[i][j] &&!trovata) {
					trovata=true;
				}
				else if(m[i][j] && trovata) {
					return false;
				}
			}
		}
		return true;
	}
}