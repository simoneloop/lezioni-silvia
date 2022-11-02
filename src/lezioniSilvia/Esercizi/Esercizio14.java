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
		boolean[][]m= {{true,false,false},{false,false,true},{false,false,false}};
		System.out.println("La scacchiera ha regine in contrasto tra loro? "+verificaRegine(m));
	}
	
	static boolean verificaRegine(boolean[][]m) throws Exception  {
		for (int i=0;i<m.length; i++) {
			for(int j=0; j<m[0].length; j++) {
				
				
			}
		}
	return true;
	}
}
