package lezioniSilvia.Collezioni;

import java.util.ArrayList;

import lezioniSilvia.Eccezioni.EccezioneIndiceNonValido;
import lezioniSilvia.Eccezioni.EccezioneListaVuota;

public class ListaConcatenataInt {
	
	private NodoInt testa;
	private NodoInt coda;
	private int lunghezza;
	
	private void inizializza() {
		testa=null;
		coda=null;
		lunghezza=0;
	}
	
	public ListaConcatenataInt() {
		inizializza();
	}
	
	public ListaConcatenataInt(ListaConcatenataInt l) {
		inizializza();
		for(NodoInt n=l.testa;n!=null;n=n.getSuccessivo()) {
			aggiungiInCoda(n.getInfo());
		}
	}
	
	public NodoInt getCoda() {
		return coda;
	}
	public NodoInt getTesta() {
		return testa;
	}
	
	public void svuota() {
		inizializza();
	}

	
	
	
	public ListaConcatenataInt(ArrayList<Integer>a) {
		inizializza();
		
		for(int v:a) {
			aggiungiInCoda(v);
		}
	}
	
	public ListaConcatenataInt(Integer[] a) {
		inizializza();
		
		for(int v:a) {
			aggiungiInCoda(v);
		}
	}
	
	public int getLunghezza() {
		return lunghezza;
	}
	
	
	public void aggiungiInCoda(int info) {
		NodoInt nuovoNodo=new NodoInt(info,null);
		if(eVuota()) {
			testa=nuovoNodo;
			coda=nuovoNodo;
		}
		else {
			coda.setSuccessivo(nuovoNodo);
			coda=nuovoNodo;
		}
		lunghezza++;
	}
	public void aggiungiInTesta(int info) {
		NodoInt nuovoNodo=new NodoInt(info,null);
		if(eVuota()) {
			testa=nuovoNodo;
			coda=nuovoNodo;
		}
		else {
			nuovoNodo.setSuccessivo(testa);
			testa=nuovoNodo;
		}
		lunghezza++;
	}
	
	public boolean eVuota() {
		return lunghezza==0;
	}
	
	public String toString() {
		String s="[";
		for(NodoInt n=testa;n!=null;n=n.getSuccessivo()) {
			s+=n;
			if(n.getSuccessivo()!=null) {
				s+=", ";
			}
		}
		s+="]";
		return s;
	}
	
	public void rimuoviTesta() {
		if(eVuota()) {
			throw new EccezioneListaVuota();
		}
		if(lunghezza==1) {
			inizializza();
			return;
		}
		testa=testa.getSuccessivo();
		lunghezza--;
		if(testa==null) {
			coda=null;
		}
	}
	
	public void rimuoviCoda() {
		if(eVuota()) {
			throw new EccezioneListaVuota();
		}
		if(lunghezza==1) {
			inizializza();
			return;
		}
		for(NodoInt n=testa; n!=null;n=n.getSuccessivo()) {
			if(n.getSuccessivo()==coda) {
				n.setSuccessivo(null);
				coda=n;
			}
		}
		lunghezza--;
	}
	
	public ListaConcatenataInt listaInvertita() {
		ListaConcatenataInt ret=new ListaConcatenataInt();
		for(NodoInt n=testa;n!=null;n=n.getSuccessivo()) {
			ret.aggiungiInTesta(n.getInfo());
		}
		return ret;
	}
	
	public int get(int indice) {
		if(indice<0 || indice>lunghezza) {
			throw new EccezioneIndiceNonValido();
		}
		NodoInt n=testa;
		for(int i=0;i<indice;i++) {
			n=n.getSuccessivo();
		}
		return n.getInfo();
	}
	
	public void rimuovi(int indice){
		if(indice<0 || indice>lunghezza) {
			throw new EccezioneIndiceNonValido();
		}
		if(indice==0) {
			rimuoviTesta();
			return;
		}
		if(indice==lunghezza-1) {
			rimuoviCoda();
			return;
		}
		NodoInt n=testa;
		for(int i=0;i<indice-1;i++) {
			n=n.getSuccessivo();
		}
		n.setSuccessivo(n.getSuccessivo().getSuccessivo());
		lunghezza--;
	}
	
	public int contaElementiSpeciali(int b) {
		if(testa==null) {
			return 0;
		}
		return contaElementiSpeciali(testa,b,0,0);
	}
	private int contaElementiSpeciali(NodoInt nodo,int b, int sommaPrecedenti, int contatore ) {
		if(nodo==null) {
			return contatore;
		}
		if(nodo.getInfo()> b-sommaPrecedenti) {
			return contaElementiSpeciali(nodo.getSuccessivo(),b, sommaPrecedenti+nodo.getInfo(), contatore+1);
		}
			
		return contaElementiSpeciali(nodo.getSuccessivo(),b, sommaPrecedenti+nodo.getInfo(),contatore);
	}
	
	public void rimuoviPrimo(int info) {
		if(eVuota()) {
			return;
		}
		if(testa.haInfo(info)) {
			rimuoviTesta();
			return;
		}
		for(NodoInt n=testa;n!=null;n=n.getSuccessivo()) {
			NodoInt successivoAdN=n.getSuccessivo();
			if(successivoAdN!=null && successivoAdN.haInfo(info)) {
				n.setSuccessivo(successivoAdN.getSuccessivo());
				if(successivoAdN==coda) {
					coda=n;
				}
				lunghezza--;
				return;
			}
		}
	}
	
	public void rimuoviTutti(int info) {
		if(eVuota()) {
			return;
		}
		while(testa!=null &&testa.haInfo(info)) {
			rimuoviTesta();
		}
		NodoInt n=testa;
		while(n!=null) {
			NodoInt successivoAdN=n.getSuccessivo();
			if(successivoAdN!=null && successivoAdN.haInfo(info)) {
				n.setSuccessivo(successivoAdN.getSuccessivo());
				lunghezza--;
				if(successivoAdN==coda) {
					coda=n;
				}	
			}
			else {
				n=successivoAdN;
			}
		}
	}
	
	public int indiceDi(int info) {
		int pos=0;
		for(NodoInt n=testa;n!=null;n=n.getSuccessivo()) {
			if(n.haInfo(info)) {
				return pos;
			}
			pos++;
		}
		return -1;
	}
	
	public int[] indiceDiTutti(int info) {
		int cnt=conta(info);
		if(cnt==0) {
			return null;
		}
		int [] ret=new int[cnt];
		int posLibera=0;
		int indiceLista=0;
		for(NodoInt n=testa;n!=null;n=n.getSuccessivo()) {
			if(n.haInfo(info)) {
				ret[posLibera]=indiceLista;
				posLibera++;
			}
			indiceLista++;
		}
		return ret;
	}
	
	public boolean contiene(int info) {
		return indiceDi(info)!=-1;
	}
	
	public ArrayList<Integer> adArrayList(){
		ArrayList<Integer>res=new ArrayList<>();
		for(NodoInt n=testa;n!=null;n=n.getSuccessivo()) {
			res.add(n.getInfo());
		}
		return res;
		
	}
	public int[] adArray() {
		if(eVuota()) {
			throw new EccezioneListaVuota();
		}
		int [] res=new int[lunghezza];
		int posLibera=0;
		for(NodoInt n=testa;n!=null;n=n.getSuccessivo()) {
			res[posLibera]=n.getInfo();
			posLibera++;
		}
		return res;
	}
	
	
	private int contaDa(NodoInt n,int info) {
		if(n==null) {
			return 0;
		}
		return (n.haInfo(info)?1:0)+contaDa(n.getSuccessivo(),info);
	}
	
	public int conta(int info) {
		return contaDa(testa,info);
	}
	
	public boolean equals(Object o) {
		if(o==null) {return false;}
		if(o==this) {return true;}
		if(!(o instanceof ListaConcatenataInt)) {
			return false;
		}
		ListaConcatenataInt l=(ListaConcatenataInt) o;
		if(this.lunghezza!=l.lunghezza) {return false;}
		NodoInt n=testa;
		NodoInt nl=l.testa;
		
		while(n!=null ) {
			if(n.getInfo()!=nl.getInfo()) {
				return false;
			}
			n=n.getSuccessivo();
			nl=nl.getSuccessivo();
		}
		return true;
	}
	
	public int somma() {
		return sommaDa(testa);
	}
	
	private int sommaDa(NodoInt n) {
		if(n==null) {
			return 0;
		}
		return n.getInfo()+sommaDa(n.getSuccessivo());
	}
	
	private int minimoDa(NodoInt n) {
		NodoInt successivoAdN=n.getSuccessivo();
		if(successivoAdN==null) {
			return n.getInfo();
		}
		return Math.min(n.getInfo(), minimoDa(successivoAdN));
	}
	
	public int minimo() {
		if(eVuota()) {
			throw new EccezioneListaVuota();
		}
		return minimoDa(testa);
	}
	
	private int massimoDa(NodoInt n) {
		NodoInt successivoAdN=n.getSuccessivo();
		if(successivoAdN==null) {
			return n.getInfo();
		}
		return Math.max(n.getInfo(), massimoDa(successivoAdN));
	}
	
	public int massimo() {
		if(eVuota()) {
			throw new EccezioneListaVuota();
		}
		return massimoDa(testa);
	}
	
//APPELLO 11/07/2022
//Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo boolean 
//verificaOrdinamento() che verifica se la lista ?? formata da sequenze di valori positivi e negativi che soddisfano 
//le seguenti condizioni:
//	??? tutte le sequenze di valori positivi sono ordinate in modo crescente;
//	??? tutte le sequenze di valori negativi sono ordinate in modo decrescente.
//Ad esempio, la lista [2, 3, 7, -1, -3, -4, -5, 8, 11, 20] soddisfa la condizione,
//mentre la lista [2, 3, 7, -1, -3, -2] non la soddisfa. 
//Il metodo verificaOrdinamento dovr?? essere ricorsivo o invocare un opportuno metodo ricorsivo sulla classe NodoInt.
	public boolean verificaOrdinamento() {
		if(testa==null) {
			return false;
		}
		return verificaOrdinamento(testa, testa.getSuccessivo(), true);
	}
	private boolean verificaOrdinamento(NodoInt nodo, NodoInt successivo, boolean condizione) {
		if(successivo==null) {
			return condizione;
		}
		if(nodo.getInfo()>0 && successivo.getInfo()>0 || nodo.getInfo()<0 && successivo.getInfo()>0 ) {
			if(nodo.getInfo()<successivo.getInfo()) {
				return verificaOrdinamento(successivo,successivo.getSuccessivo(),true);
			}
			condizione=false;
		}
		else if(nodo.getInfo()<0 && successivo.getInfo()<0 || nodo.getInfo()>0 && successivo.getInfo()<0) {
			if(nodo.getInfo()>successivo.getInfo()) {
				return verificaOrdinamento(successivo,successivo.getSuccessivo(),true);
			}
			condizione=false;
		}
		return condizione;
	}
//	public static void main(String[] args) {
//		Integer []a={2,3,7-1,-3,-4,-5,8,11,20};
//		ListaConcatenataInt lista=new ListaConcatenataInt(a);
//		System.out.println("res: "+lista.verificaOrdinamento());
//	}
	
	public int contaTriple() {
		if(testa==null) {
			return 0;
		}
		return contaTriple(testa,0);
	}
	private int contaTriple(NodoInt nodo,int contatore) {
		while(nodo.getSuccessivo()!=null && nodo.getSuccessivo().getSuccessivo()!=null) {
			if(nodo.getInfo()>0) {
				return contaTriple(nodo.getSuccessivo(), contatore);
			}
			if(nodo.getSuccessivo().getInfo()!=0) {
				return contaTriple(nodo.getSuccessivo(), contatore);
			}
			if(nodo.getSuccessivo().getSuccessivo().getInfo()<0) {
				return contaTriple(nodo.getSuccessivo(), contatore);
			}
			contatore++;
			return contaTriple(nodo.getSuccessivo(),contatore);
		}
		return contatore;
	}
	
	
//	Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo boolean listaEquilibrata() che
//	restituisce true se e solo se sono vere entrambe le seguenti condizioni:
//	??? il numero di elementi maggiori di zero ?? uguale al numero di elementi minori di zero;
//	??? la somma di tutti gli elementi ?? pari a zero.
//	Ad esempio, se la lista contiene i valori [5,-3,-4,2,0,-4,4], allora il metodo restituisce true perch??:
//	??? la lista contiene 3 elementi maggiori di zero e 3 elementi minori di zero;
//	??? la somma di tutti gli elementi ?? pari a zero.
//	Il metodo listaEquilibrata dovr?? essere ricorsivo o invocare un opportuno metodo ricorsivo sulla classe NodoInt	
//	APPELLO 21 SETTEMBRE 2022
	public boolean listaEquilibrata() {
		if(testa==null) {
			return false;
		}
		return listaEquilibrata(testa,0,0,0);
	}
	private boolean listaEquilibrata(NodoInt nodo, int negativi, int positivi, int somma) {
		if(nodo==null) {
			return (negativi==positivi && somma==0);
		}
		if(nodo.getInfo()>0) {
			return listaEquilibrata(nodo.getSuccessivo(),negativi, positivi+1, somma+nodo.getInfo());
		}
		else if(nodo.getInfo()<0) {
			return listaEquilibrata(nodo.getSuccessivo(), negativi+1,positivi,somma+nodo.getInfo());
		}
		else {
			return listaEquilibrata(nodo.getSuccessivo(), negativi, positivi, somma);
		}
		
	}
//Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo verifica  che restituisca true se
//e solo se lista ?? ordinata secondo il seguente criterio: ogni numero in posizione pari ?? maggiore del doppio 
//dell???elemento che occupa la posizione pari precedente (se esiste), mentre ogni numero in posizione dispari ?? maggiore
//del triplo dell???elemento che occupa la posizione dispari precedente (se esiste). 
//Il metodo verifica dovr?? essere ricorsivo o invocare un opportuno metodo ricorsivo sulla classe NodoInt. 
//APPELLO 15/02/2022
	public boolean verifica() {
		if(testa==null && lunghezza<3) {
			return false;
		}
		return verifica(testa,testa.getInfo(),testa.getSuccessivo().getInfo());
	}
	public boolean verifica(NodoInt nodo, int precedentePari, int precedenteDispari) {
		if(nodo.getSuccessivo()==null || nodo.getSuccessivo().getSuccessivo()==null || nodo.getSuccessivo().getSuccessivo().getSuccessivo()==null) {
			return true;
		}
		NodoInt successivo=nodo.getSuccessivo().getSuccessivo();
		if(successivo.getInfo()>2*precedentePari && successivo.getSuccessivo().getInfo()>3*precedenteDispari) {
			return verifica(successivo, successivo.getInfo(),successivo.getSuccessivo().getInfo());
		}
		return false;
	}
	
	public boolean verifica2() {
		if(testa==null && lunghezza<3) {
			return false;
		}
		return verifica2(testa.getSuccessivo().getSuccessivo(),testa.getInfo(),testa.getSuccessivo().getInfo(),true);
	}
	private boolean verifica2(NodoInt nodo, int precedentePari, int precedenteDispari, boolean isPari) {
		if(nodo==null) {
			return true;
		}
		else if(isPari) {
			if(nodo.getInfo()>precedentePari*2) {
				return verifica2(nodo.getSuccessivo(),nodo.getInfo(),precedenteDispari,false);
			}
			else {
				return false;
			}
		}
		else {
			if(nodo.getInfo()>precedenteDispari*3) {
				return verifica2(nodo.getSuccessivo(),precedentePari,nodo.getInfo(),true);
			}
			else{
				return false;
			}
		}
	}
	
	
//Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo ordinataTratti che restituisca 
//true se e solo se lista ?? ???ordinata a tratti???. Ossia, scorrendo la lista dall???inizio alla fine, i valori devono essere 
//ordinati in senso crescente fino a che non viene incontrato il numero ???delimitatore??? 0 o viene raggiunta la fine 
//della lista. Dopo ogni occorrenza del delimitatore 0, il senso di ordinamento viene invertito: se prima era crescente, 
//diventa decrescente; se prima era decrescente, diventa crescente. Si assuma che nel primo tratto l???ordinamento debba 
//essere crescente. Si assuma inoltre che una lista vuota soddisfi la propriet?? verificata da ordinataTratti. 
//Il metodo ordinataTratti dovr?? essere ricorsivo o invocare un opportuno metodo ricorsivo sulla classe NodoInt. 
//APPELLO 27/01/2021
	public boolean ordinataTratti() {
		if(testa==null){
			return false;
		}
		return ordinataTratti(testa,testa.getSuccessivo(),true);
	}
	private boolean ordinataTratti(NodoInt nodo, NodoInt successivo, boolean crescente) {
		if(nodo!=null && successivo!=null) {
			if(crescente) {
				if(nodo.getInfo()<successivo.getInfo() && successivo.getInfo()!=0) {
					return ordinataTratti(nodo.getSuccessivo(), successivo.getSuccessivo(), true);
				}
				else if(successivo.getInfo()==0) {
					return ordinataTratti(nodo.getSuccessivo().getSuccessivo(), successivo.getSuccessivo().getSuccessivo(), false);
				}
				else{
					return false;
				}
			}
			else {
				if(nodo.getInfo()>successivo.getInfo() && successivo.getInfo()!=0) {
					return ordinataTratti(nodo.getSuccessivo(), successivo.getSuccessivo(), false);
				}
				else if(successivo.getInfo()==0) {
					return ordinataTratti(nodo.getSuccessivo().getSuccessivo(), successivo.getSuccessivo().getSuccessivo(), true);
				}
				else{
					return false;
				}
			}		
		}
		return true;
	}

//Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo contaElementi che restituisca 
//il numero di elementi della lista che sono minori o uguali alla media aritmetica tra l???elemento precedente e l???elemento 
//successivo. Si assuma che il primo elemento della lista ?? preceduto da 0 e che all???ultimo elemento della lista succede 
//il valore 0. Il metodo contaElementi dovr?? essere ricorsivo o invocare un opportuno metodo ricorsivo sulla classe NodoInt. 
//APPELLO 23 LUGLIO 2020
	public int contaElementi() {
		if(testa==null) {
			return 0;
		}
		if (lunghezza==1) {
			return contaElementi(testa,0,0);
		}
		return contaElementi(testa,0,testa.getSuccessivo().getInfo());
	}
	private int contaElementi(NodoInt nodo, int precedente, int successivo) {
		int contatore=0;
		if(nodo.getInfo()<=(precedente+successivo)/2) {
			contatore++;
		}
		NodoInt nodoSuccessivo=nodo.getSuccessivo();
		if(nodoSuccessivo!= null) {
			if(nodoSuccessivo.getSuccessivo()!= null)
				return contatore+contaElementi(nodoSuccessivo, nodo.getInfo(), nodoSuccessivo.getSuccessivo().getInfo());
			else {
				return contatore+contaElementi(nodoSuccessivo, nodo.getInfo(),0);
			}
		}
		return contatore;
	}
	
//Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo verifica() che restituisce true
//se e solo se la lista contiene esattamente una volta il valore zero e, dopo di esso, non contiene valori negativi.
//Il metodo verifica dovr?? essere ricorsivo o invocare un opportuno metodo ricorsivo sulla classe NodoInt.
//APPELLO 20 LUGLIO 2021
	public boolean verifica1() {
		if(testa==null) {
			return false;
		}
		return verifica1(testa,true);
	}
	private boolean verifica1(NodoInt nodo, boolean bc) {
		if(nodo!=null) {
			if(bc) {
				if(nodo.getInfo()==0) {
					return verifica1(nodo.getSuccessivo(),false);
				}
			}
			else {
				if(nodo.getInfo()==0) {
					return false;
				}                               //oppure if(nodo.getInfo()<1)
				else if(nodo.getInfo()<0) {
					return false;
				}
				else {
					return verifica1(nodo.getSuccessivo(), false);
				}
			}
		}
		return true;
	}
//Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo alternati che restituisca true se 
//e solo se, scorrendo la lista dall???inizio alla fine, si incontrano valori alternati positivi e negativi. 
//In altri termini, per ogni nodo deve valere che: se esso contiene un valore positivo, allora il successivo (se esiste) 
//contiene un valore negativo, e viceversa. Si assuma inoltre che una lista vuota soddisfi la propriet?? verificata 
//da alternati. 
//Il metodo alternati dovr?? essere ricorsivo o invocare un opportuno metodo ricorsivo sulla classe NodoInt. 	
//APPELLO 03 LUGLIO 2020
	public boolean alternati() {
		if(testa==null) {
			return true;
		}
		return alternati(testa,testa.getSuccessivo());
	}
	private boolean alternati(NodoInt nodo, NodoInt successivo) {
		if(nodo!=null || successivo!=null) {
			if(nodo.getInfo()<0 && successivo.getInfo()>0) {
				return alternati(nodo.getSuccessivo(), successivo.getSuccessivo());
			}
			else if(nodo.getInfo()>0 && successivo.getInfo()<0) {
				return alternati(nodo.getSuccessivo(), successivo.getSuccessivo());
			}
			else {
				return false;
			}
		}
		return true;
	}
//Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo stesseSottosequenze che
//restituisca true se e solo se sono verificate entrambe le seguenti condizioni:
//	1.	la lista non ?? vuota e la sua lunghezza ?? pari;
//	2.	se un nodo (ad eccezione degli ultimi due) si trova in posizione i  e contiene il valore n, allora il nodo che si trova in posizione i+2 contiene lo stesso valore n.
//Ad esempio, la lista [7,2,7,2,7,2] soddisfa entrambe le condizioni di cui sopra. 
//Il metodo stesseSottosequenze dovr?? essere ricorsivo o invocare un opportuno metodo ricorsivo sulla classe NodoInt. 
//APPELLO 16 SETTEMBRE 2020
	public boolean stesseSottosequenze() {
		if(testa==null) {
			return false;
		}
		if(lunghezza%2!=0) {
			return false;
		}
		return stesseSottosequenze(testa,testa.getSuccessivo(),testa.getSuccessivo().getSuccessivo());
	}
	private boolean stesseSottosequenze(NodoInt nodo, NodoInt dispari, NodoInt pari) {
		if(pari!=null) {
			if(nodo.getInfo()==pari.getInfo()) {
				return stesseSottosequenze(dispari,pari,pari.getSuccessivo());
			}
			else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Integer []a={7,2,7,2,7,2};
		ListaConcatenataInt lista=new ListaConcatenataInt(a);
		System.out.println("res: "+lista.stesseSottosequenze());
	}
}
