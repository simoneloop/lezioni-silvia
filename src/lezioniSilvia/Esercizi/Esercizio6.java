package lezioniSilvia.Esercizi;
//la ricerca binaria VERA
public class Esercizio6 {
	public static void main(String[]args) {
		int[]lista= {1,4,7,12,19,23,24,52,98};
		int x= 24;
		//{19,23,24,52,98}
		System.out.println("Il valore x= "+x+" è in posizione= "+ricercaBinaria(lista,x));
	}
	static int ricercaBinaria(int[]lista, int x) {
		int y= -1; //se non dovesse esserci l'elemento ci restituisce -1
		int min= 0;
		int max = lista.length-1;
		while (y== -1 && min <= max){
			int centro = (min+max)/2;
			if (lista[centro]==x) { // trovato
				y = centro;
			}
			else {
				if (x > lista[centro]) { // continua a destra
					min = centro + 1;
				}	
				else { // continua a sinistra
					max = centro - 1;
				}
			}
		}
		return y;
	}	
}

//x=8
//0-8 =mediana 4----7
//x>array[4]
//[1,2,3,4,5,6,7,8,9]
