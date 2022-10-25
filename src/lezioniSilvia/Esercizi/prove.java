package lezioniSilvia.Esercizi;

public class prove { 
	public static void main(String[]args) {
		int[][] m= {{1,2,3},{4,5,6},{7,8,9}};
		puntiDiSella(m);
		System.out.println("La matrice è un cubo magico? "+ cuboMagico(m));
	}
	static void puntiDiSella(int[][]m) {
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
				
				System.out.println("Il punto di sella è: " +min+" in posizione: "+posizione[0]+","+posizione[1]);
			}
		}
	}
	static boolean cuboMagico(int[][]m) {
		int costanteMagica=0;
		for (int i=0; i<m.length; i++) {
			int diagonale=0;
			int righe=0;
			int colonne=0;
			for(int j=0; j<m[i].length; j++) {
				righe+=m[i][j];
				colonne+=m[j][i];
				if(i==j) {
					diagonale+=m[i][j];
				}
				if(i==0) {
					costanteMagica=righe;
				}
				if(costanteMagica!=righe || costanteMagica!= colonne) {
					//System.out.print(false);
					return false;
				}
				if(costanteMagica!=diagonale) {
					//System.out.print(false);
					return false;
				}
			}
		}
		//System.out.print(true);
		return true;
	}
}