package lezioniSilvia.Esercizi;
import java.util.*;
public class Esercizio7 {
	//Programma per matrici e si richiede di implementare i seguenti metodi
	
	//il metodo leggi(m) riceve una matrice già allocata nel main e provvede a 
	//riempirla attraverso letture da input
	static void leggi(int[][]m) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Inserisci i 9 valori che compongono la matrice 3x3: ");
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				m[i][j]=sc.nextInt();
			}
		}
	}
	static void stampaArray(int[]posizione) {
		for(int j=0;j<posizione.length;j++) {
			System.out.print(" "+posizione[j]);
		}
		System.out.println();
	}
	
	//il metodo scrivi(m) riceve una matrice e ne visualizza il contenuto come meglio credi //fatto
	static void scrivi(int[][]m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {
				System.out.print(" "+m[i][j]);
			}
			System.out.println();
		}
	}
	
	//il metodo trasposta(m) riceve una matrice m, costruisce e ritorna una "nuova" matrice 
	//con il contenuto trasposto di m
	static int[][] trasposta(int[][]m){
		int[][]mTras= new int[3][3];
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[i].length; j++) {
				mTras[j][i]=m[i][j];
			}
		}
		System.out.println("La matrice trasposta è: ");
		scrivi(mTras);
		return mTras;
	}
	
	//fa la moltiplicazione //fatto è possibile fissarne una senza inserirle tutte due da input
	static int[][] moltiplica(int[][]m1,int[][]m2){
		if(m1.length!=m2[0].length) {
			System.out.println("non è possibile moltiplicare queste due matrici");
			System.exit(-1);
		//questo controllo va bene perché sappiamo che le due matrici hanno stessa dimensione	
		}
		int [][]matrixRes=new int[m1.length][m1.length];
		for(int i=0;i<m1.length;i++) {
			for(int j=0;j<m1[0].length;j++) {
				int res=0;
				for(int k=0;k<matrixRes.length;k++) {
					res=res+m1[i][k]*m2[k][j];
				}
				matrixRes[i][j]=res;
			}
		}
		System.out.println("Il risultato della moltiplicazione tra m1 ed m2 è pari alla matrice: ");
		scrivi(matrixRes);
		return matrixRes;
	}
	
	//fa la somma //fatto è possibile fissarne una senza inserirle tutte due da input
	static int[][] somma(int[][]m1,int[][]m2){
		if(m1.length!=m2.length || m1[0].length!=m2.length) {
			System.out.println("dimensioni diverse");
			System.exit(-1);
		}
		int[][]res=new int[m1.length][m1[0].length];
		for(int i=0;i<m1.length;i++) {
			for(int j=0;j<m1[0].length;j++) {
				res[i][j]=m1[i][j]+m2[i][j];
			}
		}
		System.out.println("Il risultato della somma tra m1 ed m2 è pari alla matrice: ");
		scrivi(res);
		return res;
	}
	
	//ritorna una nuova matrice dove ogni elemento di m1 è moltiplicato per uno scalare
	static int[][]moltiplicaScalare(int[][]m1,int s){
		int[][]pScalare=new int[3][3];
		for(int i=0;i<m1.length;i++) {
			for(int j=0;j<m1[0].length;j++) {
				pScalare[i][j]=m1[i][j]*s;
				
			}
		}
		System.out.println("Il risultato del prodotto tra m1 ed s è pari alla matrice: ");
		scrivi(pScalare);
		return pScalare;
	}
	
	//una matrice quadrata è simmetrica se coincide con la sua trasposta
	static boolean simmetrica(int[][]m) {
		int[][]t= trasposta(m);
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				if(t[i][j]==m[i][j]) {
//					System.out.println("La matrice m1 è simmetrica? ");
//					System.out.println(true);
					return true;
				}
			}
		}
//		System.out.println("La matrice m1 è simmetrica? ");
//		System.out.println(false);
		return false;
	}
	//il metodo restituisce i punti di sella di una matrice 
	//i punti di sella sono quegli indici che corrispondo ad un punto che sia maggiore di tutti i valori nella 
	//sua riga ma minore di tutti i valori nella sua colonna

	
	static int[] puntiDiSella(int[][]m) {
		int[]posizione= new int[2];
		for(int i=0; i<m.length; i++) {
			int min= m[i][0];
			int indice=0;
			boolean condizione= true;
			for(int j=1; j<m[i].length; j++) {
				if(m[i][j]<min) {
					min=m[i][j];
					indice=j;
				}
			}
			for (int j=0; j<m.length; j++) {
				if(m[j][indice]>min) {
					condizione= false;
				}	
			}
			if(condizione) {
				posizione[0]=i;
				posizione[1]=indice;
			}	
		}
		System.out.println("La posizione del punto di sella è: ");
		stampaArray(posizione);
		return posizione;		
	}
	
	//Quadrato magico:
	//una matrice quadrata si chiama quadrato magico se la somma degli elementi di una qualsiasi riga, di una qualsiasi colonna, delle due diagonali è sempre la stessa, "costante magica"
//	1,1,1
//	1,1,1
//	1,1,1
//costante magica =3
	
	static boolean isMagicSquare(int[][]m){
		if(m.length!= m[0].length) {
			System.out.println("Non può essere un quadrato magico perché ha dimensioni diverse");
			System.exit(-1);
		}
		int costanteMagica=0;
		int diagonale=0;
		for (int i=0; i<m.length; i++) {
			
			int righe=0;
			int colonne=0;
			for(int j=0; j<m[i].length; j++) {
				righe+=m[i][j];
				colonne+=m[j][i];
				if(i==j) {
					diagonale+=m[i][j];
				}
				
			}
			
			if(i==0) {
				costanteMagica=righe;
			}
			if(costanteMagica!=righe || costanteMagica!= colonne) {
				//System.out.print(false);
				return false;
			}
			
		}
		if(costanteMagica!=diagonale) {
			//System.out.print(false);
			return false;
		}
		//System.out.print(true);
		return true;

	}
	
	
	static boolean isMagicSquareDEI(int[][]m){
		if(m.length!= m[0].length) {
			System.out.println("Non può essere un quadrato magico perché ha dimensioni diverse");
			System.exit(-1);
		}
		int sommaCol=0;
		int sommaR=0;
		int sommaDiagP=0;
		int sommaDiagS=0;
		
		
		for (int i=0;i<m.length;i++) {
			int sommaRTmp=0;
			for(int j=0;j<m.length;j++) {
				sommaRTmp+=m[i][j];
			}
			if(sommaR!=0 && sommaR!=sommaRTmp) {
				return false;
			}
			else {sommaR=sommaRTmp;}
			
		}
		
		
		
		for (int i=0;i<m.length;i++) {
			int sommaCTmp=0;
			for(int j=0;j<m.length;j++) {
				sommaCTmp+=m[j][i];
			}
			if(sommaCol!=0 && sommaCol!=sommaCTmp) {
				return false;
			}
			else if(sommaCol!=0 &&sommaCol!=sommaR) {
				return false;
			}
			else {sommaCol=sommaCTmp;}
		}
		

		for(int i=0;i<m.length;i++) {
			sommaDiagP+=m[i][i];
			sommaDiagS+=m[i][m.length-1-i];
		}
		
		if(sommaDiagP==sommaDiagS && sommaDiagS==sommaCol) {
			return true;
		}
		else {return false;}
		

	}
	
	public static void main(String []args) {
		//che implementi tutti i metodi sopra creati
		int [][]m1= new int[3][3];
		int [][]m2= {{1,1,1},{1,1,1},{1,1,1}};
		leggi(m1);
		scrivi(m1);
		trasposta(m1);
		moltiplica(m1,m2);
		somma(m1,m2);
		moltiplicaScalare(m1,2);
		System.out.println("La matrice m1 è simmetrica? "+simmetrica(m1));
		puntiDiSella(m1);
		System.out.println("La matrice è un quadrato magico? "+isMagicSquare(m1));
		

		
		
	}
}
