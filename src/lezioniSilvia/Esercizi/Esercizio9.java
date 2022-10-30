package lezioniSilvia.Esercizi;
//Verificare se una matrice quadrata di interi è una “scacchiera” ovvero se vi sono presenti solo 0 e 1 alternati tra loro.
import java.util.*;

public class Esercizio9 {
	public static void main(String[]args) { 						//010
		//int[][] matrice= new int[3][3];								//101
											//010 sì scacchiera
		int[][]matrice= {{1,0,1},
				 		{0,1,0},
				 		{1,0,1}};
		//leggiEScrivi(matrice);	
		System.out.println("La matrice è una scacchiera? "+verificaNew(matrice));
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
	
//	static boolean verificaScacchiera(int[][]m) {
//		int prev=m[0][0];
//		if(prev!=0 && prev!=1) {
//			System.out.println("non è una scacchiera");
//			return false;
//		}
//		for(int i=0;i<m.length;i++) {
//			for(int j=0;j<m[0].length;j++) {
//				if(m[i][j]!=0 && m[i][j]!=1) {
//					System.out.println("non è una scacchiera");
//					return false;
//				}
//				else {
//					
//					if(i!=0 ) {
//						if(m[i][j]==prev) {
//							System.out.println("non è una scacchiera");
//							return false;
//						}
//						else {prev=m[i][j];}
//						if(i>0) {
//							if(m[i][j]==m[i-1][j]) {
//								System.out.println("non è una scacchiera");
//								return false;
//							}
//						}
//					}
//					
//					
//				}
//			}
//		}
//		return true;
//		
//	}
	
	static boolean verificaScacchiera(int[][]m) {
		boolean res;
		res=false;
		
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				if(m[i][j]!=1 && m[i][j]!=0) {
					System.out.println("nony è una scacchiera");
					System.exit(-1);
				}
				else {
					if(m[i][j]==0 && !res) {
						res=!res;
					}
					else if(m[i][j]==1 && res) {
						res=!res;
					}
					if(i>0) {
						if(m[i][j]==m[i-1][j]) {
							System.out.println("non è una scacchiera");
							System.exit(-1);
						}
					}
				}
			}
		}
		return true;
	}
	
	static boolean verificaNew(int[][]m) {
		int prev=m[0][0];

		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				if(m[i][j]!=1 && m[i][j]!=0) { //mi assicuro che non ci siano altri elementi se non 0 e 1
					return false;
				}
				//mi assicuro che non sono al primo elemento controllando che o non sono alla riga 0(a qualsiasi colonna va bene allora)
				//o non sono alla colonna 0(va bene a qualsiasi riga allora) 
				//o entrambe
				else if(i!=0 || j!=0) { 
					if(m[i][j]==prev) {//se è uguale al precedente torno false
						return false;
					}
					if(i>0 && m[i-1][j]==m[i][j]) {//se sono dalla seconda riga in poi posso controllare i numeri immediatamente sopra
						return false;
					}
				}
				prev=m[i][j];//aggiorno il precedente
			}
			
		}
		return true;
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
