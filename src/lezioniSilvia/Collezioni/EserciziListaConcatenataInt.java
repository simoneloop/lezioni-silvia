package lezioniSilvia.Collezioni;
//Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo contaElementiSpeciali(int b) 
//che conta quanti elementi speciali sono presenti nella lista; 
//un elemento è detto speciale quando ha valore maggiore della differenza tra b e la somma degli elementi precedenti 
//all'elemento stesso. Ad esempio, se b = 10 e la lista contiene i valori [5,3,1,0,2,-2,4,6,-9], 
//allora il metodo restituisce 3 perché:
//• 2 > 10 – (5+3+1+0);
//• 4 > 10 – (5+3+1+0+2-2);
//• 6 > 10 – (5+3+1+0+2-2+4);
//• nessun altro elemento soddisfa la condizione.
//Il metodo contaElementiSpeciali dovrà essere ricorsivo o 
//invocare un opportuno metodo ricorsivo sulla classe NodoInt.
public class EserciziListaConcatenataInt{
	public static int contaElementiSpeciali(int b, ListaConcatenataInt lista) {
		if(lista.getTesta()==null) {
			return 0;
		}
		return contaElementiSpeciali(lista.getTesta(),b,0,0);
	}
	private static int contaElementiSpeciali(NodoInt nodo,int b, int sommaPrecedenti, int contatore ) {
		if(nodo==null) {
			return contatore;
		}
		if(nodo.getInfo()> b-sommaPrecedenti) {
			System.out.println(nodo.getInfo());
			return contaElementiSpeciali(nodo.getSuccessivo(),b, sommaPrecedenti+nodo.getInfo(), contatore+1);
		}
			
		return contaElementiSpeciali(nodo.getSuccessivo(),b, sommaPrecedenti+nodo.getInfo(),contatore);
	}
	public static void main(String[] args) {
		Integer []a={5,3,1,0,2,-2,4,6,-9};
		ListaConcatenataInt lista=new ListaConcatenataInt(a);
		int b=9;
		System.out.println(lista);
		System.out.println("res: "+lista.contaElementiSpeciali(b));
		
	}

}
