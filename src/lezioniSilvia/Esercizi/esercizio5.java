package lezioniSilvia.Esercizi;

//creare la ricerca binaria nell'array quindi
//un metodo che si prende un vettore (int[]v,int x) 
//e ritorni se contenuto l'indice di x nel vettore tramite ricerca binaria 
//ITERATIVAMENTE, NELLA RICERCA BINARIA L'ARRAY DEVE ESSERE ORDINATO
//v=[1,2,3,4,5,6,7,8], x=7;
//iniziare dal centro, controllare che il numero non sia uguale, se è minore ripetere sulla metà sinistra
//altrimenti sulla metà destra fino a che non si finiscano i centri o non si trovi l'uguaglianza
public class esercizio5 {
	public static int cercaElemento(int[]v, int x) {
		int max=(v[v.length-1]); //si assegna l'ultimo valore della lista
		int min=v[0]; //si assegna il primo valore della lista
		int valoreMedio=(min+max)/2; //otteniamo il valore medio per cominciare la ricerca binaria
		boolean condizione; //aggiungiamo una condizione
		do {
			if(v[valoreMedio]< x) { //il valore medio<x? sì? allora...
				min=v[valoreMedio]+1;
				valoreMedio=(min+max)/2;
			}
			else if(v[valoreMedio]>x) { //no? allora valoreMedio<x? sì? allora... 
				max=v[valoreMedio]-1;
				valoreMedio=(min+max)/2;		
			}
			else { //no? allora significa che il valore medio è uguale al numero che stiamo cercando
				condizione=false; //se troviamo l'elemento possiamo concludere il ciclo, quindi: 
				return valoreMedio;
			}
			condizione=true;	//altrimenti condizione è uguale a true e.. 
		}
		while(condizione); //ripetiamo finché non si trova il valore x
		return -1; //se non viene trovato l'elemento restituiamo -1
	}
	public static void main(String[]args) {
		int[]v={1,4,6,5,3,8,2,7};
		int x=7;
		ordinaLista(v); //se la lista non è ordinata non si può fare una ricerca binaria
		System.out.print("La lista ordinata è: ");
		for(int k=0; k<v.length; k++) {
			System.out.print(v[k]+ " ");
		}
		System.out.println(" ");
		System.out.println("Il valore "+x+" si trova in posizione "+cercaElemento(v,x));
		
	}
	static int[] ordinaLista(int[]v) {
		for(int i=0; i<v.length -1; i++) {
			int min=i;
			for(int j=i+1; j<v.length; j++) {
				if(v[j]<v[min]) {
					min=j;
				}
			}	
			int a= v[min];
			v[min]=v[i];
			v[i]=a;
		}
		return v;
	}
}
