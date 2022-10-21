package lezioniSilvia.Esercizi;
//eseguire un algoritmo di ordinamento tuo a piacere
//quindi con ingresso [1,4,3,6,5] -->[1,3,4,5,6]
//ITERATIVAMENTE
public class esercizio4 {
	public static void main(String[]args) {
		int[]lista= {1,4,3,6,5};
		System.out.println("La lista al momento è: ");
		for(int k=0; k<lista.length; k++) {
			System.out.print(lista[k]+ " ");
		}
		for(int i=0; i<lista.length -1; i++) {
			int min=i;
			for(int j=i+1; j<lista.length; j++) {
				if(lista[j]<lista[min]) {
					min=j;
				}
			}	
			int a= lista[min];
			lista[min]=lista[i];
			lista[i]=a;
		}
		System.out.println(" ");
		System.out.println("La lista corretta è: ");
		for(int k=0; k<lista.length; k++) {
			System.out.print(lista[k]+ " ");
		}	
	}
}

