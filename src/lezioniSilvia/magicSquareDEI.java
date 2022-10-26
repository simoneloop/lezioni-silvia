package lezioniSilvia;

public class magicSquareDEI {
	//DIVIDE ET IMPERA
	public static void main(String[] args) {
		
	}
	static boolean isMagicSquareDEI(int[][]m) {
		if(m.length!= m[0].length) {
			System.out.println("Non può essere un quadrato magico perché ha dimensioni diverse");
			System.exit(-1);
		}
		int sommaCol=0;
		int sommaR=0;
		int sommaDiagP=0;
		int sommaDiagS=0;
		
		for(int i=0;i<m.length;i++) {
			int sommaRTmp=0;
			for(int j=0;j<m.length;j++) {
				sommaRTmp+=m[i][j];
			}
			if(sommaR!=0 && sommaR!=sommaRTmp) {
				return false;
			}
			else {
				sommaR=sommaRTmp;
			}
		}
		
		
		
		for(int i=0;i<m.length;i++) {
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
			else {
				sommaCol=sommaCTmp;
			}
		}
		for(int i=0;i<m.length;i++) {
			sommaDiagP+=m[i][i];
			sommaDiagS+=m[i][m.length-1-i];
		}
		if(sommaDiagP==sommaDiagS && sommaDiagS==sommaCol) {
			return true;
		}
		else {
			return false;
		}
		
		
	}

}
