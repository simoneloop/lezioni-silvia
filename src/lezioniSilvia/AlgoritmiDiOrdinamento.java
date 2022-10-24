package lezioniSilvia;

public class AlgoritmiDiOrdinamento {
	//BubbleSort
	//InsertionSort
	//SelectionSort
	public static void main(String[]args) {
		int[]v={-1,1,4,6,5,3,8,2,7,0,1};
		int x=7;
		selectionSort(v);
		for(int i=0;i<v.length;i++) {
			System.out.print(v[i]);
		}
	}
	static int[] bubbleSort(int []a) {
		for(int j=a.length-1;j>=1;j--) {
			for(int i=0;i<j;i++) {
				if(a[i]>a[i+1]) {//scambiamo a[i] con a[i+1]
					int tmp=a[i];
					a[i]=a[i+1];
					a[i+1]=tmp;
					
				}
			}
		}
		
		return a;
	}
	
	//piccola ottimizzazione: può essere interroto in modo da fermarsi dopo una scansione che non ha portato nessuno scambio
	static int[] bubbleSortOttimizzato(int []a) {
		for(int j=a.length-1;j>=1;j++) {
			int scambi=0;
			for(int i=0;i<j;i++) {
				if(a[i]>a[i+1]) {
					int tmp=a[i];
					a[i]=a[i+1];
					a[i+1]=tmp;
					scambi++;
				}
			}
			if(scambi==0)break;
		}
		return a;
	}
	//[-1,-2,-3,-4]
	//si consideri tutto l'array: si cerca l'indice del massimo, quindi si scambiano il massimo con l'ultimo elemento
	//a questo punto si prende in esame tutto l'array tranne l'ultimo elemento e si riapplica la tecninca
	//si ripete finche la parte da esaminare è costituita solo da un elemento dell'array
	static int[] selectionSort(int[]a) {
		for(int j=a.length-1;j>0;j--) {
			int iMax=0;
			for(int i=1;i<=j;i++) {
				if(a[i]>a[iMax]) {
					iMax=i;
				}
			}
			int tmp=a[iMax];
			a[iMax]=a[j];
			a[j]=tmp;
		}
		return a;
	}
	//considera il generico x elemento dell'array
	//e ricerca per esse la posizione corretta nella porzione di array a sinistra della posizione di x
	//sposta di un posto a destra tutti gli elementi dell'array che sono maggiori di x
	//la posizione di inserimento finale sarà quella a destra del primo elemento che non sia maggiore di x
	static int[] insertionSort(int[]a) {
		for(int i=0;i<a.length;i++) {
			int x=a[i];
			int j=i;
			while(j>0 && a[j-i]>x) {
				a[j]=a[j-1];j--;
			}
			a[j]=x;
		}
		return a;
	}
	
	//nel peggiore dei casi ovvero array ordinato nel modo opposto a quanto desiderato  [3,2,1,0] es
	//tutti e tre i metodi hanno complessità O(n^2)

}
