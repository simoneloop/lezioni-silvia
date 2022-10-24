package lezioniSilvia.Esercizi;



public class Esercizio7 {
	
	//Programma per matrici e si richiede di implementare i seguenti metodi
	
	//il metodo leggi(m) riceve una matrice già allocata nel main e provvede a riempirla attraverso letture da input
	static void leggi(int[][]m) {}
	
	//il metodo scrivi(m) riceve una matrice e ne visualizza il contenuto come meglio credi //fatto
	static void scrivi(int[][]m) {}
	
	//il metodo trasposta(m) ricweve una matrice m, costruisce e ritorna una "nuova" matrice con il contenuto trasposto di m
	static int[][]trasposta(int[][]m){}
	
	//fa la moltiplicazione //fatto è possibile fissarne una senza inserirle tutte due da input
	static int[][] moltiplica(int[][]m1,int[][]m2){}
	
	//fa la somma //fatto è possibile fissarne una senza inserirle tutte due da input
	static int[][] somma(int[][]m1,int[][]m2){}
	
	//ritorna una nuova matrice dove ogni elemento di m1 è moltiplicato per uno scalare
	static int[][]moltiplicaScalare(int[][]m1,int s){}
	
	//una matrice quadrata è simmetrica se coincide con la sua trasposta
	static boolean simmetrica(int[][]m) {}
	
	
	//il metodo restituisce i punti di sella di una matrice 
	//i punti di sella sono quegli indici che corrispondo ad un punto che sia maggiore di tutti i valori nella sua riga ma minore di tutti i valori nella sua colonna
	//esempio in questo caso il punto di sella è [0,2]
//	123,
//	345,
//	678,
	static int[] puntiDiSella(int[][]m) {}
	
	//Quadrato magico:
	//una matrice quadrata si chiama quadrato magico se la somma degli elementi di una qualsiasi riga, di una qualsiasi colonna, delle due diagonali è sempre la stessa, "costante magica"
//	1,1,1
//	1,1,1
//	1,1,1
//costante magica =3
	static boolean isMagicSquare(int[][]m){}
	
	public static void main(String []args) {
		//che implementi tutti i metodi sopra creati
	}
}
